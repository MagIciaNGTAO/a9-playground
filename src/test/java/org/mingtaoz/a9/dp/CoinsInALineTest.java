package org.mingtaoz.a9.dp;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class CoinsInALineTest {

    private CoinsInALine sut;

    @Before
    public void setup() {
        sut = new CoinsInALine();
    }

    @Test
    public void testCoinsInALine5() {
        ASSERT.that(sut.bestPick(new int[] { 3, 2, 1, 3, 4 })).is(8);
    }

    @Test
    public void testCoinsInALine4() {
        ASSERT.that(sut.bestPick(new int[] { 1, 2, 1 })).is(2);
    }

    @Test
    public void testCoinsInALine3() {
        ASSERT.that(sut.bestPick(new int[] { 3, 2, 2, 3, 1, 2 })).is(8);
    }

    @Test
    public void testCoinsInALine2() {
        ASSERT.that(sut.bestPick(new int[] { 1, 2, 3, 4, 5, 6 })).is(12);
    }

    @Test
    public void testCoinsInALine1() {
        ASSERT.that(sut.bestPick(new int[] { 1, 4, 2, 3 })).is(7);
    }
}
