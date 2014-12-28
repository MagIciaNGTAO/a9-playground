package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class MaximumGapTest {

    private MaximumGap sut;

    @Before
    public void setup() {
        sut = new MaximumGap();
    }

    @Test
    public void testMaximumGap3() {
        int[] i = { 100, 3, 2, 1 };
        ASSERT.that(sut.maximumGap(i)).is(97);
    }

    @Test
    public void testMaximumGap2() {
        int[] i = { 3, 6, 9, 1 };
        ASSERT.that(sut.maximumGap(i)).is(3);
    }

    @Test
    public void testMaximumGap1() {
        int[] i = { 1, 2, 3, 4 };
        ASSERT.that(sut.maximumGap(i)).is(1);
    }
}
