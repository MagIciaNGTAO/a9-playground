package org.mingtaoz.a9.string;

public class Diff {

    public static void main(String[] args) {

        // read in lines of each file
        String[] x = new String[] { "test", "abc", "test3" };
        String[] y = new String[] { "test4", "test", "abc" };

        // number of lines of each file
        int M = x.length;
        int N = y.length;

        int[] hashx = new int[M];
        int[] hashy = new int[N];

        for (int i = 0; i < M; i++) {
            hashx[i] = x[i].hashCode();
        }

        for (int i = 0; i < N; i++) {
            hashy[i] = y[i].hashCode();
        }

        // opt[i][j] = length of longest common subsequence of x[i..M] and
        // y[j..N]
        int[][] opt = new int[M + 1][N + 1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (hashx[i] == hashy[j] && x[i].equals(y[j])) {
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                } else {
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
                }
            }
        }

        // recover LCS itself and print out non-matching lines to standard
        // output
        int i = 0, j = 0;
        while (i < M && j < N) {
            if (hashx[i] == hashy[j] && x[i].equals(y[j])) {
                System.out.println("== " + x[i]);
                i++;
                j++;
            } else {
                // take from either x or y, goal is to maximize further match
                if (opt[i + 1][j] >= opt[i][j + 1]) {
                    System.out.println("-- " + x[i++]);
                } else {
                    System.out.println("++ " + y[j++]);
                }
            }
        }

        // dump out one remainder of one string if the other is exhausted
        while (i < M || j < N) {
            if (i == M) {
                System.out.println("++ " + y[j++]);
            } else if (j == N) {
                System.out.println("-- " + x[i++]);
            }
        }
    }

}