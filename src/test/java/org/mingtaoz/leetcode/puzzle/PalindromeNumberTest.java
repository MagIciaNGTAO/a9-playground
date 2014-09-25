package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class PalindromeNumberTest {

	private PalindromeNumber sut;

	@Before
	public void setup() {
		sut = new PalindromeNumber();
	}

	@Test
	public void testPalindromeNumber5() {
		ASSERT.that(sut.isPalindrome(1874994781)).isTrue();
	}

	@Test
	public void testPalindromeNumber4() {
		ASSERT.that(sut.isPalindrome(1211)).isFalse();
	}

	@Test
	public void testPalindromeNumber3() {
		ASSERT.that(sut.isPalindrome(121)).isTrue();
	}

	@Test
	public void testPalindromeNumber2() {
		ASSERT.that(sut.isPalindrome(111)).isTrue();
	}

	@Test
	public void testPalindromeNumber1() {
		ASSERT.that(sut.isPalindrome(11)).isTrue();
	}
}
