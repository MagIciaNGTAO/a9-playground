package org.mingtaoz.leetcode.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.leetcode.array.FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArrayTest {

    private FindMinimumInRotatedSortedArray sut;

    @Before
    public void setup() {
        sut = new FindMinimumInRotatedSortedArray();
    }

    @Test
    public void testFindMin2() {
        // TODO the index is lean to right or accurate, if lean happens cut
        // include right
        int[] i = { 0, 1, 2, 4, 5, 6, 7 };
        ASSERT.that(sut.findMin(i)).is(0);
    }

    @Test
    public void testFindMin1() {
        // TODO the index is lean to right or accurate, if lean happens cut
        // include right
        int[] i = { 4, 5, 6, 7, 0, 1, 2 };
        ASSERT.that(sut.findMin(i)).is(0);
    }

    @Test
    public void testFindMinDuplicate() {
        // TODO the index is lean to right or accurate, if lean happens cut
        // include right
        int[] i = { 3, 3, 4, 5, 6, 7 };
        ASSERT.that(sut.findMin2(i)).is(3);
    }
}
