package org.mingtaoz.leetcode.matrix;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class SearchA2DMatrixTest {
	private SearchA2DMatrix sut;

	@Before
	public void setup() {
		sut = new SearchA2DMatrix();
	}

	@Test
	public void testWordSearch1() {
		int[][] input = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		ASSERT.that(sut.searchMatrix(input, 3)).isTrue();
	}

	@Test
	public void testWordSearch2() {
		int[][] input = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		ASSERT.that(sut.searchMatrix(input, 3)).isTrue();
	}

	
	@Test
	public void testBinarySearch1() {
		int[] input = { 1, 3, 5, 7 };
		ASSERT.that(sut.binarySearch(input, 3)).isTrue();
	}

	@Test
	public void testBinarySearch2() {
		int[] input = { 3 };
		ASSERT.that(sut.binarySearch(input, 3)).isTrue();
	}

	@Test
	public void testBinarySearch3() {
		int[] input = { 1, 3 };
		ASSERT.that(sut.binarySearch(input, 3)).isTrue();
	}

	@Test
	public void testBinarySearch4() {
		int[] input = { 3, 4 };
		ASSERT.that(sut.binarySearch(input, 3)).isTrue();
	}

	@Test
	public void testBinarySearch5() {
		int[] input = { 1, 3, 4, 6, 8, 9 };
		ASSERT.that(sut.binarySearch(input, 2)).isFalse();
	}

	@Test
	public void testBinarySearch6() {
		int[] input = { 1, 3, 4, 6, 8 };
		ASSERT.that(sut.binarySearch(input, 2)).isFalse();
	}
}
