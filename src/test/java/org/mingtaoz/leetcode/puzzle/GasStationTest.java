package org.mingtaoz.leetcode.puzzle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GasStationTest extends TestCase {

	private GasStation sut;

	public GasStationTest(String testName) {
		super(testName);
		sut = new GasStation();
	}

	public static Test suite() {
		return new TestSuite(GasStationTest.class);
	}

	public void testGasStation1() {
		int[] gas = { 1, 2, 3 };
		int[] cost = { 1, 2, 3 };
		assertEquals(0, sut.canCompleteCircuit(gas, cost));
	}
	
	public void testGasStation2() {
		int[] gas = { 1, 2, 3 };
		int[] cost = { 1, 2, 4 };
		assertEquals(-1, sut.canCompleteCircuit(gas, cost));
	}
	
	public void testGasStation3() {
		int[] gas = { 1, 4, 3 };
		int[] cost = { 2, 2, 4 };
		assertEquals(1, sut.canCompleteCircuit(gas, cost));
	}
	
	public void testGasStation4() {
		int[] gas = { 1, 4, 3 };
		int[] cost = { 2, 3, 4 };
		assertEquals(-1, sut.canCompleteCircuit(gas, cost));
	}
	
	public void testGasStation5() {
		int[] gas = { 1, 1, 1 };
		int[] cost = { 1, 2, 3 };
		assertEquals(-1, sut.canCompleteCircuit(gas, cost));
	}
}
