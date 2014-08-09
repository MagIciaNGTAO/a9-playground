package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class WordSearchTest {

	private WordSearch sut;

	@Before
	public void setup() {
		sut = new WordSearch();
	}

	@Test
	public void testWordSearch1() {
		char[][] input = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		ASSERT.that(sut.exist(input, "ABCCED")).isTrue();
		ASSERT.that(sut.exist(input, "SEE")).isTrue();
		ASSERT.that(sut.exist(input, "ABCB")).isFalse();
	}

	@Test
	public void testWordSearch2() {
		char[][] input = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		ASSERT.that(sut.exist(input, "ABCESEEEFS")).isTrue();
	}
}
