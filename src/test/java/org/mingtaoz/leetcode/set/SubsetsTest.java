package org.mingtaoz.leetcode.set;

import org.junit.Before;
import org.junit.Test;

public class SubsetsTest {

	private Subsets sut;

	@Before
	public void setup() {
		sut = new Subsets();
	}

	@Test
	public void testSubsets1() {
		System.out.println(sut.subsetsWithDup(new int[] { 1, 1 }));
	}
}
