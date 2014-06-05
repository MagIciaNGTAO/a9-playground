package org.mingtaoz.leetcode.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ReverseWordsInStringTest extends TestCase {

	private ReverseWordsInString sut;

	public ReverseWordsInStringTest(String testName) {
		super(testName);
		sut = new ReverseWordsInString();
	}

	public static Test suite() {
		return new TestSuite(ReverseWordsInStringTest.class);
	}

	public void testReverseWordsInString1() {
		String input = "the sky is blue";
		String expected = "blue is sky the";
		assertEquals(expected, sut.reverseWordsInString(input));
	}
	
	public void testReverseWordsInString2() {
		String input = " the sky is";
		String expected = "is sky the ";
		assertEquals(expected, sut.reverseWordsInString(input));
	}
	
	public void testReverseWordsInString3() {
		String input = "the";
		String expected = "the";
		assertEquals(expected, sut.reverseWordsInString(input));
	}
}
