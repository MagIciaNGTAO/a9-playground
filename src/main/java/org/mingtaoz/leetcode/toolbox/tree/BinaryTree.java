package org.mingtaoz.leetcode.toolbox.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (root == null)
			return ret;
		ret.add(root.val);
		ret.addAll(preorderTraversal(root.left));
		ret.addAll(preorderTraversal(root.right));
		return ret;
	}

	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur == null)
				continue;
			ret.add(cur.val);
			stack.push(cur.right);
			stack.push(cur.left);
		}
		return ret;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (root == null)
			return ret;
		ret.addAll(postorderTraversal(root.left));
		ret.addAll(postorderTraversal(root.right));
		ret.add(root.val);
		return ret;
	}

//	public List<Integer> postorderTraversalIterativel(TreeNode root) {
//		List<Integer> ret = new LinkedList<Integer>();
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode cur = root, lastVisited = null;
//		while (cur != null || !stack.isEmpty()) {
//			if (cur != null) {
//				stack.push(cur);
//				cur = cur.left;
//			} else {
//				TreeNode parent = stack.peek();
//				if (parent.right != null && lastVisited != parent.right) {
//					// make sure pop all the node has right child of the
//					// previous pop
//					cur = parent.right;
//				} else {
//					stack.pop();
//					ret.add(parent.val);
//					lastVisited = parent;
//				}
//			}
//		}
//		return ret;
//	}

	public List<Integer> postorderTraversalIterativel(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode parent = stack.peek(), child = null;
				if (parent.right == null) {
					// pop hard
					stack.pop();
					while (parent.right == child && !stack.isEmpty()) {
						child = parent;
						ret.add(child.val);
						parent = stack.pop();
					}
				} else {
					cur = parent.right;
				}
			}
		}
		return ret;
	}
}
