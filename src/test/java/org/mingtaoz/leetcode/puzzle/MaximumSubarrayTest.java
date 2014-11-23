package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class MaximumSubarrayTest {

	private MaximumSubarray sut;

	@Before
	public void setup() {
		sut = new MaximumSubarray();
	}

	@Test
	public void testMaximumSubarray3() {
		int[] input = { -2, -3, -3 };
		ASSERT.that(sut.maxSubArray(input)).is(-2);
	}

	@Test
	public void testMaximumSubarray2() {
		int[] input = { -2, 1, -3, 4, 6, -1, 2, 1, -5, 4 };
		ASSERT.that(sut.maxSubArray(input)).is(12);
	}

	@Test
	public void testMaximumSubarray1() {
		int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		ASSERT.that(sut.maxSubArray(input)).is(6);
	}
}
