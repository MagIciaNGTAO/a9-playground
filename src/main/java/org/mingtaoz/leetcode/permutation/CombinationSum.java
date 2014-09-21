package org.mingtaoz.leetcode.permutation;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		return combinationSumHelper(candidates, target, 0,
				new LinkedList<Integer>(), 0);
	}

	public List<List<Integer>> combinationSumHelper(int[] candidates,
			int target, int sum, List<Integer> current, int start) {
		List<List<Integer>> ret = new LinkedList<>();
		if (sum > target) {
			return ret;
		}
		if (sum == target) {
			List<Integer> temp = new LinkedList<Integer>(current);
			Collections.sort(temp);
			ret.add(temp);
			return ret;
		}
		int prev = Integer.MAX_VALUE; // dup
		for (int i = start; i < candidates.length; i++) {
			if (prev != candidates[i]) {
				current.add(candidates[i]);
				List<List<Integer>> temp = combinationSumHelper(candidates,
						target, sum + candidates[i], current, i);
				current.remove(current.size() - 1);
				ret.addAll(temp);
				prev = candidates[i];
			}
		}
		return ret;
	}

	private Set<String> rep = new HashSet<>();

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> ret = new LinkedList<>();
		List<List<Integer>> all = combinationSumHelper2(num, target, 0,
				new LinkedList<Integer>(), -1);
		for (List<Integer> one : all) {
			String s = one.toString();
			if (!rep.contains(s)) {
				ret.add(one);
				rep.add(s);
			}
		}

		return ret;
	}

	public List<List<Integer>> combinationSumHelper2(int[] candidates,
			int target, int sum, List<Integer> current, int start) {
		List<List<Integer>> ret = new LinkedList<>();
		if (sum > target) {
			return ret;
		}
		if (sum == target) {
			List<Integer> temp = new LinkedList<Integer>(current);
			Collections.sort(temp);
			ret.add(temp);
			return ret;
		}
		int prev = Integer.MAX_VALUE;
		for (int i = start + 1; i < candidates.length; i++) {
			if (prev != candidates[i]) {
				current.add(candidates[i]);
				List<List<Integer>> temp = combinationSumHelper2(candidates,
						target, sum + candidates[i], current, i);
				current.remove(current.size() - 1);
				ret.addAll(temp);
				prev = candidates[i];
			}
		}
		return ret;
	}
}
