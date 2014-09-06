package org.mingtaoz.leetcode.recursion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.leetcode.recursion.ScrambleString;

public class ScrambleStringTest {

	private ScrambleString sut;

	@Before
	public void setup() {
		sut = new ScrambleString();
	}

	@Test
	public void testReverse1() {
		assertEquals("ba", sut.reverse("ab"));
	}

	@Test
	public void testIsScramble1() {
		assertTrue(sut.isScramble("great", "rgeat"));
	}

	@Test
	public void testIsScramble2() {
		assertTrue(sut.isScramble("rgtae", "rgeat"));
	}

	@Test
	public void testIsScramble3() {
		assertFalse(sut.isScramble("rgtae", "rgeaa"));
	}

	@Test
	public void testIsScramble4() {
		assertFalse(sut.isScramble("abcd", "bdac"));
	}

	@Test
	public void testIsScramble5() {
		assertFalse(sut.isScramble("abcdefghijklmn", "efghijklmncadb"));
	}

	@Test
	public void testIsScramble6() {
		assertTrue(sut.isScramble("xstjzkfpkggnhjzkpfjoguxvkbuopi",
				"xbouipkvxugojfpkzjhnggkpfkzjts"));
	}
	
	@Test
	public void testIsScramble7() {
		assertTrue(sut.isScramble("abb", "bab"));
	}

}