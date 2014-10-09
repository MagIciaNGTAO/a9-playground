package org.mingtaoz.leetcode.puzzle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum {

	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> complement = new HashMap<>();
		int[] ret = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			if (complement.containsKey(numbers[i])) {
				ret[0] = complement.get(numbers[i]) + 1;
				ret[1] = i + 1;
			} else {
				complement.put(target - numbers[i], i);
			}
		}
		return ret;
	}

	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> ret = new LinkedList<>();
		if (num.length == 0) {
			return ret;
		}
		Set<String> dup = new HashSet<>();
		// 1. sort
		Arrays.sort(num);
		// 2. remove duplicate
		int right = removeDuplicate(num);
		// 3. search & prunning
		int left = 0;
		for (; left < right - 1 && num[left] <= 0; left++) {
			for (int j = right; j > left + 1; j--) {
				for (int i = j - 1; i > left & num[left] + num[i] + num[j] >= 0; i--) {
					if ((num[left] + num[i] + num[j]) == 0) {
						List<Integer> list = Arrays.asList(num[left], num[i],
								num[j]);
						String s = list.toString();
						if (!dup.contains(s)) {
							dup.add(s);
							ret.add(list);
						}
					}
				}
			}
		}
		return ret;
	}

	public int removeDuplicate(int[] num) {
		int total = 0, prev = num[total];
		int count = 0;
		for (int i = 1; i < num.length; i++) {
			if (prev != num[i]) {
				num[++total] = num[i];
				prev = num[i];
				count = 0;
			} else {
				if (count == 0) {
					count++;
					num[++total] = num[i];
				} else if (num[i] == 0 && count < 2) {
					// TODO: missed three 0 case
					count++;
					num[++total] = num[i];
				} else {
					count++;
				}
			}
		}
		return total;
	}

	public int threeSumClosest(int[] num, int target) {
		int ret = 0;
		Arrays.sort(num);
		int right = removeDuplicate(num);
		
		
		
		return ret;
	}

	// 2222 333 -> 222 333
	public int removeTrilicate(int[] num) {
		int total = 0, prev = num[total];
		int count = 0;
		for (int i = 1; i < num.length; i++) {
			if (prev != num[i]) {
				num[++total] = num[i];
				prev = num[i];
				count = 0;
			} else {
				if (count < 2) {
					count++;
					num[++total] = num[i];
				}
			}
		}
		return total;
	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ret = new LinkedList<>();

		return ret;
	}
}
