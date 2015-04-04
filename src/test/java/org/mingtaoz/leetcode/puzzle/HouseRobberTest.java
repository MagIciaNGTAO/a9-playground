package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class HouseRobberTest {

    private HouseRobber sut;

    @Before
    public void setup() {
        sut = new HouseRobber();
    }

    @Test
    public void testHouseRobber2() {
        ASSERT.that(sut.rob(new int[] { 2, 1, 1, 2 })).is(4);
    }

    @Test
    public void testHouseRobber1() {
        ASSERT.that(sut.rob(new int[] { 1, 3, 5 })).is(6);
    }
}
