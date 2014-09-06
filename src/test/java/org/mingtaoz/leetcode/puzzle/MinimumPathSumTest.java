package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class MinimumPathSumTest {

	private MinimumPathSum sut;

	@Before
	public void setup() {
		sut = new MinimumPathSum();
	}

	@Test
	public void testMinimumPathSum2() {
		int[][] input = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		ASSERT.that(sut.minPathSum(input)).is(7);
	}

	@Test
	public void testMinimumPathSum1() {
		int[][] input = { { 1, 2, 3 } };
		ASSERT.that(sut.minPathSum(input)).is(6);
	}
}
