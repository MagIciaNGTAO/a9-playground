package org.mingtaoz.leetcode.math;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        boolean[] nonPrime = new boolean[n];
        nonPrime[0] = true;
        nonPrime[1] = true;

        int seed = 2;
        while (n > seed * seed) {
            for (int i = seed; i * seed < n && i * seed > 0; i++) {
                nonPrime[i * seed] = true;
            }
            seed++;
        }

        int prime = 0;
        for (int i = 0; i < n; i++) {
            if (!nonPrime[i]) {
                prime++;
            }
        }
        return prime;
    }
}
