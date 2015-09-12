package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.WordBreak;

public class WordBreakTest {

	private WordBreak sut;

	@Before
	public void setup() {
		sut = new WordBreak();
	}

	@Test
	public void testReverseWordsInString1() {
		String input = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");

		ASSERT.that(sut.wordBreak1(input, dict)).isTrue();
	}

	@Test
	public void testReverseWordsInString2() {
		String input = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		ASSERT.that(sut.wordBreak2(input, dict).get(0)).is("cat sand dog");
		ASSERT.that(sut.wordBreak2(input, dict).get(1)).is("cats and dog");
	}
}
