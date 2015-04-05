package org.mingtaoz.a9.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePrinter {
    public static String serializeTree(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        List<TreeNode> curLevel = Collections.singletonList(root);
        int level = 1, maxLevel = maxLevel(root);
        while (!curLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            boolean nextLevelAllNull = true;
            int floor = maxLevel - level;
            int brancheHeight = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int leftSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
            printWhiteSpaces(leftSpaces, stringBuilder);
            for (TreeNode node : curLevel) {
                if (node == null) {
                    nextLevel.add(null);
                    nextLevel.add(null);
                    printWhiteSpaces(betweenSpaces + 1, stringBuilder);
                    continue;
                }
                stringBuilder.append(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                    nextLevelAllNull = false;
                } else {
                    nextLevel.add(null);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                    nextLevelAllNull = false;
                } else {
                    nextLevel.add(null);
                }
                printWhiteSpaces(betweenSpaces, stringBuilder);
            }
            stringBuilder.append("\n");
            for (int i = 1; i <= brancheHeight; i++) {
                for (TreeNode cur : curLevel) {
                    printWhiteSpaces(leftSpaces - i, stringBuilder);
                    if (cur == null) {
                        printWhiteSpaces(brancheHeight + brancheHeight + i + 1, stringBuilder);
                        continue;
                    }
                    if (cur.left != null) {
                        stringBuilder.append("/");
                    } else {
                        printWhiteSpaces(1, stringBuilder);
                    }
                    printWhiteSpaces(i + i - 1, stringBuilder);
                    if (cur.right != null) {
                        stringBuilder.append("\\");
                    } else {
                        printWhiteSpaces(1, stringBuilder);
                    }
                    printWhiteSpaces(brancheHeight + brancheHeight - i, stringBuilder);
                }
                stringBuilder.append("\n");
            }
            if (nextLevelAllNull) {
                curLevel.clear();
            } else {
                curLevel = nextLevel;
            }
            level++;
        }
        return stringBuilder.toString();
    }

    private static int maxLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static void printWhiteSpaces(int count, StringBuilder stringBuilder) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(" ");
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = (List<Integer>[]) new List[2];
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n7.right = n8;
        n4.left = n8;
        System.out.println(serializeTree(n1));

    }
}
