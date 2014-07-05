package org.mingtaoz.leetcode.puzzle;

import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TriangleTest extends TestCase {

	private Triangle sut;

	public TriangleTest(String testName) {
		super(testName);
		sut = new Triangle();
	}

	public static Test suite() {
		return new TestSuite(TriangleTest.class);
	}

	public void testTriangle1() {
		List<List<Integer>> triangle = Arrays.asList(Arrays
				.asList(new Integer[] { -10 }));
		assertEquals(-10, sut.minimumTotal(triangle));
	}

	public void testTriangle2() {
		List<List<Integer>> triangle = Arrays.asList(
				Arrays.asList(new Integer[] { 1 }),
				Arrays.asList(new Integer[] { 2, 3 }));
		assertEquals(3, sut.minimumTotal(triangle));
	}

	public void testTriangle3() {
		List<List<Integer>> triangle = Arrays.asList(
				Arrays.asList(new Integer[] { -1 }),
				Arrays.asList(new Integer[] { -2, -3 }));
		assertEquals(-4, sut.minimumTotal(triangle));
	}

	public void testTriangle4() {
		List<List<Integer>> triangle = Arrays.asList(
				Arrays.asList(new Integer[] { 2 }),
				Arrays.asList(new Integer[] { 3, 4 }),
				Arrays.asList(new Integer[] { 6, 5, 7 }),
				Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
		assertEquals(11, sut.minimumTotal(triangle));
	}
}
