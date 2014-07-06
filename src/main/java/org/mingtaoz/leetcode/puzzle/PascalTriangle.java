package org.mingtaoz.leetcode.puzzle;

import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new LinkedList<>();
		if (numRows == 0)
			return ret;
		List<Integer> prevRow = new LinkedList<>();
		for (int row = 1; row <= numRows; row++) {
			List<Integer> curRow = new LinkedList<>();
			int prev = 0;
			for (Integer ele : prevRow) {
				curRow.add(prev + ele);
				prev = ele;
			}
			curRow.add(1);
			prevRow = curRow;
			ret.add(curRow);
		}
		return ret;
	}

	/**
	 * Given an index k, return the kth row of the Pascal's triangle.
	 * 
	 * For example, given k = 3, Return [1,3,3,1].
	 * 
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new LinkedList<>();
		List<Integer> prevRow = new LinkedList<>();
		for (int row = 0; row <= rowIndex; row++) {
			ret = new LinkedList<>();
			int prev = 0;
			for (Integer ele : prevRow) {
				ret.add(prev + ele);
				prev = ele;
			}
			ret.add(1);
			prevRow = ret;
		}
		return ret;
	}
}
