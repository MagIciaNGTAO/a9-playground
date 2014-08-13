package org.mingtaoz.leetcode.toolbox.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class ArraysTest {

	private Arrays sut;

	@Before
	public void setup() {
		sut = new Arrays();
	}

	@Test
	public void testSearch1() {
		int[] A = { 4, 5, 6, 7, 0, 1, 2 };
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
