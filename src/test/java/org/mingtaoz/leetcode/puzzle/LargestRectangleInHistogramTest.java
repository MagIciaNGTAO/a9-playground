package org.mingtaoz.leetcode.puzzle;

import org.junit.Before;
import org.junit.Test;

import static org.truth0.Truth.ASSERT;

public class LargestRectangleInHistogramTest {

	private LargestRectangleInHistogram sut;

	@Before
	public void setup() {
		sut = new LargestRectangleInHistogram();
	}

	@Test
	public void testDeleteDuplicates0() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 1, 1, 5, 1, 1, 1 }))
				.is(6);
	}

	@Test
	public void testDeleteDuplicates1() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }))
				.is(10);
	}

	@Test
	public void testDeleteDuplicates2() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 1, 2, 3, 4 })).is(6);
	}

	@Test
	public void testDeleteDuplicates3() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 2, 3, 5, 9 })).is(10);
	}

	@Test
	public void testDeleteDuplicates4() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 5, 4, 3, 2, 1 }))
				.is(9);
	}

	@Test
	public void testDeleteDuplicates4prime() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 5, 4, 3 })).is(9);
	}

	@Test
	public void testDeleteDuplicates5() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 5, 4, 0, 2, 1 }))
				.is(8);
	}

	@Test
	public void testDeleteDuplicates6() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 2, 0, 2 })).is(2);
	}

	@Test
	public void testDeleteDuplicates7() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 2, 1, 2 })).is(3);
	}

	@Test
	public void testDeleteDuplicates8() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 2, 1, 0, 2 })).is(2);
	}

	@Test
	public void testDeleteDuplicates9() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 1, 1, 1, 2 })).is(4);
	}

	@Test
	public void testDeleteDuplicates10() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 0, 2, 2, 0, 3 }))
				.is(4);
	}

	@Test
	public void testDeleteDuplicates11() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 2, 4, 7 })).is(8);
	}

	@Test
	public void testDeleteDuplicates12() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 5, 9, 5, 15 })).is(20);
	}

	@Test
	public void testDeleteDuplicates13() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 0, 3, 2, 5 })).is(6);
	}

	@Test
	public void testDeleteDuplicates14() {
		ASSERT.that(
				sut.largestRectangleArea(new int[] { 4, 2, 0, 3, 8, 2, 6, 7, 5 }))
				.is(15);
	}

	@Test
	public void testDeleteDuplicates15() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 3, 2, 4, 3, 4 })).is(
				10);
	}

	@Test
	public void testDeleteDuplicates16Prime() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 4, 4, 6, 5, 0 })).is(
				16);
	}

	@Test
	public void testDeleteDuplicates16() {
		ASSERT.that(
				sut.largestRectangleArea(new int[] { 5, 7, 8, 1, 4, 4, 6, 5, 0,
						2 })).is(16);
	}

	@Test
	public void testDeleteDuplicates17() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 3, 2, 7, 2, 2 })).is(
				10);
	}

	@Test
	public void testDeleteDuplicates18() {
		ASSERT.that(sut.largestRectangleArea(new int[] { 4, 2, 0, 3, 2, 5 }))
				.is(6);
	}

	@Test
	public void testDeleteDuplicates19() {
		char[][] input = { { '1', '1' }, { '1', '1' } };
		ASSERT.that(sut.maximalRectangle(input)).is(4);
	}

	@Test
	public void testDeleteDuplicates20() {
		char[][] input = { { '1', '1', '0', '1', '0' },
				{ '0', '1', '0', '0', '0' }, { '1', '1', '1', '1', '1' },
				{ '0', '1', '1', '0', '0' }, { '0', '0', '0', '1', '0' } };
		ASSERT.that(sut.maximalRectangle(input)).is(5);
	}

	@Test
	public void testDeleteDuplicates21() {
		char[][] input = { { '1' } };
		ASSERT.that(sut.maximalRectangle(input)).is(1);
	}
}
