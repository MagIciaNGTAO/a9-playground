package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class MinimumWindowSubstringTest {

	private MinimumWindowSubstring sut;

	@Before
	public void setup() {
		sut = new MinimumWindowSubstring();
	}

	@Test
	public void testMinWindow1() {
		ASSERT.that(sut.minWindow("ADOBECODEBANC", "ABC")).is("BANC");
		ASSERT.that(sut.minWindow("a", "aa")).is("");
	}
}
