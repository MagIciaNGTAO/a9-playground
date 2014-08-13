package org.mingtaoz.leetcode.puzzle;

// TODO it's terriable, but it's 120% by myself ...
public class Sqrt {
	public int sqrt(int x) {
		if (x == 0) {
			return 0;
		}
		if (x <= 3) {
			return 1;
		}
		long ret = x / 2, sq = ret * ret;
		while (true) {
			ret = ret + (int) Math.round((double) (x - sq) / (2 * ret));
			if (sq == ret * ret) {
				ret = ret - 1;
			}
			sq = ret * ret;
			long sqp = (ret + 1) * (ret + 1);
			if (sq <= x && sqp > x) {
				// leetcode require a 'less than or equal' solution strictly
				break;
			}
		}
		return (int) ret;
	}
}
