package org.mingtaoz.leetcode.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {

	private Set<String> permutated = new HashSet<>();

	public List<List<Integer>> permuteUnique(int[] num) {
		List<Integer> candidates = new ArrayList<>();
		for (int n : num) {
			candidates.add(n);
		}
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
		for (int i = 0; i < candidates.size(); i++) {
			int current = candidates.remove(i);
			List<List<Integer>> subs = permuteUniqueHelper(candidates);
			candidates.add(i, current);
			for (List<Integer> sub : subs) {
				String repr = sub.toString();
				if(!permutated.contains(repr)) {
					permutated.add(repr);
					sub.add(0, current);
				}
			}
			result.addAll(subs);
		}
		return result;
	}
	
	public List<List<Integer>> permute(int[] num) {
		List<Integer> candidates = new ArrayList<>();
		for (int n : num) {
			candidates.add(n);
		}
		return permuteHelper(candidates);
	}

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
