package org.mingtaoz.leetcode.array;

public class SortColors {
    public void sortColors(int[] A) {
        int[] counter = new int[3];
        for (int color : A) {
            counter[color]++;
        }
        int j = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]-- > 0) {
                A[j++] = i;
            }
        }
    }
}
