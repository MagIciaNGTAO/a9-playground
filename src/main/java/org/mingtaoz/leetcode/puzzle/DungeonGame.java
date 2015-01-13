package org.mingtaoz.leetcode.puzzle;

/**
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
 * The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially 
 * positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health 
point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering 
these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 
if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

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
        int[] leastNeeded = new int[n];
        leastNeeded[n - 1] = dungeon[m - 1][n - 1] > 0 ? 0 : 1 - dungeon[m - 1][n - 1];
        for (int j = n - 2; j >= 0; j--) {
            int temp = dungeon[m - 1][j] - leastNeeded[j + 1];
            update(leastNeeded, j, temp);
        }
        for (int i = m - 2; i >= 0; i--) {
            int temp = dungeon[i][n - 1] - leastNeeded[n - 1];
            update(leastNeeded, n - 1, temp);
            for (int j = n - 2; j >= 0; j--) {
                temp = dungeon[i][j] - Math.min(leastNeeded[j], leastNeeded[j + 1]);
                update(leastNeeded, j, temp);
            }
        }
        return (dungeon[0][0] + leastNeeded[0] == 0 || leastNeeded[0] == 0) ? 1 + leastNeeded[0] : leastNeeded[0];
    }

    public void update(int[] leastNeeded, int index, int temp) {
        if (temp < 0) {
            leastNeeded[index] = -temp;
        } else if (temp == 0) {
            leastNeeded[index] = 1;
        } else {
            leastNeeded[index] = 1;
        }
    }
}
