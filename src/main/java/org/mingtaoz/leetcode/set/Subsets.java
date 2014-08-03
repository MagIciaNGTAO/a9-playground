package org.mingtaoz.leetcode.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Subsets {

	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ret = new LinkedList<>();
		Set<String> lookup = new HashSet<>();
		List<Integer> empty = new LinkedList<>();
		ret.add(empty);
		lookup.add(empty.toString());
		for (int i : num) {
			List<List<Integer>> temp = new LinkedList<>();
			for (List<Integer> oldList : ret) {
				List<Integer> newList = new LinkedList<>();
				newList.addAll(oldList);
				newList.add(i);
				if (!lookup.contains(newList.toString())) {
					temp.add(newList);
					lookup.add(newList.toString());
				}
			}
			ret.addAll(temp);
		}
		return ret;
	}
}
