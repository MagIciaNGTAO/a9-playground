package org.mingtaoz.a9.dp;

public class Knapsack {

    // 0/1 knapsack problem, which restricts the number xi of copies of each
    // kind of item to zero or one
    public int maxSteal01(int bag, int weights[], int worths[]) {
        int n = weights.length;
        // the max steal under <= i items as selection pool & weight <= limit
        int[] prev = new int[bag + 1];
        for (int i = 0; i < n; i++) {
            int[] cur = new int[bag + 1];
            for (int j = 1; j <= bag; j++) {
                if (weights[i] <= j) {
                    cur[j] = Math.max(prev[j], prev[j - weights[i]] + worths[i]);
                } else {
                    cur[j] = prev[j];
                }
            }
            prev = cur;
        }
        return prev[bag];
    }

    // The unbounded knapsack problem (UKP) places no upper bound on the
    // number of copies of each kind of item and can be formulated as above
    // except for that the only restriction on x_i is that it is a non-negative
    // integer.
    public int maxStealUB(int bag, int weights[], int single[]) {
        int n = weights.length;
        // the max steal under <= i items with possible repeat & weight <= limit
        int[] max = new int[bag + 1];

        for (int j = 1; j <= bag; j++) {
            int best = 0;
            for (int i = 0; i < n; i++) {
                if (weights[i] <= j) {
                    best = Math.max(best, max[j - weights[i]] + single[i]);
                }
            }
            max[j] = best;
        }

        return max[bag];
    }

    // TODO The bounded knapsack problem (BKP) removes the restriction that
    // there is only one of each item, but restricts the number x_i of copies of
    // each kind of item to an integer value c_i.

}
