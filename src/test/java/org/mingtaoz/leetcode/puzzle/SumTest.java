package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import java.util.Arrays;

import org.junit.Test;
import org.junit.Before;

public class SumTest {

	private Sum sut;

	@Before
	public void setup() {
		sut = new Sum();
	}

	@Test
	public void testRemoveTriplicate2() {
		ASSERT.that(sut.removeTrilicate(new int[] { 0, 0, 0, 0 })).is(2);
	}

	@Test
	public void testRemoveTriplicate1() {
		ASSERT.that(sut.removeTrilicate(new int[] { 0, 0, 0 })).is(2);
	}

	@Test
	public void testSum2() {
		ASSERT.that(sut.threeSum(new int[] { 0, 0, 0 })).iteratesAs(
				Arrays.asList(Arrays.asList(0, 0, 0)));
	}

	@Test
	public void testSum1() {
		ASSERT.that(sut.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }))
				.iteratesAs(
						Arrays.asList(Arrays.asList(-1, -1, 2),
								Arrays.asList(-1, 0, 1)));
	}
}
