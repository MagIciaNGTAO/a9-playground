package org.mingtaoz.other.tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

// TODO need to read this piece
public class PushZeroDown {

    static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int x) {
            val = x;
        }

    }

    /**
     * 
     * push zero down to leaf as far as possible
     *
     */
    public void pushZeroDown(TreeNode root) {
        HashSet<TreeNode> finished = new HashSet<TreeNode>();
        sink0(root, new HashMap<TreeNode, TreeNode>(), finished, false);
    }

    public void sink0(TreeNode root, HashMap<TreeNode, TreeNode> parentMap,
            HashSet<TreeNode> finished, boolean zerosOver) {
        if (root.val == 0)
            zerosOver = true;
        if (!zerosOver)
            finished.add(root);

        if (root.left != null) {
            parentMap.put(root.left, root);
            sink0(root.left, parentMap, finished, zerosOver);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            sink0(root.right, parentMap, finished, zerosOver);
        }
        if (root.val != 0 && !finished.contains(root)) {
            TreeNode temp = root;
            ArrayDeque<TreeNode> nonZeroNodes = new ArrayDeque<TreeNode>();
            ArrayDeque<TreeNode> nodes = new ArrayDeque<TreeNode>();
            while (temp != null && !finished.contains(temp)) {
                nodes.push(temp);
                if (temp.val != 0)
                    nonZeroNodes.push(temp);
                temp = parentMap.get(temp);
            }
            // only care the number of 0s
            while (!nonZeroNodes.isEmpty()) {
                TreeNode tempNode = nonZeroNodes.pop();
                TreeNode toModify = nodes.pop();
                toModify.val = tempNode.val;
                finished.add(toModify);
            }
            while (!nodes.isEmpty()) {
                TreeNode toModify = nodes.pop();
                toModify.val = 0;
            }
        }
    }
}
