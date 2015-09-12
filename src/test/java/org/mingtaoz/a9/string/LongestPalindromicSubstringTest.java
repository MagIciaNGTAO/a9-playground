package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.LongestPalindromicSubstring;

public class LongestPalindromicSubstringTest {

	private LongestPalindromicSubstring sut;

	@Before
	public void setup() {
		sut = new LongestPalindromicSubstring();
	}

	@Test
	public void testReverseWordsInString2() {
		ASSERT.that(sut.longestPalindrome("bb")).is("bb");
	}

	@Test
	public void testReverseWordsInString1() {
		ASSERT.that(sut.longestPalindrome("aaa")).is("aaa");
	}
}
