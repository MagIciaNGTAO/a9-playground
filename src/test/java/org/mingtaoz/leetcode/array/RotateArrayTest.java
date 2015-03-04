package org.mingtaoz.leetcode.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class RotateArrayTest {

    private RotateArray sut;

    @Before
    public void setup() {
        sut = new RotateArray();
    }

    @Test
    public void testRotateArray8() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
        sut.rotate2(A, 38);
        ASSERT.that(A).is(
                new int[] { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                        15, 16 });
    }

    @Test
    public void testRotateArray7() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        sut.rotate2(A, 7);
        ASSERT.that(A).is(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    }

    @Test
    public void testRotateArray6() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        sut.rotate2(A, 6);
        ASSERT.that(A).is(new int[] { 2, 3, 4, 5, 6, 7, 1 });
    }

    @Test
    public void testRotateArray5() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        sut.rotate2(A, 5);
        ASSERT.that(A).is(new int[] { 3, 4, 5, 6, 7, 1, 2 });
    }

    @Test
    public void testRotateArray4() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        sut.rotate2(A, 4);
        ASSERT.that(A).is(new int[] { 4, 5, 6, 7, 1, 2, 3 });
    }

    @Test
    public void testRotateArray3() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        sut.rotate2(A, 3);
        ASSERT.that(A).is(new int[] { 5, 6, 7, 1, 2, 3, 4 });
    }

    @Test
    public void testRotateArray2() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        sut.rotate2(A, 2);
        ASSERT.that(A).is(new int[] { 6, 7, 1, 2, 3, 4, 5 });
    }

    @Test
    public void testRotateArray1() {
        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        sut.rotate2(A, 1);
        ASSERT.that(A).is(new int[] { 7, 1, 2, 3, 4, 5, 6 });
    }
}
