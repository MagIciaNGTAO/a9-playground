package org.mingtaoz.leetcode.iteration;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.leetcode.iteration.ClimbingStairs;

public class ClimbingStairsTest {

	private ClimbingStairs sut;

	@Before
	public void setup() {
		sut = new ClimbingStairs();
	}

	@Test
	public void testClimbingStairs1() {
		ASSERT.that(sut.climbStairs(1)).is(1);
		ASSERT.that(sut.climbStairs(2)).is(2);
	}
	
	@Test
	public void testClimbingStairs2() {
		ASSERT.that(sut.climbStairs(3)).is(3);
	}
	
	@Test
	public void testClimbingStairs3() {
		ASSERT.that(sut.climbStairs(4)).is(5);
	}
}
