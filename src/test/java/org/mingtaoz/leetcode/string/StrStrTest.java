package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class StrStrTest {

	private StrStr sut;

	@Before
	public void setup() {
		sut = new StrStr();
	}

	@Test
	public void testStrStr3() {
		ASSERT.that(sut.strStr("", "")).is("");
	}

	@Test
	public void testStrStr2() {
		ASSERT.that(sut.strStr("abdabcabc", "abcab")).is("3");
	}

	@Test
	public void testStrStr1() {
		ASSERT.that(sut.strStr("abcabcabc", "ababc")).is("");
	}
}
