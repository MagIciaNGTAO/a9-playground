package org.mingtaoz.leetcode.puzzle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BestTimeBuySellStockTest extends TestCase {

	private BestTimeBuySellStock sut;

	public BestTimeBuySellStockTest(String testName) {
		super(testName);
		sut = new BestTimeBuySellStock();
	}

	public static Test suite() {
		return new TestSuite(BestTimeBuySellStockTest.class);
	}

	public void testBestTimeBuySellStock1() {
		assertEquals(2, sut.maxProfit1(new int[] { 1, 2, 3 }));
	}

	public void testBestTimeBuySellStock2() {
		assertEquals(0, sut.maxProfit1(new int[] { 3, 2, 1 }));
	}

	public void testBestTimeBuySellStock3() {
		assertEquals(2, sut.maxProfit1(new int[] { 1, 3, 2 }));
	}

	public void testBestTimeBuySellStock4() {
		assertEquals(2, sut.maxProfit1(new int[] { 2, 1, 3 }));
	}

	public void testBestTimeBuySellStock5() {
		assertEquals(1, sut.maxProfit1(new int[] { 3, 1, 2 }));
	}

	public void testBestTimeBuySellStock6() {
		assertEquals(1, sut.maxProfit2(new int[] { 3, 1, 2 }));
	}

	public void testBestTimeBuySellStock7() {
		assertEquals(2, sut.maxProfit2(new int[] { 1, 2, 3 }));
	}

	public void testBestTimeBuySellStoc8() {
		assertEquals(2, sut.maxProfit3(new int[] { 1, 2, 3 }));
	}
}
