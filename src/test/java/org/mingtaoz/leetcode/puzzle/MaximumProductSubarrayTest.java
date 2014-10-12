package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class MaximumProductSubarrayTest {

	private MaximumProductSubarray sut;

	@Before
	public void setup() {
		sut = new MaximumProductSubarray();
	}

	@Test
	public void testMaximumProductSubarray5() {
		ASSERT.that(sut.maxProduct(new int[] { 0, -1 })).is(0);
	}

	@Test
	public void testMaximumProductSubarray4() {
		ASSERT.that(
				sut.maxProduct(new int[] { 1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4 }))
				.is(1280);
	}

	@Test
	public void testMaximumProductSubarray3() {
		ASSERT.that(sut.maxProduct(new int[] { -2, -3, 7 })).is(42);
	}

	@Test
	public void testMaximumProductSubarray2() {
		ASSERT.that(sut.maxProduct(new int[] { -2 })).is(-2);
	}

	@Test
	public void testMaximumProductSubarray1() {
		ASSERT.that(sut.maxProduct(new int[] { 2, 3, -2, 4 })).is(6);
	}
}
