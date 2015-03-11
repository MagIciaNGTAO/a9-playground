package org.mingtaoz.leetcode.array;

public class JumpGame {

    /**
     * 
     * Given an array of non-negative integers, you are initially positioned at
     * the first index of the array.
     * 
     * Each element in the array represents your maximum jump length at that
     * position.
     * 
     * Your goal is to reach the last index in the minimum number of jumps.
     * 
     * For example:
     * Given array A = [2,3,1,1,4]
     * 
     * The minimum number of jumps to reach the last index is 2. (Jump 1 step
     * from index 0 to 1, then 3 steps to the last index.)
     * 
     * @param A
     * @return
     */
    public int jump(int[] A) {
        int ret = 0, explorer = 0, follower = 0, n = A.length;
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (follower < i) {
                ret++;
                follower = explorer;
            }
            // i is reachable by follower with 1 jump
            explorer = Math.max(explorer, i + A[i]);
            if (explorer >= n - 1) {
                break;
            }
        }
        if (follower < explorer) {
            ret++;
        }
        return ret;
    }

    public boolean canJump(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return true;
        }
        int cl = 1;
        for (int i = A.length - 2; i > 0; i--) {
            if (A[i] >= cl) {
                cl = 1;
            } else {
                cl++;
            }
        }
        return A[0] >= cl;
    }
}
