package org.mingtaoz.a9.dp;

import org.mingtaoz.a9.dp.RodCutting;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RodCuttingTest extends TestCase {

    private RodCutting sut;

    public RodCuttingTest(String testName) {
        super(testName);
        sut = new RodCutting();
    }

    public static Test suite() {
        return new TestSuite(RodCuttingTest.class);
    }

    public void testRodCutting3() {
        assertEquals(10, sut.bestCut(new int[] { 1, 2, 5, 6, 7, 8 }, 6));
    }

    public void testRodCutting2() {
        assertEquals(19, sut.bestCut(new int[] { 3, 5, 9, 13, 15, 16 }, 6));
    }

    public void testRodCutting1() {
        assertEquals(45, sut.bestCut(new int[] { 3, 5, 9, 13, 15, 16, 45 }, 7));
    }
}
