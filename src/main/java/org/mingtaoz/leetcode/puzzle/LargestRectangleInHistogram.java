package org.mingtaoz.leetcode.puzzle;

import java.util.Stack;

/**
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
 * @author futoyang
 *
 */
public class LargestRectangleInHistogram {

    class Point {
        public int i;
        public int l;

        public Point(int i, int l) {
            this.i = i;
            this.l = l;
        }
    }

    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Point> stack = new Stack<Point>();
        int ret = height[0], l = 0, h = height[0];
        stack.push(new Point(0, 0));
        for (int i = 1; i < height.length; i++) {
            h = Math.min(h, height[i]);
            ret = Math.max(ret, h * (i - l + 1));
            if (height[i] >= height[i - 1]) {
                if (height[i] >= ret) {
                    h = height[i];
                    l = i;
                    ret = height[i];
                }
                if (height[i] > h) {
                    stack.push(new Point(i, i));
                } else {
                    stack.push(new Point(i, l));
                }
            } else {
                Point p = new Point(i, i);
                while (!stack.isEmpty() && height[stack.peek().i] > height[i]) {
                    p = stack.pop();
                    int area = height[i] * (i - p.l + 1);
                    if (area > ret) {
                        // area of height[i]
                        ret = area;
                        l = p.i;
                    }
                    area = height[p.i] * (i - p.l);
                    if (area > ret) {
                        // area of height[p.i]
                        ret = area;
                        l = i;
                        h = height[i];
                    }
                }
                stack.push(new Point(i, p.l));
            }
        }
        int i = height.length - 1;
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            ret = Math.max(Math.min(height[p.i], height[i])
                    * (i - p.l + 1), ret);
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
