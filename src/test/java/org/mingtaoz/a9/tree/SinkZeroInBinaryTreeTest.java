package org.mingtaoz.a9.tree;

import org.mingtaoz.a9.tree.SinkZeroInBinaryTree;
import org.mingtaoz.a9.tree.BinaryTree.TreeNode;
import org.mingtaoz.a9.tree.TreePrinter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SinkZeroInBinaryTreeTest extends TestCase {

    private SinkZeroInBinaryTree sut;

    public SinkZeroInBinaryTreeTest(String testName) {
        super(testName);
        sut = new SinkZeroInBinaryTree();
    }

    public static Test suite() {
        return new TestSuite(SinkZeroInBinaryTreeTest.class);
    }

    public void testPushZeroDow1() {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(0);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(TreePrinter.serializeTree(n1));
        sut.sinkZero(n1);
        System.out.println(TreePrinter.serializeTree(n1));
    }
}
