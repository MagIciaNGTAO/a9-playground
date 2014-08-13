package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class SqrtTest {

	private Sqrt sut;

	@Before
	public void setup() {
		sut = new Sqrt();
	}

	@Test
	public void testSqrt0() {
		ASSERT.that(sut.sqrt(9)).is(3);
		ASSERT.that(sut.sqrt(16)).is(4);
	}

	@Test
	public void testSqrt1() {
		ASSERT.that(sut.sqrt(24)).is(4);
	}

	@Test
	public void testSqrt2() {
		ASSERT.that(sut.sqrt(2147395599)).is(46339);
	}

	@Test
	public void testSqrt3() {
		ASSERT.that(sut.sqrt(2)).is(1);
	}

	@Test
	public void testSqrt4() {
		ASSERT.that(sut.sqrt(225255075)).is(15008);
	}

	@Test
	public void testSqrt6() {
		ASSERT.that(sut.sqrt(2147395600)).is(46340);
	}

	@Test
	public void testSqrt5() {
		ASSERT.that(sut.sqrt(6)).is(2);
	}
}
