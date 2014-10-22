package org.mingtaoz.leetcode.recursion;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.leetcode.recursion.Sudoku;

public class SudokuTest {

	private Sudoku sut;

	@Before
	public void setup() {
		sut = new Sudoku();
	}

	@Test
	public void testSudoku1() {
		String[] s1 = { "..9748...", "7........", ".2.1.9...", "..7...24.",
				".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.." };
		char[][] input = new char[s1.length][s1.length];
		for (int i = 0; i < s1.length; i++) {
			input[i] = s1[i].toCharArray();
		}
		String[] s2 = { "519748632", "783652419", "426139875", "357986241",
				"264317598", "198524367", "975863124", "832491756", "641275983" };
		char[][] output = new char[s2.length][s2.length];
		for (int i = 0; i < s2.length; i++) {
			output[i] = s2[i].toCharArray();
		}
		sut.solveSudoku(input);
//		for (int i = 0; i < s1.length; i++) {
//			for (int j = 0; j < s1.length; j++) {
//				System.out.print(input[i][j]);
//			}
//			System.out.println();
//		}
		// ASSERT.that(input).is(output);
	}
}
