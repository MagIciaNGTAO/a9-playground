package org.mingtaoz.leetcode.puzzle;

import org.junit.Before;
import org.junit.Test;

import static org.truth0.Truth.ASSERT;

public class LargestRectangleTest {

	private LargestRectangle sut;

	@Before
	public void setup() {
		sut = new LargestRectangle();
	}

	/**
	 * Given height = [2,1,5,6,2,3], return 10.
	 */
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
				.is(8);
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

}
