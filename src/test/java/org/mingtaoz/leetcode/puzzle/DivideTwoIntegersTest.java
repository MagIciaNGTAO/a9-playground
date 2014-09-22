package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class DivideTwoIntegersTest {

	private DivideTwoIntegers sut;

	@Before
	public void setup() {
		sut = new DivideTwoIntegers();
	}

	@Test
	public void testDivideTwoIntegers5() {
		ASSERT.that(sut.divide(2147483647, 3)).isEqualTo(715827882);
	}
	
	@Test
	public void testDivideTwoIntegers4() {
		ASSERT.that(sut.divide(-2147483648, 1)).isEqualTo(-2147483648);
	}
	
	@Test
	public void testDivideTwoIntegers3() {
		ASSERT.that(sut.divide(-1087095204, -2147483648)).isEqualTo(0);
	}
	
	@Test
	public void testDivideTwoIntegers2() {
		ASSERT.that(sut.divide(2147483647, 1)).isEqualTo(2147483647);
	}
	
	@Test
	public void testDivideTwoIntegers1() {
		ASSERT.that(sut.divide(6, 2)).isEqualTo(3);
	}
}
