package org.mingtaoz.leetcode.string;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WordBreakTest extends TestCase {

	private WordBreak sut;

	public WordBreakTest(String testName) {
		super(testName);
		sut = new WordBreak();
	}

	public static Test suite() {
		return new TestSuite(WordBreakTest.class);
	}

	public void testReverseWordsInString1() {
		String input = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		
		assertTrue(sut.wordBreak1(input, dict));
	}

	public void testReverseWordsInString2() {
		String input = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		assertEquals("cat sand dog", sut.wordBreak2(input, dict).get(0));
		assertEquals("cats and dog", sut.wordBreak2(input, dict).get(1));
	}
}
