package org.mingtaoz.leetcode.toolbox.tree;

import java.util.LinkedList;
import java.util.List;
import org.mingtaoz.leetcode.toolbox.tree.BinaryTree.TreeNode;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BinaryTreeTest extends TestCase {
	private BinaryTree sut;

	public BinaryTreeTest(String testName) {
		super(testName);
		sut = new BinaryTree();
	}

	public static Test suite() {
		return new TestSuite(BinaryTreeTest.class);
	}

	public void testPostorderTraversal1() {
		TreeNode root = new TreeNode(3);
		TreeNode right = new TreeNode(1);
		TreeNode rightLeft = new TreeNode(2);
		root.right = right;
		right.left = rightLeft;

		List<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);

		assertEquals(list.toString(), sut.postorderTraversal(root).toString());
	}

	public void testPostorderTraversal2() {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.right = right;

		List<Integer> list = new LinkedList<Integer>();
		list.add(2);
		list.add(1);

		assertEquals(list.toString(), sut.postorderTraversal(root).toString());
	}
}
