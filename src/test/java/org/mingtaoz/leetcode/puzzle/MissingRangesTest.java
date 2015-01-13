package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class MissingRangesTest {

    private MissingRanges sut;

    @Before
    public void setup() {
        sut = new MissingRanges();
    }

    @Test
    public void testMissingRanges1() {
        ASSERT.that(sut.findMissingRanges(new int[] { 0, 1, 3, 50, 75 }, 0, 99)).iteratesAs(
                new String[] { "2", "4->49", "51->74", "76->99" });
    }
}
