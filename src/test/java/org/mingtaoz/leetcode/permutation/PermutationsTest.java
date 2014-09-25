package org.mingtaoz.leetcode.permutation;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class PermutationsTest {

	private Permutations sut;

	@Before
	public void setup() {
		sut = new Permutations();
	}

	@Test
	public void testPermutation6() {
		int[] i = new int[] { 2, 3, 1, 3, 3 }; // 3 5 4
		int[] o = new int[] { 2, 3, 3, 1, 3 };
		sut.nextPermutation(i);
		ASSERT.that(i).isEqualTo(o);
	}
	
	@Test
	public void testPermutation5() {
		int[] i = new int[] { 1, 5, 1 }; // 3 5 4
		int[] o = new int[] { 5, 1, 1 };
		sut.nextPermutation(i);
		ASSERT.that(i).isEqualTo(o);
	}
	
	@Test
	public void testPermutation4() {
		int[] i = new int[] { 1, 2, 5, 7, 6, 4, 3 }; // 3 5 4
		int[] o = new int[] { 1, 2, 6, 3, 4, 5, 7 };
		sut.nextPermutation(i);
		ASSERT.that(i).isEqualTo(o);
	}

	@Test
	public void testPermutation3() {
		int[] i = new int[] { 3, 4, 2, 1 }; // 3 5 4
		int[] o = new int[] { 4, 1, 2, 3 };
		sut.nextPermutation(i);
		ASSERT.that(i).isEqualTo(o);
	}

	@Test
	public void testPermutation2() {
		int[] i = new int[] { 3, 2, 1 };
		int[] o = new int[] { 1, 2, 3 };
		sut.nextPermutation(i);
		ASSERT.that(i).isEqualTo(o);
	}

	@Test
	public void testPermutation1() {
		int[] i = new int[] { 1, 2, 3, 4 };
		int[] o = new int[] { 1, 2, 4, 3 };
		sut.nextPermutation(i);
		ASSERT.that(i).isEqualTo(o);
	}

}