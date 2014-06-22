package org.mingtaoz.leetcode.string;

import java.util.LinkedList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PalindromeTest extends TestCase {

	private Palindrome sut;

	public PalindromeTest(String testName) {
		super(testName);
		sut = new Palindrome();
	}

	public static Test suite() {
		return new TestSuite(PalindromeTest.class);
	}

	public void testPartition1() {
		List<List<String>> expected = new LinkedList<List<String>>();
		List<String> list1 = new LinkedList<String>();
		list1.add("aa");
		list1.add("b");
		List<String> list2 = new LinkedList<String>();
		list2.add("a");
		list2.add("a");
		list2.add("b");
		expected.add(list2);
		expected.add(list1);
		assertEquals(expected, sut.partition("aab"));
	}

	public void testIsPalindrome1() {
		assertTrue(sut.isPalindrome("aa"));
	}

	public void testIsPalindrome2() {
		assertTrue(sut.isPalindrome("aba"));
	}

	public void testIsPalindrome3() {
		assertTrue(sut.isPalindrome("a"));
	}

	public void testBuildPalintable1() {
		boolean[][] expected = { { true, true, false }, { false, true, false },
				{ false, false, true } };
		int n = expected.length;
		boolean[][] result = sut.buildPalintable("aab");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				assertEquals(expected[i][j], result[i][j]);
			}
		}
	}

	public void testBuildPalintable2() {
		boolean[][] expected = { { true, false, false },
				{ false, true, false }, { false, false, true } };
		int n = expected.length;
		boolean[][] result = sut.buildPalintable("abc");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				assertEquals(expected[i][j], result[i][j]);
			}
		}
	}

	public void testBuildPalintable3() {
		boolean[][] expected = {
				{ true, false, false, false, false, false, false, false, false,
						false },
				{ false, true, false, true, false, true, false, false, false,
						false },
				{ false, false, true, false, true, false, true, false, false,
						false },
				{ false, false, false, true, false, true, false, false, false,
						false },
				{ false, false, false, false, true, false, true, false, false,
						false },
				{ false, false, false, false, false, true, false, false, false,
						false },
				{ false, false, false, false, false, false, true, false, true,
						false },
				{ false, false, false, false, false, false, false, true, false,
						true },
				{ false, false, false, false, false, false, false, false, true,
						false },
				{ false, false, false, false, false, false, false, false,
						false, true } };
		int n = expected.length;
		boolean[][] result = sut.buildPalintable("cabababcbc");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				assertEquals(expected[i][j], result[i][j]);
			}
		}
	}

	public void testMinCut1() {
		assertEquals(1, sut.minCut("aab"));
	}

	public void testMinCut2() {
		assertEquals(2, sut.minCut("abc"));
	}

	public void testMinCut3() {
		assertEquals(0, sut.minCut("aba"));
	}

	public void testMinCut4() {
		int expected = 3;
		int result = sut.minCut("cabababcbc");
		assertEquals(expected, result);
	}

	public void testMinCut5() {
		int expected = 75;
		int result = sut
				.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi");
		assertEquals(expected, result);
	}

	public void testMinCut6() {
		int expected = 1;
		int result = sut
				.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(expected, result);
	}

}
