package org.mingtaoz.tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintTree {
    // refactoring A Node/Printer
    public int val;
    public PrintTree left, right;

    public PrintTree(int x) {
        val = x;
    }

    public void printNode() {
        int maxLevel = maxLevel(this);

        printNodeInternal(Collections.singletonList(this), 1, maxLevel);
    }

    private void printNodeInternal(List<PrintTree> nodes, int level,
            int maxLevel) {
        if (nodes.isEmpty())
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<PrintTree> newNodes = new ArrayList<PrintTree>();
        for (PrintTree node : nodes) {
            System.out.print(node.val);
            if (node.left != null) {
                newNodes.add(node.left);
            }
            if (node.right != null) {
                newNodes.add(node.right);
            }
            // System.out.print(" ");
            // }
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(PrintTree node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    // test the behavior
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.
        stringBuilder.insert(5, "a");

        System.out.println(stringBuilder.toString());
    }
}
