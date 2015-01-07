package org.mingtaoz.leetcode.puzzle;

/**
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)  -3  3
-5  -10 1
10  30  -5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] mem = new int[n + 1], min = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            mem[j] = mem[j - 1] + dungeon[0][j - 1];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                int health = Math.min(mem[j], mem[j - 1]) + dungeon[i][j - 1];
                if (health > 0) {
                    // TODO the problem is when mem is large min is also large, which means a higher cost to get higher health
                    // we could always minimize the cost, but there is a cost/benefit margin seems decided by later process ...
                    // might be DP is totally wrong here
                    min[j] = Math.min(min[j - 1], min[j]);
                    mem[j] = health;
                } else {
                    health = Math.max(mem[j], mem[j - 1]) + dungeon[i][j - 1];
                    if (health <= 0) {
                        if (mem[j] < mem[j - 1]) {
                            min[j] = min[j] - health + 1;
                        } else if (mem[j] > mem[j - 1]) {
                            min[j] = min[j - 1] - health + 1;
                        } else {
                            min[j] = Math.min(min[j - 1], min[j]) - health + 1;
                        }
                        mem[j] = 1;
                    } else {
                        if (mem[j] < mem[j - 1]) {
                            min[j] = min[j];
                        } else if (mem[j] > mem[j - 1]) {
                            min[j] = min[j - 1];
                        } else {
                            min[j] = Math.min(min[j - 1], min[j]);
                        }
                        mem[j] = health;
                    }
                }
            }
        }
        return min[n] == 0 ? 1 : min[n];
    }
}
