package org.mingtaoz.a9.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.mingtaoz.leetcode.list.SinglyLinkedList.ListNode;

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

    /**
     * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
     * (a left node that shares the same parent node) or empty, flip it upside down and 
     * turn it into a tree where the original right nodes turned into left leaf nodes. 
     * Return the new root.

    For example:
    Given a binary tree {1,2,3,4,5},
        1
       / \
      2   3
     / \
    4   5
    return the root of the binary tree [4,5,2,#,#,3,1].
      4
     / \
    5   2
       / \
      3   1
      */
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        return upsideDownBinaryTreeHelper(root, null);
    }

    public TreeNode upsideDownBinaryTreeHelper(TreeNode node, TreeNode parent) {
        if (node == null) {
            // this part + A + B ensure left most to be returned
            return parent;
        }
        // A
        TreeNode root = upsideDownBinaryTreeHelper(node.left, node);
        node.right = parent;
        node.left = parent == null ? null : parent.right;
        // B
        return root;
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
            if (cur != null) {
                ret.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return ret;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root == null) {
            return ret;
        }
        ret.addAll(postorderTraversalIterative(root.left));
        ret.addAll(postorderTraversalIterative(root.right));
        ret.add(root.val);
        return ret;
    }

    /**
     * Sum Root to Leaf Numbers
     * 
     *   1
     *  / \
     * 2   3
     * 
     * 12 + 13 = 25
     * 
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbersRecursive(root, 0);
    }

    /**
     * 

     * 
     * @param root
     * @param prev
     * @return
     */
    public int sumNumbersRecursive(TreeNode root, int prev) {
        if (root == null) {
            return prev;
        }
        int ret = 0;
        if (root.left != null) {
            // with left child
            ret += sumNumbersRecursive(root.left, (prev + root.val) * 10);
        }
        if (root.right != null) {
            // with right child
            ret += sumNumbersRecursive(root.right, (prev + root.val) * 10);
        }
        if (ret == 0) {
            // a leaf
            ret = prev + root.val;
        }
        return ret;
    }

    int maxSum; // keeps something while recursing

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }

    // hold extensible max path + maintain maxSum
    public int maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxPathSumHelper(node.left);
        int right = maxPathSumHelper(node.right);
        maxSum = Math.max(left + right + node.val, maxSum);
        int ret = node.val + Math.max(left, right);
        return ret > 0 ? ret : 0;
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.peek();
                if (current.right == null || current.right == prev) {
                    stack.pop();
                    ret.add(current.val);
                    prev = current;
                } else {
                    root = current.right;
                }
            }
        }
        return ret;
    }

    // right to left layer-order-traversal
    // working for populating-next-right-pointers-in-each-node i/ii
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> curLayer = new LinkedList<>(), nextLayer = new LinkedList<>();
        TreeLinkNode next = null;
        curLayer.add(root);
        while (!curLayer.isEmpty()) {
            TreeLinkNode cur = curLayer.poll();
            if (cur != null) {
                cur.next = next;
                next = cur;
                // right first
                nextLayer.add(cur.right);
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

    /**
     * Given a binary tree, flatten it to a linked list in-place.
     * 
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1), prev = dummyHead;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                prev.right = cur;
                prev.left = null;
                prev = cur;
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        root = dummyHead.right;
    }

    /**
     * 
     * Given a binary tree, find its minimum depth.
     * 
     * The minimum depth is the number of nodes along the shortest path from the
     * root node down to the nearest leaf node.
     * 
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // definition of leaf is strict in here
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     * 
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        }
        if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

    For example:
    Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
    return
    [
    [5,4,11,2],
    [5,8,4,5]
    ]
     * 
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<>();
        pathSumHelper(root, sum, ret, new LinkedList<>());
        return ret;
    }

    private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> ret, List<Integer> cur) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                cur.add(root.val);
                ret.add(new LinkedList<>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        cur.add(root.val);
        pathSumHelper(root.right, sum - root.val, ret, cur);
        pathSumHelper(root.left, sum - root.val, ret, cur);
        cur.remove(cur.size() - 1);
    }

    /**
     * 
     * Balanced Binary Tree
     * 
     * Given a binary tree, determine if it is height-balanced.
     * 
     * For this problem, a height-balanced binary tree is defined as a binary
     * tree in which the depth of the two subtrees of every node never differ by
     * more than 1.
     * 
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalancedHelper(root) != -1;
    }

    /**
     * 
     * -1 - not balanced
     * 
     * @param node
     * @return
     */
    private int isBalancedHelper(TreeNode node) {
        if (node == null) {
            return 1;
        }
        int left = 0, right = 0;
        left = isBalancedHelper(node.left);
        if (left == -1) {
            return -1;
        }
        right = isBalancedHelper(node.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(right - left) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 
     * Convert Sorted Array to Binary Search Tree
     * 
     * Given an array where elements are sorted in ascending order, convert it
     * to a height balanced BST.
     * 
     * @param num
     * @return
     */
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return sortedArrayToBSTHelper(num, 0, num.length - 1);
    }

    // TODO post order traversal like iteration ? maybe in order see L447
    // public TreeNode sortedArrayToBSTIterative(int[] num) {
    // Stack<int[]> stack = new Stack<>();
    // int left = 0, right = num.length - 1;
    // int mid = (left + right) / 2;
    // TreeNode root = new TreeNode(num[mid]);
    // while (left <= right) {
    //
    // }
    // return root;
    // }

    private TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        // still depends on which one we believe is the mid
        int mid = start + (end - start + 1) / 2;
        // or create cur before the recursion
        TreeNode left = sortedArrayToBSTHelper(num, start, mid - 1);
        TreeNode right = sortedArrayToBSTHelper(num, mid + 1, end);
        TreeNode cur = new TreeNode(num[mid]);
        // just to demonstrate connect could be move down
        cur.left = left;
        cur.right = right;
        return cur;
    }

    // opt
    class SortedListToOBST {
        ListNode list;

        public TreeNode sortedListToBST(ListNode head) {
            ListNode cur = head;
            list = head;
            int n = 0;
            while (cur != null) {
                cur = cur.next;
                n++;
            }
            return sortedListToBSTHelper(0, n - 1);
        }

        // the property is in-order traversal is the order of array
        private TreeNode sortedListToBSTHelper(int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode left = sortedListToBSTHelper(start, mid - 1);
            TreeNode parent = new TreeNode(list.val);
            parent.left = left;
            list = list.next;
            parent.right = sortedListToBSTHelper(mid + 1, end);
            return parent;
        }
    }

    /**
     * 
     * Given a binary tree, return the bottom-up level order traversal of its
     * nodes' values. (ie, from left to right, level by level from leaf to
     * root).
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> curLevel = new LinkedList<>(), nextLevel = new LinkedList<>();
        curLevel.add(root);
        List<Integer> tempLevel = new LinkedList<>();
        while (!curLevel.isEmpty()) {
            TreeNode cur = curLevel.poll();
            tempLevel.add(cur.val);
            if (cur.left != null) {
                nextLevel.add(cur.left);
            }
            if (cur.right != null) {
                nextLevel.add(cur.right);
            }
            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<>();
                ret.add(0, tempLevel);
                tempLevel = new LinkedList<>();
            }
        }
        return ret;
    }

    /**
     * Given preorder and inorder traversal of a tree, construct the binary
     * tree.
     * 
     * Note: You may assume that duplicates do not exist in the tree.
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null; // exception?
        }
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int mid = 0, val = preorder[ps];
        TreeNode node = new TreeNode(val);
        if (ps == pe) {
            return node;
        }
        while (val != inorder[mid]) {
            mid++;
        }
        int leftPieceCount = mid - is;
        node.left = buildTreeHelper(preorder, inorder, ps + 1, ps + leftPieceCount, is, mid - 1);
        node.right = buildTreeHelper(preorder, inorder, ps + 1 + leftPieceCount, pe, mid + 1, ie);
        return node;
    }

    /**
     * Given inorder and postorder traversal of a tree, construct the binary
     * tree.
     * 
     * Note: You may assume that duplicates do not exist in the tree.
     * 
     * @param inorder
     * @param postorder
     * @param dummy
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (postorder.length != inorder.length) {
            return null; // exception?
        }
        return buildTreeHelper2(inorder, postorder, 0, postorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper2(int[] inorder, int[] postorder, int is, int ie, int os, int pe) {
        if (is > ie) {
            return null;
        }
        TreeNode currentNode = new TreeNode(postorder[pe]);
        if (is == ie) {
            return currentNode;
        }
        // find root in inorder
        int mid = is;
        while (inorder[mid] != postorder[pe]) {
            mid++;
        }
        currentNode.left = buildTreeHelper2(inorder, postorder, is, mid - 1, os, os + mid - 1 - is);
        currentNode.right = buildTreeHelper2(inorder, postorder, mid + 1, ie, pe - (ie - mid), pe - 1);
        return currentNode;
    }

    /**
     * 
     * Given a binary tree, find its maximum depth. The maximum depth is the
     * number of nodes along the longest path from the root node down to the
     * farthest leaf node.
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // again the def of leaf is very strict
            return 1;
        }
        if (root.left == null) {
            return maxDepth(root.right) + 1;
        }
        if (root.right == null) {
            return maxDepth(root.left) + 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null; // could use null to represent real min
        // inorder traversal
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode visiting = stack.pop();
                if (pre != null && pre.val >= visiting.val) {
                    return false;
                }
                pre = visiting;
                if (visiting.right != null) {
                    cur = visiting.right;
                }
            }
        }
        return true;
    }

    /**
     * 
     * Given a binary tree, return the level order traversal of its nodes'
     * values. (ie, from left to right, level by level).
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> curLayer = new LinkedList<>(), nextLayer = new LinkedList<>();
        List<Integer> tempRet = new LinkedList<>();
        curLayer.add(root);
        while (!curLayer.isEmpty()) {
            TreeNode current = curLayer.poll();
            tempRet.add(current.val);
            if (current.left != null) {
                nextLayer.add(current.left);
            }
            if (current.right != null) {
                nextLayer.add(current.right);
            }
            if (curLayer.isEmpty()) {
                curLayer = nextLayer;
                nextLayer = new LinkedList<>();
                ret.add(tempRet);
                tempRet = new LinkedList<>();
            }
        }
        return ret;
    }

    /**
     * 
     * Given a binary tree, return the zigzag level order traversal of its
     * nodes' values. (ie, from left to right, then right to left for the next
     * level and alternate between).
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> curLayer = new LinkedList<>(), nextLayer = new LinkedList<>();
        curLayer.add(root);
        List<Integer> tempRet = new LinkedList<>();
        boolean even = false;
        while (!curLayer.isEmpty()) {
            TreeNode current = curLayer.poll();
            if (even) {
                tempRet.add(0, current.val);
            } else {
                tempRet.add(current.val);
            }
            if (current.left != null) {
                nextLayer.add(current.left);
            }
            if (current.right != null) {
                nextLayer.add(current.right);
            }
            if (curLayer.isEmpty()) {
                curLayer = nextLayer;
                nextLayer = new LinkedList<>();
                ret.add(tempRet);
                tempRet = new LinkedList<>();
                even = !even;
            }
        }
        return ret;
    }

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie,
     * symmetric around its center).
     * 
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetricHelper(root.left, root.right);
    }

    private boolean symmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // need to define a recursion function properly before using it
        return symmetricHelper(left.left, right.right) && symmetricHelper(left.right, right.left);
    }

    /**
     * 
     * Given two binary trees, write a function to check if they are equal or
     * not.
     * 
     * Two binary trees are considered equal if they are structurally identical
     * and the nodes have the same value.
     * 
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeHelper(p, q);
    }

    private boolean isSameTreeHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSameTree(left.right, right.right) && isSameTree(left.left, right.left);
    }

    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, cur = root, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        // inorder traversal
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (prev != null && cur.val < prev.val) {
                    if (first == null) {
                        first = prev;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                prev = cur;
                cur = cur.right;
            }
        }
        swap(first, second);
    }

    private static void swap(TreeNode t1, TreeNode t2) {
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ret = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ret.add(cur.val);
                cur = cur.right;
            }
        }
        return ret;
    }

    /**
     * 
     * Given n, how many structurally unique BST's (binary search trees) that
     * store values 1...n?
     * 
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // num trees by 0 to i elements
        int[] table = new int[n + 1];
        table[0] = 1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // 0 to i + 1 all could be root
            for (int j = 0; j <= i; j++) {
                // left * right using 0 to i elemgn
                sum += table[j] * table[i - j];
            }
            table[i + 1] = sum;
        }
        return table[n];
    }

    /**
     * 
     * Given n, generate all structurally unique BST's (binary search trees)
     * that store values 1...n.
     * 
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ret = new LinkedList<>();
        if (start > end) {
            ret.add(null);
            return ret;
        }
        for (int i = start; i <= end; i++) {
            // here we allow overlap cuz we need an entire copy of the subtrees
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    public TreeNode deepCopy(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = deepCopy(root.left);
        newRoot.right = deepCopy(root.right);
        return newRoot;
    }

    /**
     * 
     * Binary Tree Right Side View
     * 
     * Given a binary tree, imagine yourself standing on the right side of it, 
     * return the values of the nodes you can see ordered from top to bottom.
     * For example:
     * Given the following binary tree,
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     * You should return [1, 3, 4].
     * 
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();

        Queue<TreeNode> curr = new LinkedList<>(), next = new LinkedList<>();
        if (root != null) {
            curr.offer(root);
        }
        while (!curr.isEmpty()) {
            TreeNode last = curr.poll();
            if (last.left != null) {
                next.offer(last.left);
            }
            if (last.right != null) {
                next.offer(last.right);
            }
            if (curr.isEmpty()) {
                ret.add(last.val);
                curr = next;
                next = new LinkedList<>();
            }
        }

        return ret;
    }

    int currentLevel = -1;

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        rightSideView2Helper(root, 0, ret);
        return ret;
    }

    public void rightSideView2Helper(TreeNode current, int level, List<Integer> ret) {
        if (current == null) {
            return;
        }
        if (level > currentLevel) {
            currentLevel = level;
            ret.add(current.val);
        }
        rightSideView2Helper(current.right, level + 1, ret);
        rightSideView2Helper(current.left, level + 1, ret);
    }

    /**
     * 
     * Google: 90% of our engineers use the software you wrote (Homebrew)
     * but you can’t invert a binary tree on a whiteboard so fuck off.
     * 
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between 
    two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

          3
        /   \
       5     1
      / \   / \
     6   2 0   8
        / \
       7   4
    For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 
    5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    /**
     * 
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes 
    v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
    /      \        /      \
    0      _4       7       9
         /  \
         3   5
    For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
    since a node can be a descendant of itself according to the LCA definition.
     * 
     * @param root
     * @param a
     * @param b
     * @return
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if ((root.val >= a.val && root.val <= b.val) || (root.val <= a.val && root.val >= b.val)) {
            return root;
        }
        if (root.val > a.val && root.val > b.val) {
            return lowestCommonAncestorBST(root.left, a, b);
        } else {
            return lowestCommonAncestorBST(root.right, a, b);
        }
    }
}
