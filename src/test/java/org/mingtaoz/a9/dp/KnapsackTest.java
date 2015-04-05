package org.mingtaoz.a9.dp;

import org.mingtaoz.a9.dp.Knapsack;

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

    public void testKnapsack4() {
        assertEquals(4, sut.maxStealUB(6, new int[] { 3 }, new int[] { 2 }));
    }

    public void testKnapsack3() {
        assertEquals(2, sut.maxSteal01(6, new int[] { 3 }, new int[] { 2 }));
    }

    public void testKnapsack2() {
        assertEquals(49, sut.maxSteal01(29, new int[] { 3, 6, 8, 20 }, new int[] { 5, 9, 12, 35 }));
    }

    public void testKnapsack1() {
        assertEquals(47, sut.maxSteal01(28, new int[] { 3, 6, 8, 20 }, new int[] { 5, 9, 12, 35 }));
    }
}
