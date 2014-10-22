package org.mingtaoz.leetcode.math;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.leetcode.math.PowXN;

public class PowXNTest {

	private PowXN sut;

	@Before
	public void setup() {
		sut = new PowXN();
	}

	@Test
	public void testPowXN1() {
		ASSERT.that(sut.pow(0.00001, 2147483647)).is(
				Math.pow(0.00001, 2147483647));
	}
}
