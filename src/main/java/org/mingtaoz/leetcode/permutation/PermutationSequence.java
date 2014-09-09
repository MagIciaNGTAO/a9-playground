package org.mingtaoz.leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
		StringBuilder builder = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		int i = 1, perm = 1;
		while (i <= n) {
			perm *= i;
			list.add(i++);
		}
		perm /= n--;
		while (!list.isEmpty()) {
			if (list.size() == 1) {
				builder.append(list.get(0));
				return builder.toString();
			} else {
				int seq = (k - 1) / perm;
				k = (k - 1) % perm + 1;
				perm /= n--;
				builder.append(list.remove(seq));
			}
		}
		return builder.toString();
	}

}
