package org.mingtaoz.leetcode.toolbox.array;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ArraysTest extends TestCase {

	private Arrays sut;

	public ArraysTest(String testName) {
		super(testName);
		sut = new Arrays();
	}

	public static Test suite() {
		return new TestSuite(ArraysTest.class);
	}

	public void testMerge1() {
		int[] A = { 1, 3, 5, 7, 0, 0, 0, 0 };
		int[] B = { 2, 4, 6, 8 };
		int[] ret = { 1, 2, 3, 4, 5, 6, 7, 8 };
		sut.merge(A, 4, B, 4);
		for (int i = 0; i < A.length; i++) {
			assertEquals(ret[i], A[i]);
		}
	}

	public void testMerge2() {
		int[] A = { 1, 3, 5, 7, 9, 11, 0, 0, 0, 0 };
		int[] B = { 2, 4, 6, 8 };
		int[] ret = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 };
		sut.merge(A, 6, B, 4);
		for (int i = 0; i < A.length; i++) {
			assertEquals(ret[i], A[i]);
		}
	}

	public void testMerge3() {
		int[] A = { 1, 3, 5, 0, 0, 0, 0, 0 };
		int[] B = { 2, 4, 6, 8, 10 };
		int[] ret = { 1, 2, 3, 4, 5, 6, 8, 10 };
		sut.merge(A, 3, B, 5);
		for (int i = 0; i < A.length; i++) {
			assertEquals(ret[i], A[i]);
		}
	}

	public void testMoveAToRight1() {
		int[] A = { 1, 3, 5, 7, 0, 0, 0, 0 };
		int[] ret = { 1, 3, 5, 7, 1, 3, 5, 7 };
		sut.moveAToRight(A, 4, 4);
		for (int i = 0; i < A.length; i++) {
			assertEquals(ret[i], A[i]);
		}
	}

	public void testMerge4() {
		int[] A = { 1, 2, 3, 0, 0, 0 };
		int[] B = { 2, 5, 6 };
		int[] ret = { 1, 2, 2, 3, 5, 6 };
		sut.merge(A, 3, B, 3);
		for (int i = 0; i < A.length; i++) {
			assertEquals(ret[i], A[i]);
		}
	}
}
