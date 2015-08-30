package org.mingtaoz.leetcode.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class SortColorsTest {

    private SortColors sut;

    @Before
    public void setup() {
        sut = new SortColors();
    }

    @Test
    public void testSortColors1() {
        int[] A = { 1, 0 };
        sut.sortColors(A);
        ASSERT.that(A).is(new int[] { 0, 1 });
    }
}
