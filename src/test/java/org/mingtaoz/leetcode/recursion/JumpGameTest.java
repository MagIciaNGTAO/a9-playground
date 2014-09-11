package org.mingtaoz.leetcode.recursion;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.leetcode.recursion.JumpGame;

public class JumpGameTest {

	private JumpGame sut;

	@Before
	public void setup() {
		sut = new JumpGame();
	}

	@Test
	public void testJumpGame3() {
		int[] i = { 2, 3, 1, 0, 4 };
		ASSERT.that(sut.canJump(i)).isTrue();
	}
	
	@Test
	public void testJumpGame2() {
		int[] i = { 3, 2, 1, 0, 4 };
		ASSERT.that(sut.canJump(i)).isFalse();
	}

	@Test
	public void testJumpGame1() {
		int[] i = { 2, 3, 1, 1, 4 };
		ASSERT.that(sut.canJump(i)).isTrue();
	}
}