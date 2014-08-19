package org.mingtaoz.leetcode.toolbox.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

	private MedianOfTwoSortedArrays sut;

	@Before
	public void setup() {
		sut = new MedianOfTwoSortedArrays();
	}

	@Test
	public void testFindMinIndex1() {
		int[] A = { 1, 3, 5 };
		int[] B = { 2, 4, 6 };
		ASSERT.that(sut.findMedianSortedArrays(A, B)).is(3.5);
	}
}
