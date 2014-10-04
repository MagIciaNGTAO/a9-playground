package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class ParentheseTest {

	private Parenthese sut;

	@Before
	public void setup() {
		sut = new Parenthese();
	}

	@Test
	public void testGenerateParenthesis2() {
		ASSERT.that(sut.generateParenthesis(4).size()).is(14);
	}

	@Test
	public void testGenerateParenthesis1() {
		ASSERT.that(sut.generateParenthesis(3).size()).is(5);
	}

	@Test
	public void testReverseWordsInString6() {
		ASSERT.that(sut.longestValidParentheses("(()()))))")).is(6);
	}

	@Test
	public void testReverseWordsInString5() {
		ASSERT.that(sut.longestValidParentheses("(()()))")).is(6);
	}

	@Test
	public void testReverseWordsInString4() {
		ASSERT.that(sut.longestValidParentheses("(()()")).is(4);
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
