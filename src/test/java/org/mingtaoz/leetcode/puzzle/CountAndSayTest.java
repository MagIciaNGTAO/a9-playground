package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class CountAndSayTest {

	private CountAndSay sut;

	@Before
	public void setup() {
		sut = new CountAndSay();
	}

	@Test
	public void testCountAndSay1() {
		ASSERT.that(sut.countAndSay(4)).isEqualTo("1211");
	}
}
