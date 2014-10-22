package org.mingtaoz.leetcode.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.leetcode.puzzle.FirstMissingPositive;

public class FirstMissingPositiveTest {

	private FirstMissingPositive sut;

	@Before
	public void setup() {
		sut = new FirstMissingPositive();
	}

	@Test
	public void testFirstMissingPositive2() {
		int[] i = { 0 };
		ASSERT.that(sut.firstMissingPositive(i)).is(1);
	}

	@Test
	public void testFirstMissingPositive1() {
		int[] i = { 1, 1 };
		ASSERT.that(sut.firstMissingPositive(i)).is(2);
	}
}
