package org.mingtaoz.leetcode.puzzle;

public class ZigZagConversion {

	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		StringBuilder ret = new StringBuilder();
		char[] cs = s.toCharArray();
		int sizeOfZig = (nRows - 1) * 2;
		int curRow = 0;
		while (curRow < nRows) {
			int i = curRow;
			if (i == 0 || i == nRows - 1) {
				while (i < s.length()) {
					ret.append(cs[i]);
					i += sizeOfZig;
				}
			} else {
				while (i < s.length()) {
					ret.append(cs[i]);
					i += (nRows - curRow - 1) * 2;
					if (i < s.length()) {
						ret.append(cs[i]);
						i += sizeOfZig - (nRows - curRow - 1) * 2;
					}
				}
			}
			curRow++;
		}
		return ret.toString();
	}
}
