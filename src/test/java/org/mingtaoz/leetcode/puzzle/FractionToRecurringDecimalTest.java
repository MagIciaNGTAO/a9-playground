package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class FractionToRecurringDecimalTest {

	private FractionToRecurringDecimal sut;

	@Before
	public void setup() {
		sut = new FractionToRecurringDecimal();
	}

	@Test
	public void testFractionToRecurringDecimal7() {
		ASSERT.that(sut.fractionToDecimal(-1, -2147483648)).is(
				"0.0000000004656612873077392578125");
	}

	@Test
	public void testFractionToRecurringDecimal6() {
		ASSERT.that(sut.fractionToDecimal(7, 12)).is("0.58(3)");
	}

	@Test
	public void testFractionToRecurringDecimal5() {
		ASSERT.that(sut.fractionToDecimal(7, -12)).is("-0.58(3)");
	}

	@Test
	public void testFractionToRecurringDecimal4() {
		ASSERT.that(sut.fractionToDecimal(5, 3)).is("1.(6)");
	}

	@Test
	public void testFractionToRecurringDecimal3() {
		ASSERT.that(sut.fractionToDecimal(2, 3)).is("0.(6)");
	}

	@Test
	public void testFractionToRecurringDecimal2() {
		ASSERT.that(sut.fractionToDecimal(1, 2)).is("0.5");
	}

	@Test
	public void testFractionToRecurringDecimal1() {
		ASSERT.that(sut.fractionToDecimal(2, 1)).is("2");
	}
}
