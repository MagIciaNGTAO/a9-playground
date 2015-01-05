package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class MajorityElementTest {

	private MajorityElement sut;

	@Before
	public void setup() {
		sut = new MajorityElement();
	}

	@Test
	public void testMajorityElement2() {
		int[] i = { -1, -1, 2147483647 };
		ASSERT.that(sut.majorityElement(i)).is(-1);
	}

	@Test
	public void testMajorityElement1() {
		int[] i = { 3, 3, 4 };
		ASSERT.that(sut.majorityElement(i)).is(3);
	}
}
