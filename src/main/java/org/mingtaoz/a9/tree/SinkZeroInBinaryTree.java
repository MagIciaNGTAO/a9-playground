package org.mingtaoz.a9.tree;

import java.util.Deque;
import java.util.LinkedList;

import org.mingtaoz.a9.tree.BinaryTree.TreeNode;

public class SinkZeroInBinaryTree {
    /**
     * 
     * Sink Zero in Binary Tree. Swap zero value of a node with non-zero value
     * of one of its descendants so that
     * 
     * "no node with value zero could be parent of node with non-zero."
     * 
     * @param root
     */
    public void sinkZero(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        swapZero(root, queue);
    }

    public void swapZero(TreeNode node, Deque<TreeNode> deque) {
        if (node == null) {
            // I don't like this case cuz it double the call stack
            return;
        }
        if (node.val == 0) {
            deque.add(node);
        } else {
            if (!deque.isEmpty()) {
                swap(node, deque.poll());
                deque.add(node);
            }
        }
        // ask left piece to consume upper 0s
        swapZero(node.left, deque);
        clearQueue(node.left, deque);
        // ask right piece to consume upper 0s
        swapZero(node.right, deque);
        clearQueue(node.right, deque);
    }

    private void clearQueue(TreeNode node, Deque<TreeNode> deque) {
        if (!deque.isEmpty() && deque.peekLast() == node) {
            deque.pollLast();
        }
    }

    private void swap(TreeNode node, TreeNode poll) {
        int temp = node.val;
        node.val = poll.val;
        poll.val = temp;
    }
}
