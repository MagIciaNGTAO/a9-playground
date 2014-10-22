package org.mingtaoz.leetcode.tree;

import org.mingtaoz.leetcode.tree.PushZeroDown;
import org.mingtaoz.leetcode.tree.PushZeroDown.TreeNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PushZeroDownTest extends TestCase {

	private PushZeroDown sut;

	public PushZeroDownTest(String testName) {
		super(testName);
		sut = new PushZeroDown();
	}

	public static Test suite() {
		return new TestSuite(PushZeroDownTest.class);
	}

	public void testPushZeroDow1() {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		// n1.printNode();
		sut.pushZeroDown(n1);
		
		// TODO assesrtion
		
		// n1.printNode();
	}
}
