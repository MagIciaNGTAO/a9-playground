package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class CompareVersionNumbersTest {

	private CompareVersionNumbers sut;

	@Before
	public void setup() {
		sut = new CompareVersionNumbers();
	}

	@Test
	public void testCompareVersionNumbers2() {
		ASSERT.that(sut.compareVersion("1.0", "1.1")).is(-1);
	}

	@Test
	public void testCompareVersionNumbers1() {
		ASSERT.that(sut.compareVersion("1", "0")).is(1);
	}
}
