package org.mingtaoz.leetcode.puzzle;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WordLadderTest extends TestCase {

	private WordLadder sut;

	public WordLadderTest(String testName) {
		super(testName);
		sut = new WordLadder();
	}

	public static Test suite() {
		return new TestSuite(WordLadderTest.class);
	}

	public void testNeighbours1() {
		Set<String> dict = new HashSet<>();
		dict.add("abe");
		String s = "abc";
		assertEquals("abe", sut.neighbours(s, dict).get(0));
		assertEquals(1, sut.neighbours(s, dict).size());
	}
	
	public void testNeighbours2() {
		Set<String> dict = new HashSet<>();
		dict.add("abe");
		dict.add("abd");
		String s = "abc";
		assertTrue("abe".equals(sut.neighbours(s, dict).get(0)) || "abd".equals(sut.neighbours(s, dict).get(0)));
		assertTrue("abe".equals(sut.neighbours(s, dict).get(1)) || "abd".equals(sut.neighbours(s, dict).get(1)));
		assertEquals(2, sut.neighbours(s, dict).size());
	}
}
