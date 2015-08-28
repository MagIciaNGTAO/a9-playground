package org.mingtaoz.a9.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * There are n coins in a line. (Assume n is even). Two players take turns to take a coin 
 * from one of the ends of the line until there are no more coins left. 
 * The player with the larger amount of money wins.
 * 
 * 1. Would you rather go first or second? Does it matter?
 * 2. Assume that you go first, describe an algorithm to compute the maximum amount of money you can win.
 * 
 * @author mingtaozhang
 *
 */

public class CoinsInALine {

    private Map<String, int[]> mem = new HashMap<>();
    private char[] players = { 'A', 'B' };

    public int bestPickTopDown(int[] values) {
        if (values.length == 0) {
            return 0;
        }
        return bestPick(values, players[0], 0, values.length - 1)[0];
    }

    // this top-down implementation has been generalized to N players
    // they take turns to play, each of them is smart
    private int[] bestPick(int[] values, char action, int left, int right) {
        // not good for N players
        if (left == right) {
            int[] ret = new int[2];
            ret[actionToIndex(action)] = values[left];
            return ret;
        }
        if (mem.containsKey(left + action + right)) {
            return mem.get(left + action + right);
        }
        char nextAction = nextAction(action);
        // pick left
        int[] afterLeftPicked = bestPick(values, nextAction, left + 1, right);
        int pickLeft = values[left] + afterLeftPicked[actionToIndex(action)];
        // pick right
        int[] afterRightPicked = bestPick(values, nextAction, left, right - 1);
        int pickRight = values[right] + afterRightPicked[actionToIndex(action)];

        int[] value;

        if (pickLeft > pickRight) {
            value = Arrays.copyOf(afterLeftPicked, players.length);
            value[actionToIndex(action)] = pickLeft;
        } else {
            value = Arrays.copyOf(afterRightPicked, players.length);
            value[actionToIndex(action)] = pickRight;
        }
        mem.put("" + left + action + right, value);
        return value;
    }

    private int actionToIndex(char action) {
        return action - players[0];
    }

    private char nextAction(char action) {
        if (action + 1 > players[players.length - 1]) {
            return players[0];
        } else {
            return (char) (action + 1);
        }
    }

    // bottom up solution
    // precise for 2 players ... might be hart to generalize to N players
    // Lemma 1. The opponent max his profit by min yours
    // bestPick(yours) = Sum(i to j)(values) - bestPick(opponent)
    public int bestPick(int[] values) {
        int n = values.length;

        // best pick from i to j
        int[][] table = new int[n][n];
        int a, b, c;
        for (int step = 0; step < n; step++) {
            for (int i = 0, j = i + step; j < n; i++, j++) {
                a = i + 2 < n ? table[i + 2][j] : 0;
                b = i + 1 < n && j - 1 >= 0 ? table[i + 1][j - 1] : 0;
                c = j - 2 >= 0 ? table[i][j - 2] : 0;
                // when you took i, opponent will pick to minimize your profit
                // when you took j, opponent will pick to minimize your profit
                // and you want the best between the two
                table[i][j] = Math.max(values[i] + Math.min(a, b), values[j] + Math.min(b, c));
            }
        }
        return table[0][n - 1];
    }
}
