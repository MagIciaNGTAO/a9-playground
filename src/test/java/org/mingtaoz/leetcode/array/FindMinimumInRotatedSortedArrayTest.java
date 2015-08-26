package org.mingtaoz.leetcode.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.array.FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArrayTest {

    private FindMinimumInRotatedSortedArray sut;

    @Before
    public void setup() {
        sut = new FindMinimumInRotatedSortedArray();
    }

    @Test
    public void testFindMin4() {
        int[] i = { 5, 6, 7, 1, 1, 2, 3 };
        ASSERT.that(sut.findMin(i)).is(1);
    }

    @Test
    public void testFindMin3() {
        int[] i = { 5, 6, 7, 1, 2, 3 };
        ASSERT.that(sut.findMin(i)).is(1);
    }

    @Test
    public void testFindMin2() {
        int[] i = { 0, 1, 2, 4, 5, 6, 7 };
        ASSERT.that(sut.findMin(i)).is(0);
    }

    @Test
    public void testFindMin1() {
        int[] i = { 4, 5, 6, 7, 0, 1, 2 };
        ASSERT.that(sut.findMin(i)).is(0);
    }

    @Test
    public void testFindMinDuplicate() {
        int[] i = { 3, 3, 4, 5, 6, 7 };
        ASSERT.that(sut.findMin2(i)).is(3);
    }
}
