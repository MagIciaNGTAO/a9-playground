package org.mingtaoz.leetcode.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ScrambleStringTest extends TestCase {

	private ScrambleString sut;

	public ScrambleStringTest(String testName) {
		super(testName);
		sut = new ScrambleString();
	}

	public static Test suite() {
		return new TestSuite(ScrambleStringTest.class);
	}

	public void testNumDecodings1() {
		assertTrue(sut.isScramble("great", "rgeat"));
	}

	public void testNumDecodings2() {
		assertTrue(sut.isScramble("rgtae", "rgeat"));
	}

	public void testNumDecodings3() {
		assertFalse(sut.isScramble("rgtae", "rgeaa"));
	}
	
	public void testNumDecodings4() {
		assertFalse(sut.isScramble("abcd", "bdac"));
	}
}