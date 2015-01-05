package org.mingtaoz.leetcode.tree;

import java.util.Stack;

/**
 * BSTIterator will be called like this: BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 */
public class BSTIterator {

	private TreeNode current;
	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		current = root;
		stack = new Stack<>();
	}

	public boolean hasNext() {
		return current != null || !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		while (current != null) {
			stack.push(current);
			current = current.left;
		}
		TreeNode visit = stack.pop(); // visit
		current = visit.right;
		return visit.val;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}