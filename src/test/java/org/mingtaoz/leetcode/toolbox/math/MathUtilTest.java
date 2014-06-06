package org.mingtaoz.leetcode.toolbox.math;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MathUtilTest extends TestCase {
	private MathUtil sut;

	public MathUtilTest(String testName) {
		super(testName);
		sut = new MathUtil();
	}

	public static Test suite() {
		return new TestSuite(MathUtilTest.class);
	}

	// TODO parameterise
	public void testReverseWordsInString1() {
		assertEquals(3, sut.getLargestDenominator(9, 24));
	}

}
