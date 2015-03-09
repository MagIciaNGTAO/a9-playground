package org.mingtaoz.leetcode.puzzle;

/**
 * Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 *
 */
public class LargestRectangleInHistogram {

    class Stack {

        Node head;

        class Node {
            public int value;
            public Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        public Stack() {
        }

        public void push(int key) {
            Node node = new Node(key);
            node.next = head;
            head = node;
        }

        public int pop() {
            int ret = head.value;
            head = head.next;
            return ret;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int peek() {
            return head.value;
        }
    }

    public int largestRectangleArea(int[] height) {
        int ret = 0, n = height.length;
        Stack stack = new Stack();
        for (int i = 0; i < n;) {
            if (stack.isEmpty() || height[i] > height[stack.peek()]) {
                // this init is elegant
                stack.push(i++);
            } else {
                ret = Math.max(ret, height[stack.pop()] * (!stack.isEmpty() ? i - stack.peek() - 1 : i));
            }
        }
        while (!stack.isEmpty()) {
            ret = Math.max(ret, height[stack.pop()] * (!stack.isEmpty() ? n - stack.peek() - 1 : n));
        }
        return ret;
    }

    /**
     * 
     * 
     * 
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            // !!leetcode throw runtime exception in hear
            return 0;
        }
        int n = matrix.length, m = matrix[0].length, max = 0;
        int[] curHisto = new int[m];
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == '1') {
                curHisto[j] = 1;
            }
        }
        max = largestRectangleArea(curHisto);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int contrib = matrix[i][j] == '1' ? 1 : 0;
                curHisto[j] = contrib == 0 ? 0 : curHisto[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(curHisto));
        }
        return max;
    }
}
