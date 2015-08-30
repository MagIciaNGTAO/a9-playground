package org.mingtaoz.a9.tree;

import static org.truth0.Truth.ASSERT;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.tree.BinaryTree.TreeNode;

public class BinaryTreeTest {

    private BinaryTree sut;

    @Before
    public void setup() {
        sut = new BinaryTree();
    }

    @Test
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

        ASSERT.that(sut.postorderTraversalIterative(root).toString()).isEqualTo(list.toString());
    }

    @Test
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

        ASSERT.that(sut.preorderTraversal(sut.UpsideDownBinaryTree(n1)).toString()).isEqualTo(list.toString());
    }

    @Test
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

        ASSERT.that(sut.preorderTraversal(sut.UpsideDownBinaryTree(n1)).toString()).isEqualTo(list.toString());
    }

    @Test
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

        ASSERT.that(sut.preorderTraversal(sut.UpsideDownBinaryTree(n1)).toString()).isEqualTo(list.toString());
    }

    @Test
    public void testPostorderTraversal2() {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;

        List<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.add(1);

        ASSERT.that(sut.postorderTraversalIterative(root).toString()).isEqualTo(list.toString());
    }

    @Test
    public void testSumNumbers1() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        ASSERT.that(sut.sumNumbers(root)).isEqualTo(25);
    }

    @Test
    public void testMaxPathSum1() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        ASSERT.that(sut.maxPathSum(root)).isEqualTo(6);
    }

    @Test
    public void testMaxPathSum2() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n2.right = n3;
        n3.left = n4;

        ASSERT.that(sut.maxPathSum(n1)).isEqualTo(10);
    }

    @Test
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

        ASSERT.that(sut.maxPathSum(n1)).isEqualTo(12);
    }

    @Test
    public void testMaxPathSum4() {
        TreeNode n1 = new TreeNode(-3);

        ASSERT.that(sut.maxPathSum(n1)).isEqualTo(-3);
    }

    @Test
    public void testMaxPathSum5() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(-1);
        n1.left = n2;

        ASSERT.that(sut.maxPathSum(n1)).isEqualTo(2);
    }

    @Test
    public void testMaxPathSum6() {
        TreeNode n1 = new TreeNode(-6);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.left = null;
        n1.right = n2;
        n2.left = n3;

        ASSERT.that(sut.maxPathSum(n1)).isEqualTo(5);
    }

    @Test
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

        ASSERT.that(sut.hasPathSum(n1, 22)).isTrue();
    }

    @Test
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

        ASSERT.that(result.size()).is(2);
    }

    @Test
    public void testIsBalanced1() {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        Boolean result = sut.isBalanced(n1);

        ASSERT.that(result).isTrue();
    }

    @Test
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

        ASSERT.that(result).isFalse();
    }

    @Test
    public void testBuildTree1() {
        TreeNode root = sut.buildTree(new int[] { 1, 2 }, new int[] { 2, 1 });
        ASSERT.that(root.val).is(1);
        ASSERT.that(root.left.val).is(2);
    }

    @Test
    public void testBuildTree2() {
        TreeNode root = sut.buildTree(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 });

        ASSERT.that(root.val).is(1);
        ASSERT.that(root.right.val).is(2);
        ASSERT.that(root.right.left.val).is(3);
    }

    @Test
    public void testBuildTree21() {
        TreeNode root = sut.buildTree2(new int[] { 1, 2 }, new int[] { 2, 1 });
        ASSERT.that(root.val).is(1);
        ASSERT.that(root.right.val).is(2);
    }

    @Test
    public void testBuildTree22() {
        TreeNode root = sut.buildTree2(new int[] { 1, 3, 2 }, new int[] { 3, 2, 1 });

        ASSERT.that(root.val).is(1);
        ASSERT.that(root.right.val).is(2);
        ASSERT.that(root.right.left.val).is(3);
    }

    @Test
    public void testRecoverTree1() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n3;
        n1.right = n2;

        sut.recoverTree(n1);

        ASSERT.that(n2.val).is(3);
        ASSERT.that(n3.val).is(1);
    }

    // @Test
    // public void testRecoverTree2() {
    // TreeNode n1 = new TreeNode(0);
    // TreeNode n2 = new TreeNode(1);
    //
    // n1.left = n2;
    //
    // sut.recoverTree(n1);
    //
    // ASSERT.that(n1.val).is(0);
    // ASSERT.that(n2.val).is(1);
    // }

    @Test
    public void testRecoverTree3() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);

        n1.right = n2;

        sut.recoverTree(n1);

        ASSERT.that(n1.val).is(1);
        ASSERT.that(n2.val).is(2);
    }

    @Test
    public void testRecoverTree4() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n2.right = n3;

        sut.recoverTree(n1);

        ASSERT.that(n1.val).is(3);
        ASSERT.that(n2.val).is(1);
        ASSERT.that(n3.val).is(2);
    }

    @Test
    public void testInorderTraversal() {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);

        n1.left = n2;
        n1.right = n3;

        List<Integer> ret = sut.inorderTraversal(n1);

        ASSERT.that(ret.get(0).intValue()).is(1);
        ASSERT.that(ret.get(1).intValue()).is(2);
        ASSERT.that(ret.get(2).intValue()).is(3);
    }

    @Test
    public void testNumTrees1() {
        ASSERT.that(sut.numTrees(1)).is(1);
        ASSERT.that(sut.numTrees(3)).is(5);
        ASSERT.that(sut.numTrees(4)).is(14);
        ASSERT.that(sut.numTrees(5)).is(42);
        ASSERT.that(sut.numTrees(9)).is(4862);
    }

    // @Test
    // public void testGenerateTrees1() {
    // ASSERT.that(sut.generateTrees(1)).is(1);
    // ASSERT.that(sut.generateTrees(2)).is(2);
    // ASSERT.that(sut.generateTrees(3)).is(5);
    // ASSERT.that(sut.generateTrees(4)).is(14);
    // ASSERT.that(sut.generateTrees(5)).is(42);
    // }

    @Test
    public void testRightSideView() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;

        ASSERT.that(sut.rightSideView(n1).toString()).is("[1, 3, 4]");
    }
}
