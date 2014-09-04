package org.mingtaoz.leetcode.binary;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class AddBinaryTest {

	private AddBinary sut;

	@Before
	public void setup() {
		sut = new AddBinary();
	}

	@Test
	public void testAddBinary1() {
		String i1 = "11";
		String i2 = "1";
		String o = "100";
		ASSERT.that(sut.addBinary(i1, i2)).is(o);
	}
}
