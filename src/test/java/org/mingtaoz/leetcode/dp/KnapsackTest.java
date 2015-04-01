package org.mingtaoz.leetcode.dp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class KnapsackTest extends TestCase {

    private Knapsack sut;

    public KnapsackTest(String testName) {
        super(testName);
        sut = new Knapsack();
    }

    public static Test suite() {
        return new TestSuite(KnapsackTest.class);
    }

    public void testKnapsack2() {
        assertEquals(49, sut.maxSteal(29, new int[] { 3, 6, 8, 20 }, new int[] { 5, 9, 12, 35 }));
    }

    public void testKnapsack1() {
        assertEquals(47, sut.maxSteal(28, new int[] { 3, 6, 8, 20 }, new int[] { 5, 9, 12, 35 }));
    }
}
