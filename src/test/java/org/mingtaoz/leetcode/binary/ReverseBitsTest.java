package org.mingtaoz.leetcode.binary;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class ReverseBitsTest {

	private ReverseBits sut;

	@Before
	public void setup() {
		sut = new ReverseBits();
	}

	@Test
	public void testReverseBits1() {
		// long i = 1;
		// long o = 2147483648;
	    sut.reverseBits(65536);
		// ASSERT.that(sut.addBinary(i1, i2)).is(o);
	}
}
