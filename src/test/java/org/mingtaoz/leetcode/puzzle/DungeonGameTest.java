package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class DungeonGameTest {

    private DungeonGame sut;

    @Before
    public void setup() {
        sut = new DungeonGame();
    }

    @Test
    public void testDungeonGame8() {
        int[][] i = { { 0, 2 }, { -7, 0 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(1);
    }

    @Test
    public void testDungeonGame7() {
        int[][] i = { { 3, -20, 30 }, { -3, 4, 0 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(1);
    }

    @Test
    public void testDungeonGame6() {
        int[][] i = { { -3 }, { -7 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(11);
    }

    @Test
    public void testDungeonGame5() {
        int[][] i = { { -3, -7 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(11);
    }

    @Test
    public void testDungeonGame4() {
        int[][] i = { { 0, -3 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(4);
    }

    @Test
    public void testDungeonGame3() {
        int[][] i = { { 100 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(1);
    }

    @Test
    public void testDungeonGame2() {
        int[][] i = { { -3, 5 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(4);
    }

    @Test
    public void testDungeonGame1() {
        int[][] i = { { 0 } };
        ASSERT.that(sut.calculateMinimumHP(i)).is(1);
    }
}
