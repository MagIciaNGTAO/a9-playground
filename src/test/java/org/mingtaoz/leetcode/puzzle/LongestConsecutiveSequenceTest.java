package org.mingtaoz.leetcode.puzzle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LongestConsecutiveSequenceTest extends TestCase {

	private LongestConsecutiveSequence sut;

	public LongestConsecutiveSequenceTest(String testName) {
		super(testName);
		sut = new LongestConsecutiveSequence();
	}

	public static Test suite() {
		return new TestSuite(LongestConsecutiveSequenceTest.class);
	}

	public void testLongestConsecutiveSequence1() {
		assertEquals(4,
				sut.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}

	public void testLongestConsecutiveSequence2() {
		assertEquals(1, sut.longestConsecutive(new int[] { 0 }));
	}

	public void testLongestConsecutiveSequence3() {
		assertEquals(3, sut.longestConsecutive(new int[] { -1, 1, 0 }));
	}

	public void testLongestConsecutiveSequence4() {
		assertEquals(
				14,
				sut.longestConsecutive(new int[] { -6, 6, -9, -7, 0, 3, 4, -2,
						2, -1, 9, -9, 5, -3, 6, 1, 5, -1, -2, 9, -9, -4, -6,
						-5, 6, -1, 3 }));
	}
}
