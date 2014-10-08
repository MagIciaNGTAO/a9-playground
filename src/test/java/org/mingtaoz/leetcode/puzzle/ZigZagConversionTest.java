package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class ZigZagConversionTest {

	private ZigZagConversion sut;

	@Before
	public void setup() {
		sut = new ZigZagConversion();
	}

	@Test
	public void testZigZagConversion3() {
		ASSERT.that(sut.convert("ABCDE", 4)).is("ABCED");
	}

	@Test
	public void testZigZagConversion2() {
		ASSERT.that(sut.convert("A", 1)).is("A");
	}

	@Test
	public void testZigZagConversion1() {
		ASSERT.that(sut.convert("PAYPALISHIRING", 3)).is("PAHNAPLSIIGYIR");
	}
}
