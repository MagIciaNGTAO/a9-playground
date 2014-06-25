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

	public void testSumNumbers1() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;

		assertEquals(25, sut.sumNumbers(root));
	}

	public void testMaxPathSum1() {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;

		assertEquals(6, sut.maxPathSum(root));
	}

	public void testMaxPathSum2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);

		n1.left = n2;
		n2.right = n3;
		n3.left = n4;

		assertEquals(10, sut.maxPathSum(n1));
	}

	public void testMaxPathSum3() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;

		assertEquals(12, sut.maxPathSum(n1));
	}

	public void testMaxPathSum4() {
		TreeNode n1 = new TreeNode(-3);
		assertEquals(-3, sut.maxPathSum(n1));
	}

	public void testMaxPathSum5() {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(-1);
		n1.left = n2;
		assertEquals(2, sut.maxPathSum(n1));
	}

	public void testMaxPathSum6() {
		TreeNode n1 = new TreeNode(-6);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		n1.left = null;
		n1.right = n2;
		n2.left = n3;
		assertEquals(5, sut.maxPathSum(n1));
	}
}
