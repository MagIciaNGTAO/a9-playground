package org.mingtaoz.leetcode.toolbox.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// TODO need to read this piece
public class PushZeroDown {

	public static class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int x) {
			val = x;
		}

		public void printNode() {
			int maxLevel = maxLevel(this);

			printNodeInternal(Collections.singletonList(this), 1, maxLevel);
		}

		private void printNodeInternal(List<TreeNode> nodes, int level,
				int maxLevel) {
			if (nodes.isEmpty())
				return;

			int floor = maxLevel - level;
			int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
			int firstSpaces = (int) Math.pow(2, (floor)) - 1;
			int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

			printWhitespaces(firstSpaces);

			List<TreeNode> newNodes = new ArrayList<TreeNode>();
			for (TreeNode node : nodes) {
				System.out.print(node.val);
				if (node.left != null) {
					newNodes.add(node.left);
				}
				if (node.right != null) {
					newNodes.add(node.right);
				}
				// System.out.print(" ");
				// }
				printWhitespaces(betweenSpaces);
			}
			System.out.println("");

			for (int i = 1; i <= endgeLines; i++) {
				for (int j = 0; j < nodes.size(); j++) {
					printWhitespaces(firstSpaces - i);
					if (nodes.get(j) == null) {
						printWhitespaces(endgeLines + endgeLines + i + 1);
						continue;
					}

					if (nodes.get(j).left != null)
						System.out.print("/");
					else
						printWhitespaces(1);

					printWhitespaces(i + i - 1);

					if (nodes.get(j).right != null)
						System.out.print("\\");
					else
						printWhitespaces(1);

					printWhitespaces(endgeLines + endgeLines - i);
				}

				System.out.println("");
			}

			printNodeInternal(newNodes, level + 1, maxLevel);
		}

		private void printWhitespaces(int count) {
			for (int i = 0; i < count; i++)
				System.out.print(" ");
		}

		private int maxLevel(TreeNode node) {
			if (node == null)
				return 0;

			return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
		}

	}

	// test the behavior
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		// stringBuilder.
		stringBuilder.insert(5, "a");

		System.out.println(stringBuilder.toString());
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
			// only care the number of 0s
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
