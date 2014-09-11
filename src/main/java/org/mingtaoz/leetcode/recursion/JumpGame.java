package org.mingtaoz.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

	

	/**
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 * 
	 */
	public boolean canJump(int[] A) {
		return canJumpHelper(A, 0);
	}

	// Impl2: backward
	// TODO this is kinda DP, but not as efficient as Impl1
	
	// Impl1: forward ->
	private Map<Integer, Boolean> map = new HashMap<>();
	
	public boolean canJumpHelper(int[] A, int i) {
		if (map.containsKey(i)) {
			return map.get(i);
		}
		if (i >= A.length) {
			return true;
		} else {
			for (int j = A[i]; j >= 1; j--) {
				if (canJumpHelper(A, j + i)) {
					return true;
				} else {
					map.put(j + i, false);
				}
			}
			map.put(i, false);
			return false;
		}
	}
}
