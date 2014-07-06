package org.mingtaoz.leetcode.toolbox.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	public static class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public class TreeLinkNode {
		public int val;
		public TreeLinkNode left, right, next;

		public TreeLinkNode(int x) {
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

	public int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root, 0);
	}

	// TODO huhuh not sure why it's working, need to revisit
	public int sumNumbersHelper(TreeNode root, int prev) {
		if (root == null)
			return prev;

		int ret = 0;
		if (root.left != null) {
			ret += sumNumbersHelper(root.left, (prev + root.val) * 10);
		}

		if (root.right != null) {
			ret += sumNumbersHelper(root.right, (prev + root.val) * 10);
		}

		if (ret == 0) {
			ret = prev + root.val;
		}

		return ret;
	}

	public int maxPathSum(TreeNode root) {
		Data ret = maxPathSumHelper(root);
		return Math.max(ret.maxCanGrow, ret.maxCantGrow);
	}

	public static class Data {
		public int maxCantGrow;
		public int maxCanGrow;

		public Data() {
		}

		public Data(int maxCantGrow, int maxCanGrow) {
			this.maxCantGrow = maxCantGrow;
			this.maxCanGrow = maxCanGrow;
		}
	}

	public Data maxPathSumHelper(TreeNode node) {
		if (node == null)
			return new Data(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Data left = maxPathSumHelper(node.left);
		Data right = maxPathSumHelper(node.right);
		int maxCanGrow = Math.max(left.maxCanGrow > 0 ? left.maxCanGrow : 0,
				right.maxCanGrow > 0 ? right.maxCanGrow : 0) + node.val;
		int maxCantGrow = Math.max((left.maxCanGrow > 0 ? left.maxCanGrow : 0)
				+ node.val + (right.maxCanGrow > 0 ? right.maxCanGrow : 0),
				Math.max(left.maxCantGrow, right.maxCantGrow)); // TODO this
																// part is
																// tricky

		return new Data(maxCantGrow, maxCanGrow);
	}

	// public List<Integer> postorderTraversalIterativel(TreeNode root) {
	// List<Integer> ret = new LinkedList<Integer>();
	// Stack<TreeNode> stack = new Stack<TreeNode>();
	// TreeNode cur = root, lastVisited = null;
	// while (cur != null || !stack.isEmpty()) {
	// if (cur != null) {
	// stack.push(cur);
	// cur = cur.left;
	// } else {
	// TreeNode parent = stack.peek();
	// if (parent.right != null && lastVisited != parent.right) {
	// // make sure pop all the node has right child of the
	// // previous pop
	// cur = parent.right;
	// } else {
	// stack.pop();
	// ret.add(parent.val);
	// lastVisited = parent;
	// }
	// }
	// }
	// return ret;
	// }

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

	// layers traversal ~= BFS
	// working: both i and ii for populating-next-right-pointers-in-each-node
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> curLayer = new LinkedList<>(), nextLayer = new LinkedList<>();
		TreeLinkNode next = null;
		curLayer.add(root);
		while (!curLayer.isEmpty()) {
			TreeLinkNode cur = curLayer.poll();
			cur.next = next;
			next = cur;
			if (cur.right != null) {
				nextLayer.add(cur.right);
			}
			if (cur.left != null) {
				nextLayer.add(cur.left);
			}
			if (curLayer.isEmpty()) {
				// next layer
				curLayer = nextLayer;
				nextLayer = new LinkedList<>();
				next = null;
			}
		}
	}
}
