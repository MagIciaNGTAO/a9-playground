package org.mingtaoz.leetcode.set;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
	// cache the result?
	public List<List<Integer>> combine(int n, int k) {
		if (n < k) {
			return new LinkedList<>();
		}
		if (k == 1) {
			List<List<Integer>> ret = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				List<Integer> temp = new LinkedList<>();
				temp.add(i);
				ret.add(temp);
			}
			return ret;
		}
		List<List<Integer>> sub1 = combine(n - 1, k - 1);
		for (List<Integer> list : sub1) {
			list.add(n);
		}
		List<List<Integer>> sub2 = combine(n - 1, k);
		sub2.addAll(sub1);
		return sub2;
	}
}
