package org.mingtaoz.leetcode.toolbox.tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class PushZeroDown {

	public static class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int x) {
			val = x;
		}

		public int leftSpaces(StringBuilder stringBuilder) {
			int leftSpaces = 0;
			if (this.left == null && this.right == null) {
				stringBuilder.insert(0, val + "\n");
				return leftSpaces;
			}
			if (this.left != null) {
				leftSpaces = 2 + left.leftSpaces(stringBuilder);
				stringBuilder.insert(0, "/\n");
				for (int i = 0; i < leftSpaces - 1; i++) {
					stringBuilder.insert(0, " ");
				}
			}
			if (this.right != null) {
				stringBuilder.insert(0, "\\n");
				for (int i = 0; i < leftSpaces - 1; i++) {
					stringBuilder.insert(0, " ");
				}
			}
			stringBuilder.insert(0, val + "\n");
			for (int i = 0; i < leftSpaces; i++) {
				stringBuilder.insert(0, " ");
			}
			return leftSpaces;
		}

		public String toString() {
			StringBuilder stringBuilder = new StringBuilder();
			leftSpaces(stringBuilder);
			return stringBuilder.toString();
		}
	}

	/**
	 * 
	 * push zero down to leaf as far as possible
	 *
	 */
	public void pushZeroDown(TreeNode root) {
		HashSet<TreeNode> finished = new HashSet<TreeNode>();
		sink0(root, new HashMap<TreeNode, TreeNode>(), finished, false);
	}

	public void sink0(TreeNode root, HashMap<TreeNode, TreeNode> parentMap,
			HashSet<TreeNode> finished, boolean zerosOver) {
		if (root.val == 0)
			zerosOver = true;
		if (!zerosOver)
			finished.add(root);

		if (root.left != null) {
			parentMap.put(root.left, root);
			sink0(root.left, parentMap, finished, zerosOver);
		}
		if (root.right != null) {
			parentMap.put(root.right, root);
			sink0(root.right, parentMap, finished, zerosOver);
		}
		if (root.val != 0 && !finished.contains(root)) {
			TreeNode temp = root;
			ArrayDeque<TreeNode> nonZeroNodes = new ArrayDeque<TreeNode>();
			ArrayDeque<TreeNode> nodes = new ArrayDeque<TreeNode>();
			while (temp != null && !finished.contains(temp)) {
				nodes.push(temp);
				if (temp.val != 0)
					nonZeroNodes.push(temp);
				temp = parentMap.get(temp);
			}

			while (!nonZeroNodes.isEmpty()) {
				TreeNode tempNode = nonZeroNodes.pop();
				TreeNode toModify = nodes.pop();
				toModify.val = tempNode.val;
				finished.add(toModify);
			}
			while (!nodes.isEmpty()) {
				TreeNode toModify = nodes.pop();
				toModify.val = 0;
			}
		}
	}
}
