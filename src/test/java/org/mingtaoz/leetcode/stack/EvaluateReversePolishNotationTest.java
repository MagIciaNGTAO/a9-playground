package org.mingtaoz.leetcode.stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class EvaluateReversePolishNotationTest extends TestCase {

	private EvaluateReversePolishNotation sut;

	public EvaluateReversePolishNotationTest(String testName) {
		super(testName);
		sut = new EvaluateReversePolishNotation();
	}

	public static Test suite() {
		return new TestSuite(EvaluateReversePolishNotationTest.class);
	}

	public void testevalRPN1() {
		String[] input = { "2", "1", "+", "3", "*" };
		int expected = 9;
		assertEquals(expected, sut.evalRPN(input));
	}

	public void testevalRPN2() {
		String[] input = { "4", "13", "5", "/", "+" };
		int expected = 6;
		assertEquals(expected, sut.evalRPN(input));
	}
}
