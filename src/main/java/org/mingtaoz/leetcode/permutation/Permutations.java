package org.mingtaoz.leetcode.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

	/**
	 * 
	 * Implement next permutation, which rearranges numbers into the
	 * lexicographically next greater permutation of numbers.
	 * 
	 * If such arrangement is not possible, it must rearrange it as the lowest
	 * possible order (ie, sorted in ascending order).
	 * 
	 * The replacement must be in-place, do not allocate extra memory.
	 * 
	 * Here are some examples. Inputs are in the left-hand column and its
	 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
	 * 1,2,3 1,1,5 → 1,5,1
	 * 
	 * no disorder until the end, switch last two: 1234->1243 some disorder but
	 * one in order? 2134->2143 3214->3241 => find last piece of in order and
	 * switch failed: 4321 => 'switching sort': keep switching left++ and
	 * right-- 14315 -> 14351 1237654 -> 1247653 'switching sort' -> 1243567
	 * 1257643 -> 1263457 -> ; 16375 -> 16537
	 * 
	 * @param num
	 */
	// TODO simplify?
	public void nextPermutation(int[] num) {
		int prev = num[0], cur;
		if (num.length == 1) {
			return;
		}
		int recentDown = num[0] > num[1] ? 0 : -1, recentUp = num[1] > num[0] ? 0
				: -1, n = num.length;
		for (int i = 1; i < n; i++) {
			cur = num[i];
			if (cur > prev) {
				recentUp = i - 1;
			} else if (cur < prev) {
				recentDown = i - 1;
			} else {
				// TODO em ...
			}
			prev = cur;
		}
		if (recentUp > recentDown) {
			// switch last two not equal
			int last = n - 1;
			while (num[last] == num[last - 1]) {
				last--;
			}
			int temp = num[last - 1];
			num[last - 1] = num[last];
			num[last] = temp;
		} else {
			if (recentUp != -1) {
				// find closest to recentUp and switch siwth recentUp
				int temp = num[recentUp];
				int search = n - 1;
				// TODO could be a binary search as it's sorted desc
				while (num[search] <= temp && search > recentUp) {
					search--;
				}
				num[recentUp] = num[search];
				num[search] = temp;
				// switch sort
			}
			n--;
			recentUp++;
			while (n > recentUp) {
				int temp = num[n];
				num[n--] = num[recentUp];
				num[recentUp++] = temp;
			}
		}
	}

	/**
	 * 
	 * Permutations II
	 *
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, [1,1,2] have the following unique permutations: [1,1,2],
	 * [1,2,1], and [2,1,1].
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permuteUnique(int[] num) {
		List<Integer> candidates = new ArrayList<>();
		for (int n : num) {
			candidates.add(n);
		}
		Collections.sort(candidates);
		return permuteUniqueHelper(candidates);
	}

	public List<List<Integer>> permuteUniqueHelper(List<Integer> candidates) {
		List<List<Integer>> result = new LinkedList<>();
		if (candidates.size() == 1) {
			List<Integer> temp = new LinkedList<>();
			temp.add(candidates.get(0));
			result.add(temp);
			return result;
		}
		int prev = candidates.get(0) - 1;
		for (int i = 0; i < candidates.size(); i++) {
			int current = candidates.get(i);
			if (current != prev) {
				candidates.remove(i);
				List<List<Integer>> subs = permuteUniqueHelper(candidates);
				candidates.add(i, current);
				for (List<Integer> sub : subs) {
					sub.add(0, current);
				}
				result.addAll(subs);
				prev = current;
			}
		}
		return result;
	}

	/**
	 * Permutation
	 * 
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permute(int[] num) {
		List<Integer> candidates = new ArrayList<>();
		for (int n : num) {
			candidates.add(n);
		}
		return permuteHelper(candidates);
	}

	// this is a basic recursion
	public List<List<Integer>> permuteHelper(List<Integer> candidates) {
		List<List<Integer>> result = new LinkedList<>();
		if (candidates.size() == 1) {
			List<Integer> temp = new LinkedList<>();
			temp.add(candidates.get(0));
			result.add(temp);
			return result;
		}
		for (int i = 0; i < candidates.size(); i++) {
			int current = candidates.remove(i);
			List<List<Integer>> subs = permuteHelper(candidates);
			candidates.add(i, current);
			for (List<Integer> sub : subs) {
				sub.add(0, current);
			}
			result.addAll(subs);
		}
		return result;
	}
}
