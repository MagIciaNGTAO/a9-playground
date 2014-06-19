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

	public void testPartition() {
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
	
	public void testMinCut1() {
		assertEquals(1, sut.minCut(""));
	}
}
