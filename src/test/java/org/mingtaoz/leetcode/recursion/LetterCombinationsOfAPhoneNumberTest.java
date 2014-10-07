package org.mingtaoz.leetcode.recursion;

import static org.truth0.Truth.ASSERT;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.leetcode.recursion.LetterCombinationsOfAPhoneNumber;

public class LetterCombinationsOfAPhoneNumberTest {

	private LetterCombinationsOfAPhoneNumber sut;

	@Before
	public void setup() {
		sut = new LetterCombinationsOfAPhoneNumber();
	}

	@Test
	public void testLetterCombinationsOfAPhoneNumber8() {
		ASSERT.that(sut.letterCombinations("23").size()).is(
				Arrays.asList(
						new String[] { "ad", "ae", "af", "bd", "be", "bf",
								"cd", "ce", "cf" }).size());
	}

}