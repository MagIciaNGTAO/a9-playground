package org.mingtaoz.leetcode.graph;

import org.mingtaoz.leetcode.graph.MaxPointsOnALine.Point;

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
		Point[] input = { new Point(2, 4), new Point(1, 2)};
		int expected = 2;
		assertEquals(expected, sut.maxPoints(input));
	}
	
	public void testGetDivideByRep1() {
		String expected = "1/1";
		assertEquals(expected, sut.getDivideByRep(2, 2));
	}
	
	public void testGetDivideByRep2() {
		String expected = "2/1";
		assertEquals(expected, sut.getDivideByRep(4, 2));
	}
	
	public void testGetDivideByRep3() {
		String expected = "2/3";
		assertEquals(expected, sut.getDivideByRep(4, 6));
	}
}
