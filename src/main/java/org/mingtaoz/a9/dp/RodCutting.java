package org.mingtaoz.a9.dp;

public class RodCutting {

    public int bestCut(int[] prices, int length) {
        int[] subOpt = new int[length + 1];
        subOpt[0] = 0;
        for (int i = 1; i <= length; i++) {
            int opt = 0;
            for (int j = 1; j <= i; j++) {
                opt = Math.max(opt, subOpt[j - 1] + prices[i - j]);
            }
            subOpt[i] = opt;
        }
        return subOpt[length];
    }
}
