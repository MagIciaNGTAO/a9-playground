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
	public void testJumpGame8() {
		int[] i = { 3,4,3,1,0,7,0,3,0,2,0,3 };
		ASSERT.that(sut.jump(i)).is(3);
	}
	
	@Test
	public void testJumpGame7() {
		int[] i = { 1, 1,1,1 };
		ASSERT.that(sut.jump(i)).is(3);
	}
	
	@Test
	public void testJumpGame6() {
		int[] i = { 1, 2 };
		ASSERT.that(sut.jump(i)).is(1);
	}
	
	@Test
	public void testJumpGame5() {
		int[] i = { 1, 2, 3 };
		ASSERT.that(sut.jump(i)).is(2);
	}
	
	@Test
	public void testJumpGame4() {
		int n = 25000;
		int[] i = new int[n + 1];
		for (int j = 0; j < n + 1; j++) {
			i[j] = n + 1 - j;
		}
		ASSERT.that(sut.jump(i)).is(1);
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