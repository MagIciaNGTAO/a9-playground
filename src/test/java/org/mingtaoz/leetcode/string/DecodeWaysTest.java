package org.mingtaoz.leetcode.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DecodeWaysTest extends TestCase {

	private DecodeWays sut;

	public DecodeWaysTest(String testName) {
		super(testName);
		sut = new DecodeWays();
	}

	public static Test suite() {
		return new TestSuite(DecodeWaysTest.class);
	}

	public void testNumDecodings1() {
		assertEquals(2, sut.numDecodings("12"));
	}

	public void testNumDecodings2() {
		// 12 6
		// 1 26
		// 1 2 6
		assertEquals(3, sut.numDecodings("126"));
	}

	public void testNumDecodings3() {
		// 12 7
		// 1 2 7
		assertEquals(2, sut.numDecodings("127"));
	}

	public void testNumDecodings4() {
		// 10 7
		assertEquals(1, sut.numDecodings("107"));
	}

	public void testNumDecodings5() {
		assertEquals(0, sut.numDecodings("1007"));
	}

	public void testNumDecodings6() {
		assertEquals(
				3981312,
				sut.numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
	}
}
