package org.mingtaoz.leetcode.iteration;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.leetcode.iteration.CountAndSay;

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
