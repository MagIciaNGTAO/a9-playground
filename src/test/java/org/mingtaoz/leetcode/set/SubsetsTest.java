package org.mingtaoz.leetcode.set;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.truth.Expect;

import static org.truth0.Truth.ASSERT;

public class SubsetsTest {

	private Subsets sut;

	@Before
	public void setup() {
		sut = new Subsets();
	}

	@Test
	public void testSubsetsWithDup1() {
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		l2.add(1);
		List<Integer> l3 = new LinkedList<>();
		l3.add(1);
		l3.add(1);
		List<List<Integer>> assertion = new LinkedList<>();
		assertion.add(l1);
		assertion.add(l2);
		assertion.add(l3);
		ASSERT.that(sut.subsetsWithDup(new int[] { 1, 1 })).containsSequence(
				assertion);
	}
}
