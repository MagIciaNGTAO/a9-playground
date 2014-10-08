package org.mingtaoz.leetcode.puzzle;

import java.util.Arrays;
import java.util.Collections;
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
		Set<String> dup = new HashSet<>();
		// 1. sort
		Arrays.sort(num);
		// 2. search & prunning
		int left = 0, right = num.length - 1;
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

	public int threeSumClosest(int[] num, int target) {
		return 0;
	}

	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> ret = new LinkedList<>();

		return ret;
	}
}
