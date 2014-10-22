package org.mingtaoz.leetcode.math;

import org.mingtaoz.leetcode.math.MathUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MathUtilTest extends TestCase {

	public MathUtilTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(MathUtilTest.class);
	}

	public void testReverseWordsInString1() {
		assertEquals(3, MathUtil.getLargestDenominator(9, 24));
	}

}
