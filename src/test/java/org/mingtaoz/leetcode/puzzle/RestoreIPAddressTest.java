package org.mingtaoz.leetcode.puzzle;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RestoreIPAddressTest extends TestCase {

	private RestoreIPAddress sut;

	public RestoreIPAddressTest(String testName) {
		super(testName);
		sut = new RestoreIPAddress();
	}

	public static Test suite() {
		return new TestSuite(RestoreIPAddressTest.class);
	}

	public void testRestoreIpAddresses() {
		assertEquals(Arrays.asList("255.255.11.135", "255.255.111.35"),
				sut.restoreIpAddresses("25525511135"));
	}

	
	public void testLegal1() {
		assertFalse(sut.legal("525"));
	}
}
