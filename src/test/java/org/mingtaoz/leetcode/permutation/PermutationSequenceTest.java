package org.mingtaoz.leetcode.permutation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PermutationSequenceTest {

	private PermutationSequence sut;

	@Before
	public void setup() {
		sut = new PermutationSequence();
	}

	@Test
	public void testGetK10() {
		assertEquals("1234", sut.getPermutation(4, 1));
	}
	
	@Test
	public void testGetK9() {
		assertEquals("2431", sut.getPermutation(4, 12));
	}
	
	@Test
	public void testGetK8() {
		assertEquals("3124", sut.getPermutation(4, 13));
	}
	
	@Test
	public void testGetK7() {
		assertEquals("123", sut.getPermutation(3, 1));
	}

	@Test
	public void testGetK6() {
		assertEquals("132", sut.getPermutation(3, 2));
	}

	@Test
	public void testGetK5() {
		assertEquals("213", sut.getPermutation(3, 3));
	}

	@Test
	public void testGetK4() {
		assertEquals("231", sut.getPermutation(3, 4));
	}

	@Test
	public void testGetK3() {
		assertEquals("312", sut.getPermutation(3, 5));
	}

	@Test
	public void testGetK2() {
		assertEquals("321", sut.getPermutation(3, 6));
	}

	@Test
	public void testGetK1() {
		assertEquals("132", sut.getPermutation(3, 2));
	}
}