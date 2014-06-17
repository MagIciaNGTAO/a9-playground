package org.mingtaoz.leetcode.puzzle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CandyTest extends TestCase {

	private Candy sut;

	public CandyTest(String testName) {
		super(testName);
		sut = new Candy();
	}

	public static Test suite() {
		return new TestSuite(CandyTest.class);
	}

	public void testCandy1() {
		int[] ratings = { 1, 2, 3 };
		assertEquals(6, sut.candy(ratings));
	}

	public void testCandy2() {
		int[] ratings = { 3, 2, 1 };
		assertEquals(6, sut.candy(ratings));
	}

	public void testCandy3() {
		int[] ratings = { 2, 2 };
		assertEquals(2, sut.candy(ratings));
	}

	public void testCandy4() {
		int[] ratings = { 1, 2, 2 };
		assertEquals(4, sut.candy(ratings));
	}

	public void testCandy5() {
		int[] ratings = { 1, 0, 2 };
		assertEquals(5, sut.candy(ratings));
	}

	public void testCandy6() {
		int[] ratings = { 4, 2, 3, 4, 1 };
		assertEquals(9, sut.candy(ratings));
	}

	public void testCandy7() {
		int[] ratings = { 1, 2, 4, 4, 3 };
		assertEquals(9, sut.candy(ratings));
	}

	public void testCandy8() {
		int[] ratings = { 5, 1, 1, 1, 10, 2, 1, 1, 1, 3 };
		assertEquals(15, sut.candy(ratings));
	}

}
