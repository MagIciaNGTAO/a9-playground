package org.mingtaoz.leetcode.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.leetcode.array.Arrays;

public class ArraysTest {

	private Arrays sut;

	@Before
	public void setup() {
		sut = new Arrays();
	}

	@Test
	public void testSearchRange1() {
		int[] A = { 1, 4 };
		ASSERT.that(sut.searchRange(A, 4)).is(new int[]{1, 1});
	}

	
	@Test
	public void testPlusOne2() {
		int[] i = { 9 };
		int[] o = { 1, 0 };
		ASSERT.that(sut.plusOne(i)).is(o);;
	}

	@Test
	public void testPlusOne1() {
		int[] i = { 4, 5, 6, 7, 0, 1, 2 };
		int[] o = { 4, 5, 6, 7, 0, 1, 3 };
		ASSERT.that(sut.plusOne(i)).is(o);;
	}
	
	@Test
	public void testFindMinIndex1() {
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		ASSERT.that(sut.findMinIndex(A)).is(4);
	}

	@Test
	public void testFindMinIndex2() {
		int[] A = { 4, 5, 6, 7, 8, 1, 2 };
		ASSERT.that(sut.findMinIndex(A)).is(5);
	}

	@Test
	public void testFindMinIndex3() {
		int[] A = { 1, 3, 1, 1, 1 };
		ASSERT.that(sut.findMinIndex(A)).is(2);
	}

	@Test
	public void testFindMinIndex4() {
		int[] A = { 3, 1, 1, 1, 1 };
		ASSERT.that(sut.findMinIndex(A)).is(1);
	}

	@Test
	public void testFindMinIndex5() {
		int[] A = { 1, 1, 1, 3, 1 };
		ASSERT.that(sut.findMinIndex(A)).is(4);
	}

	@Test
	public void testFindMinIndex6() {
		int[] A = { 2, 2, 2, 0, 2, 2 };
		ASSERT.that(sut.findMinIndex(A)).is(3);
	}

	@Test
	public void testSearchn1() {
		int[] A = { 3, 1 };
		ASSERT.that(sut.search(A, 4)).is(-1);
	}

	@Test
	public void testSearchn() {
		int[] A = { 1, 3 };
		ASSERT.that(sut.search(A, 0)).is(-1);
	}

	@Test
	public void testSearchn2() {
		int[] A = { 1, 3 };
		ASSERT.that(sut.search(A, 4)).is(-1);
	}

	@Test
	public void testSearch0() {
		int[] A = { 1 };
		ASSERT.that(sut.search(A, 0)).is(-1);
	}

	@Test
	public void testSearch1() {
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		ASSERT.that(sut.search(A, 7)).is(3);
	}

	@Test
	public void testSearch4() {
		int[] A = { 4, 4, 4, 7, 0, 1, 2 };
		ASSERT.that(sut.search(A, 7)).is(3);
	}

	@Test
	public void testSearch2() {
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		ASSERT.that(sut.search(A, 0)).is(4);
	}

	@Test
	public void testSearch3() {
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
		ASSERT.that(sut.search(A, 9)).is(-1);
	}

	@Test
	public void testSearch6() {
		int[] A = { 2, 4, 5, 7, 1 };
		ASSERT.that(sut.search(A, 0)).is(-1);
	}

	@Test
	public void testSearch10() {
		int[] A = { 1, 1, 1, 3, 1 };
		ASSERT.that(sut.search(A, 3)).is(3);
	}

	@Test
	public void testSearch7() {
		int[] A = { 1, 3, 1, 1, 1 };
		ASSERT.that(sut.search(A, 3)).is(1);
	}

	@Test
	public void testSearch8() {
		int[] A = { 3, 1, 1, 1, 1 };
		ASSERT.that(sut.search(A, 4)).is(-1);
	}

	@Test
	public void testSearch9() {
		int[] A = { 1, 1, 1, 3, 1 };
		ASSERT.that(sut.search(A, 3)).is(3);
	}

	@Test
	public void testSearch11() {
		int[] A = { 1, 3 };
		ASSERT.that(sut.search(A, 1)).is(0);
	}

	@Test
	public void testSearch12() {
		int[] A = { 2, 0, 1, 1, 1 };
		ASSERT.that(sut.search(A, 2)).is(0);
	}

	@Test
	public void testMerge1() {
		int[] A = { 1, 3, 5, 7, 0, 0, 0, 0 };
		int[] B = { 2, 4, 6, 8 };
		int[] ret = { 1, 2, 3, 4, 5, 6, 7, 8 };
		sut.merge(A, 4, B, 4);
		for (int i = 0; i < A.length; i++) {
			ASSERT.that(ret[i]).is(A[i]);
		}
	}

	@Test
	public void testMerge2() {
		int[] A = { 1, 3, 5, 7, 9, 11, 0, 0, 0, 0 };
		int[] B = { 2, 4, 6, 8 };
		int[] ret = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 };
		sut.merge(A, 6, B, 4);
		for (int i = 0; i < A.length; i++) {
			ASSERT.that(ret[i]).is(A[i]);
		}
	}

	@Test
	public void testMerge3() {
		int[] A = { 1, 3, 5, 0, 0, 0, 0, 0 };
		int[] B = { 2, 4, 6, 8, 10 };
		int[] ret = { 1, 2, 3, 4, 5, 6, 8, 10 };
		sut.merge(A, 3, B, 5);
		for (int i = 0; i < A.length; i++) {
			ASSERT.that(ret[i]).is(A[i]);
		}
	}

	@Test
	public void testMoveAToRight1() {
		int[] A = { 1, 3, 5, 7, 0, 0, 0, 0 };
		int[] ret = { 1, 3, 5, 7, 1, 3, 5, 7 };
		sut.moveAToRight(A, 4, 4);
		for (int i = 0; i < A.length; i++) {
			ASSERT.that(ret[i]).is(A[i]);
		}
	}

	@Test
	public void testMerge4() {
		int[] A = { 1, 2, 3, 0, 0, 0 };
		int[] B = { 2, 5, 6 };
		int[] ret = { 1, 2, 2, 3, 5, 6 };
		sut.merge(A, 3, B, 3);
		for (int i = 0; i < A.length; i++) {
			ASSERT.that(ret[i]).is(A[i]);
		}
	}
}
