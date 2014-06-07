package org.mingtaoz.leetcode.geometry;

import org.mingtaoz.leetcode.geometry.MaxPointsOnALine;
import org.mingtaoz.leetcode.geometry.MaxPointsOnALine.Point;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MaxPointsOnALineTest extends TestCase {

	private MaxPointsOnALine sut;

	public MaxPointsOnALineTest(String testName) {
		super(testName);
		sut = new MaxPointsOnALine();
	}

	public static Test suite() {
		return new TestSuite(MaxPointsOnALineTest.class);
	}

	public void testMaxPoints1() {
		Point[] input = { new Point(2, 4), new Point(1, 2), new Point(2, 2) };
		int expected = 2;
		assertEquals(expected, sut.maxPoints(input));
	}

	public void testMaxPoints2() {
		Point[] input = { new Point(0, 0), new Point(-1, -1), new Point(2, 2) };
		int expected = 3;
		assertEquals(expected, sut.maxPoints(input));
	}

	public void testMaxPoints3() {
		Point[] input = { new Point(0, 0), new Point(-1, -1), new Point(0, 0) };
		int expected = 3;
		assertEquals(expected, sut.maxPoints(input));
	}

	public void testMaxPoints4() {
		Point[] input = { new Point(0, 0), new Point(0, 0), new Point(0, 0) };
		int expected = 3;
		assertEquals(expected, sut.maxPoints(input));
	}
	
	public void testMaxPoints5() {
		Point[] input = { new Point(0, 0) };
		int expected = 1;
		assertEquals(expected, sut.maxPoints(input));
	}

	public void testGetLineRep() {
		assertEquals("1.0 0", sut.getLineRep(new Point(0, 0), new Point(2, 2)));
	}

	public void testGetDivideByRep1() {
		String expected = (double) 3 / 2 + "";
		assertEquals(expected, sut.getDivideByRep(3, 2));
	}

	public void testGetDivideByRep2() {
		String expected = "-" + (double) 2 / 2 + "";
		assertEquals(expected, sut.getDivideByRep(-2, 2));
	}
}
