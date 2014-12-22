package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class FindPeakElementTest {

    private FindPeakElement sut;

    @Before
    public void setup() {
        sut = new FindPeakElement();
    }

    @Test
    public void testFindPeakElement2() {
        int[] i = { 1, 3, 2, 3, 1 };
        int ret = sut.findPeakElement(i);
        ASSERT.that(ret).isNotEqualTo(0);
        ASSERT.that(ret).isNotEqualTo(2);
        ASSERT.that(ret).isNotEqualTo(3);

    }

    @Test
    public void testFindPeakElement1() {
        int[] i = { 1, 2, 3, 1 };
        ASSERT.that(sut.findPeakElement(i)).is(2);
    }
}
