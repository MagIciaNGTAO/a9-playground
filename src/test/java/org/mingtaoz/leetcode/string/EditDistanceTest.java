package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class EditDistanceTest {

	private EditDistance sut;

	@Before
	public void setup() {
		sut = new EditDistance();
	}

	@Test
	public void testMinDistance1() {
		ASSERT.that(sut.minDistance("abc", "abd")).is(1);
	}
	
	@Test
	public void testMinDistance2() {
		ASSERT.that(sut.minDistance("a", "abd")).is(2);
	}
	
	@Test
	public void testMinDistance3() {
		ASSERT.that(sut.minDistance("abd", "a")).is(2);
	}
	
	@Test
	public void testMinDistance4() {
		ASSERT.that(sut.minDistance("dfz", "qfa")).is(2);
	}
	
	@Test
	public void testMinDistance5() {
		ASSERT.that(sut.minDistance("fff", "fff")).is(0);
	}
	
	@Test
	public void testMinDistance6() {
		ASSERT.that(sut.minDistance("", "a")).is(1);
	}
	
	@Test
	public void testMinDistance7() {
		ASSERT.that(sut.minDistance("plasma", "altruism")).is(6);
	}
}
