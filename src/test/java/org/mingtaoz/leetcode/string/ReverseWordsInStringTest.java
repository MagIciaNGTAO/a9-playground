package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class ReverseWordsInStringTest {

    private ReverseWordsInString sut;

    @Before
    public void setup() {
        sut = new ReverseWordsInString();
    }

    @Test
    public void testReverseWordsInString1() {
        String input = "the sky is blue"; // eulb si yks eht
        String expected = "blue is sky the";
        ASSERT.that(sut.reverseWordsInString(input)).is(expected);
        char[] inout = input.toCharArray();
        sut.reverseWordsInPlace(inout);
        ASSERT.that(inout).is(expected.toCharArray());
    }

    @Test
    public void testReverseWordsInString2() {
        String input = "the sky is";
        String expected = "is sky the";
        ASSERT.that(sut.reverseWordsInString(input)).is(expected);
        char[] inout = input.toCharArray();
        sut.reverseWordsInPlace(inout);
        ASSERT.that(inout).is(expected.toCharArray());
    }

    @Test
    public void testReverseWordsInString3() {
        String input = "the";
        String expected = "the";
        ASSERT.that(sut.reverseWordsInString(input)).is(expected);
        char[] inout = input.toCharArray();
        sut.reverseWordsInPlace(inout);
        ASSERT.that(inout).is(expected.toCharArray());
    }
}
