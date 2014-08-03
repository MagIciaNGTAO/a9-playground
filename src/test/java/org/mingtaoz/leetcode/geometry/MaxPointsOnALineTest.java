package org.mingtaoz.leetcode.geometry;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.leetcode.geometry.MaxPointsOnALine;
import org.mingtaoz.leetcode.geometry.MaxPointsOnALine.Point;

public class MaxPointsOnALineTest {

	private MaxPointsOnALine sut;

	@Before
	public void setup() {
		sut = new MaxPointsOnALine();
	}

	@Test
	public void testMaxPoints1() {
		Point[] input = { new Point(2, 4), new Point(1, 2), new Point(2, 2) };
		int expected = 2;
		assertEquals(expected, sut.maxPoints(input));
	}

	@Test
	public void testMaxPoints2() {
		Point[] input = { new Point(0, 0), new Point(-1, -1), new Point(2, 2) };
		int expected = 3;
		assertEquals(expected, sut.maxPoints(input));
	}

	@Test
	public void testMaxPoints3() {
		Point[] input = { new Point(0, 0), new Point(-1, -1), new Point(0, 0) };
		int expected = 3;
		assertEquals(expected, sut.maxPoints(input));
	}

	@Test
	public void testMaxPoints4() {
		Point[] input = { new Point(0, 0), new Point(0, 0), new Point(0, 0) };
		int expected = 3;
		assertEquals(expected, sut.maxPoints(input));
	}

	@Test
	public void testMaxPoints5() {
		Point[] input = { new Point(0, 0) };
		int expected = 1;
		assertEquals(expected, sut.maxPoints(input));
	}

	@Test
	public void testGetLineRep() {
		assertEquals("1.0 0", sut.getLineRep(new Point(0, 0), new Point(2, 2)));
	}

	@Test
	public void testGetDivideByRep1() {
		String expected = (double) 3 / 2 + "";
		assertEquals(expected, sut.getDivideByRep(3, 2));
	}

	@Test
	public void testGetDivideByRep2() {
		String expected = "-" + (double) 2 / 2 + "";
		assertEquals(expected, sut.getDivideByRep(-2, 2));
	}
}
