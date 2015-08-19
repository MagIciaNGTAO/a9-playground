package org.mingtaoz.leetcode.geometry;

import org.junit.Before;
import org.junit.Test;

public class TheSkylineProblemTest {

    private TheSkylineProblem sut;

    @Before
    public void setup() {
        sut = new TheSkylineProblem();
    }

    @Test
    public void testMaxPoints1() {
        int[][] i = new int[][] { { 0, 2, 3 }, { 2, 5, 3 } };
        int[][] o = new int[][] { { 0, 3 }, { 5, 0 } };
        sut.getSkyline(i);
    }

    @Test
    public void testMaxPoints2() {
        int[][] i = new int[][] { { 1, 2, 1 }, { 1, 2, 2 }, { 1, 2, 3 } };
        int[][] o = new int[][] { { 1, 3 }, { 2, 0 } };
        sut.getSkyline(i);
    }

    @Test
    public void testMaxPoints3() {
        int[][] i = new int[][] { { 0, 1, 3 } };
        int[][] o = new int[][] { { 0, 3 }, { 1, 0 } };
        sut.getSkyline(i);
    }

    @Test
    public void testMaxPoints4() {
        int[][] i = new int[][] { { 1, 2, 1 }, { 2147483646, 2147483647, 2147483647 } };
        int[][] o = new int[][] { { 0, 3 }, { 1, 0 } };
        sut.getSkyline(i);
    }

    @Test
    public void testMaxPoints5() {
        int[][] i = new int[][] { { 2, 13, 10 }, { 10, 17, 25 }, { 12, 20, 14 } };
        int[][] o = new int[][] { { 0, 3 }, { 1, 0 } };
        sut.getSkyline(i);
    }

}
