package org.mingtaoz.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.mingtaoz.leetcode.tree.BinaryTree.TreeNode;

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

        assertEquals(list.toString(), sut.postorderTraversalIterative(root)
                .toString());
    }

    public void testUpsideDownBinaryTree3() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;

        List<Integer> list = new LinkedList<Integer>();
        list.add(6);
        list.add(7);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);

        assertEquals(list.toString(),
                sut.preorderTraversal(sut.helper(n1, null)).toString());
    }

    public void testUpsideDownBinaryTree2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

        List<Integer> list = new LinkedList<Integer>();
        list.add(6);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);

        assertEquals(list.toString(),
                sut.preorderTraversal(sut.helper(n1, null)).toString());
    }

    public void testUpsideDownBinaryTree1() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        List<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(1);

        assertEquals(list.toString(),
                sut.preorderTraversal(sut.helper(n1, null)).toString());
    }

    public void testPostorderTraversal2() {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;

        List<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.add(1);

        assertEquals(list.toString(), sut.postorderTraversalIterative(root)
                .toString());
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

    public void testHasPathSum() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        assertTrue(sut.hasPathSum(n1, 22));
    }

    public void testPathSum() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.left = n9;
        n6.right = n10;
        List<List<Integer>> result = sut.pathSum(n1, 22);
        // System.out.println(result);
        assertEquals(2, result.size());
    }

    public void testIsBalanced1() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        Boolean result = sut.isBalanced(n1);
        assertTrue(result);
    }

    public void testIsBalanced2() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.left = n9;
        n6.right = n10;
        Boolean result = sut.isBalanced(n1);
        assertFalse(result);
    }

    public void testBuildTree1() {
        TreeNode root = sut.buildTree(new int[] { 1, 2 }, new int[] { 2, 1 });
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
    }

    public void testBuildTree2() {
        TreeNode root = sut.buildTree(new int[] { 1, 2, 3 }, new int[] { 1, 3,
                2 });
        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.left.val);
    }

    public void testBuildTree21() {
        TreeNode root = sut.buildTree2(new int[] { 1, 2 }, new int[] { 2, 1 });
        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
    }

    public void testBuildTree22() {
        TreeNode root = sut.buildTree2(new int[] { 1, 3, 2 }, new int[] { 3, 2,
                1 });
        assertEquals(1, root.val);
        assertEquals(2, root.right.val);
        assertEquals(3, root.right.left.val);
    }

    public void testRecoverTree1() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n3;
        n1.right = n2;

        sut.recoverTree(n1);
        assertEquals(3, n2.val);
        assertEquals(1, n3.val);
    }

    public void testRecoverTree2() {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);

        n1.left = n2;

        sut.recoverTree(n1);
        assertEquals(1, n1.val);
        assertEquals(0, n2.val);
    }

    public void testRecoverTree3() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);

        n1.right = n2;

        sut.recoverTree(n1);
        assertEquals(1, n1.val);
        assertEquals(2, n2.val);
    }

    public void testRecoverTree4() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n2.right = n3;

        sut.recoverTree(n1);
        assertEquals(3, n1.val);
        assertEquals(1, n2.val);
        assertEquals(2, n3.val);
    }

    public void testInorderTraversal() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        List<Integer> ret = sut.inorderTraversal(n1);
        assertEquals(3, ret.size());
        assertEquals(1, ret.get(0).intValue());
        assertEquals(2, ret.get(1).intValue());
        assertEquals(3, ret.get(2).intValue());
    }

    public void testNumTrees1() {
        assertEquals(1, sut.numTrees(1));
        assertEquals(2, sut.numTrees(2));
        assertEquals(5, sut.numTrees(3));
        assertEquals(14, sut.numTrees(4));
        assertEquals(42, sut.numTrees(5));
        assertEquals(4862, sut.numTrees(9));
    }

    public void testGenerateTrees1() {
        assertEquals(1, sut.generateTrees(1).size());
        assertEquals(2, sut.generateTrees(2).size());
        assertEquals(5, sut.generateTrees(3).size());
        assertEquals(14, sut.generateTrees(4).size());
        assertEquals(42, sut.generateTrees(5).size());
    }
}
