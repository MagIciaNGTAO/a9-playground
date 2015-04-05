package org.mingtaoz.leetcode.recursion;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class UniquePathsTest {

    private UniquePaths sut;

    @Before
    public void setup() {
        sut = new UniquePaths();
    }

    @Test
    public void testUniquePaths7() {
        ASSERT.that(sut.uniquePathsWithObstacles(new int[][] { { 1 }, { 0 } })).is(0);
    }

    @Test
    public void testUniquePaths6() {
        ASSERT.that(sut.uniquePathsWithObstacles(new int[][] { { 0, 1 } })).is(0);
    }

    @Test
    public void testUniquePaths5() {
        ASSERT.that(sut.uniquePathsWithObstacles(new int[][] { { 0 } })).is(1);
    }

    @Test
    public void testUniquePaths4() {
        ASSERT.that(sut.uniquePathsWithObstacles(new int[][] { { 1 } })).is(0);
    }

    @Test
    public void testUniquePaths3() {
        ASSERT.that(sut.uniquePaths(2, 3)).is(3);
    }

    @Test
    public void testUniquePaths2() {
        ASSERT.that(sut.uniquePaths(2, 2)).is(2);
    }

    @Test
    public void testUniquePaths1() {
        ASSERT.that(sut.uniquePaths(1, 1)).is(1);
    }
}