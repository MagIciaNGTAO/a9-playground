package org.mingtaoz.a9.dp;

public class RodCutting {

    // TODO indexes
    public int bestCut(int[] prices, int length) {
        int[] max = new int[length + 1];
        max[0] = 0;
        for (int i = 1; i <= length; i++) {
            int opt = 0;
            for (int j = 1; j <= i; j++) {
                opt = Math.max(opt, max[j - 1] + prices[i - j]);
            }
            max[i] = opt;
        }
        return max[length];
    }
}
