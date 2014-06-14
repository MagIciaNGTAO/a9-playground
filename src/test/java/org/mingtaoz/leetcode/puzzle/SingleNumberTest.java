package org.mingtaoz.leetcode.puzzle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SingleNumberTest extends TestCase {

	private SingleNumber sut;

	public SingleNumberTest(String testName) {
		super(testName);
		sut = new SingleNumber();
	}

	public static Test suite() {
		return new TestSuite(SingleNumberTest.class);
	}

	public void testSingleNumberFrom2Duplicates() {
		int[] input = {1, 1, 2, 2, 3, 3, 4};
		assertEquals(4, sut.singleNumberFrom2Duplicates(input));
	}

}
