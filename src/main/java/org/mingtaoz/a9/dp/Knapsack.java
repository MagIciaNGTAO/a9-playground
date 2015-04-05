package org.mingtaoz.a9.dp;

public class Knapsack {

    // 0/1 knapsack problem, which restricts the number xi of copies of each
    // kind of item to zero or one
    public int maxSteal01(int bag, int weights[], int worths[]) {
        int n = weights.length;
        // the max steal under <= i items as selection pool & weight <= limit
        int[] maxSteal = new int[bag + 1];
        for (int i = 1; i <= n; i++) {
            int[] nextMaxSteal = new int[bag + 1];
            for (int j = 1; j <= bag; j++) {
                if (weights[i - 1] <= j) {
                    nextMaxSteal[j] = Math.max(maxSteal[j], maxSteal[j - weights[i - 1]] + worths[i - 1]);
                } else {
                    nextMaxSteal[j] = maxSteal[j];
                }
            }
            maxSteal = nextMaxSteal;
        }
        return maxSteal[bag];
    }

    // TODO The unbounded knapsack problem (UKP) places no upper bound on the
    // number of copies of each kind of item and can be formulated as above
    // except for that the only restriction on x_i is that it is a non-negative
    // integer.
    public int maxStealUB(int bag, int weights[], int singleWorths[]) {
        int n = weights.length;
        // the max steal under <= i items with possible repeat & weight <= limit
        int[] maxSteal = new int[bag + 1];

        for (int j = 1; j <= bag; j++) {
            int best = 0;
            for (int i = 1; i <= n; i++) {
                if (weights[i - 1] <= j) {
                    best = Math.max(best, maxSteal[j - weights[i - 1]] + singleWorths[i - 1]);
                }
            }
            maxSteal[j] = best;
        }

        return maxSteal[bag];
    }

    // TODO The bounded knapsack problem (BKP) removes the restriction that
    // there is only one of each item, but restricts the number x_i of copies of
    // each kind of item to an integer value c_i.

}
