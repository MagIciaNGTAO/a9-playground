package org.mingtaoz.leetcode.matrix;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class RotateImageTest {
	private RotateImage sut;

	@Before
	public void setup() {
		sut = new RotateImage();
	}

	// TODO
	@Test
	public void testWordSearch1() {
		int[][] input = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		sut.rotate(input);
		// System.out.println(input);
		// ASSERT.that(sut.rotate(input));
	}
}
