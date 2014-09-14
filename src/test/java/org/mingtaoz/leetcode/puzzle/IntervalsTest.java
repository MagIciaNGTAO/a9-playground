package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

public class IntervalsTest {

	private Intervals sut;

	@Before
	public void setup() {
		sut = new Intervals();
	}

	@Test
	public void testMerge1() {
		List<Interval> i = new LinkedList<>();
		i.add(new Interval(1, 3));
		i.add(new Interval(2, 6));
		i.add(new Interval(8, 10));
		List<Interval> o = new LinkedList<>();
		o.add(new Interval(1, 6));
		o.add(new Interval(8, 10));
		ASSERT.that(sut.merge(i)).iteratesAs(o);
	}
}
