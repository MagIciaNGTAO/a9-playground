package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class FactorialTrailingZeroesTest {

	private FactorialTrailingZeroes sut;

	@Before
	public void setup() {
		sut = new FactorialTrailingZeroes();
	}

	@Test
	public void testFactorialTrailingZeroes1() {
		ASSERT.that(sut.trailingZeroes(1808548329)).is(452137076);
		// ASSERT.that(5/3).is(1);
	}
}
