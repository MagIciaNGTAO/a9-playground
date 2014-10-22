package org.mingtaoz.leetcode.array;

public class JumpGame {

	// TODO stuck for a while!
	public int jump(int[] A) {
		int ret = 0, currentFurthestReach = 0, previousFurthestReach = 0;

		if (A.length == 1) {
			return 0;
		}

		for (int i = 0; i < A.length; i++) {
			if (previousFurthestReach < i) {
				ret++;
				previousFurthestReach = currentFurthestReach;
			}
			currentFurthestReach = Math.max(currentFurthestReach, i + A[i]);
			if (currentFurthestReach >= A.length - 1) {
				if (previousFurthestReach < currentFurthestReach) {
					ret++;
				}
				break;
			}
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
