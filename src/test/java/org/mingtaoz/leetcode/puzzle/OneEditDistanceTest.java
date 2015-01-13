package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class OneEditDistanceTest {

    private OneEditDistance sut;

    @Before
    public void setup() {
        sut = new OneEditDistance();
    }

    @Test
    public void testOneEditDistance1() {
        ASSERT.that(sut.isOneEditDistance("a", "A")).isTrue();
    }
}
