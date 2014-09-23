package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class LongestValidParenthesesTest {

	private LongestValidParentheses sut;

	@Before
	public void setup() {
		sut = new LongestValidParentheses();
	}

	@Test
	public void testReverseWordsInString3() {
		ASSERT.that(sut.longestValidParentheses("(()())")).is(6);
	}
	
	@Test
	public void testReverseWordsInString2() {
		ASSERT.that(sut.longestValidParentheses("()")).is(2);
	}
	
	@Test
	public void testReverseWordsInString1() {
		ASSERT.that(sut.longestValidParentheses("()(())")).is(6);
	}
}
