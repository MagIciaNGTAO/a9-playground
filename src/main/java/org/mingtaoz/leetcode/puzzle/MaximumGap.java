package org.mingtaoz.leetcode.puzzle;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given an unsorted array, find the   between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 *
 */
public class MaximumGap {

    public int maximumGap(int[] num) {
        int n = num.length;
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return Math.abs(num[1] - num[0]);
        }
        int[] minmax = findMinMax(num);
        double min = (double) minmax[0], max = minmax[1], interval = (max - min) / (n - 1);
        List<Integer>[] bucket = new List[n - 1];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }
        for (int i : num) {
            if (i != min && i != max) {
                bucket[(int) Math.floor((i - min) / interval)].add(i);
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            List<Integer> b = bucket[i];
            if (b.size() == 0) {
                if (i == 0) {
                    int j = 1;
                    while (bucket[j].size() == 0) {
                        j++;
                    }
                    return findMinMax(bucket[j])[0] - minmax[0];
                } else if (i == bucket.length - 1) {
                    int j = i - 1;
                    while (bucket[j].size() == 0) {
                        j--;
                    }
                    return minmax[1] - findMinMax(bucket[i - 1])[1];
                } else {
                    int j = i + 1;
                    while (bucket[j].size() == 0) {
                        j++;
                    }
                    int k = i - 1;
                    while (bucket[j].size() == 0) {
                        k--;
                    }
                    return findMinMax(bucket[j])[0] - findMinMax(bucket[k])[1];
                }
            }
        }
        return 0; // not possible
    }

    private int[] findMinMax(int[] num) {
        int min = num[0], max = num[0];

        for (int i : num) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        return new int[] { min, max };
    }

    private int[] findMinMax(List<Integer> num) {
        int min = num.get(0), max = num.get(0);

        for (int i : num) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        return new int[] { min, max };
    }
}
