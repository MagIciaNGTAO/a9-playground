package org.mingtaoz.leetcode.stack;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.leetcode.stack.TrappingRainWater;

public class TrappingRainWaterTest {

	private TrappingRainWater sut;

	@Before
	public void setup() {
		sut = new TrappingRainWater();
	}

	@Test
	public void testTrappingRainWater4() {
		int[] i = { 4, 2, 0, 3, 2, 5 };
		int o = 9;
		ASSERT.that(sut.trap(i)).is(o);
	}
	
	@Test
	public void testTrappingRainWater3() {
		int[] i = { 2, 1, 0, 2 };
		int o = 3;
		ASSERT.that(sut.trap(i)).is(o);
	}
	
	@Test
	public void testTrappingRainWater2() {
		int[] i = { 4, 2, 3 };
		int o = 1;
		ASSERT.that(sut.trap(i)).is(o);
	}
	
	@Test
	public void testTrappingRainWater1() {
		int[] i = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int o = 6;
		ASSERT.that(sut.trap(i)).is(o);
	}
}
