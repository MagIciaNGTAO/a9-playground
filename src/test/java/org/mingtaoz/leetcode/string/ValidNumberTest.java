package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class ValidNumberTest {

	private ValidNumber sut;

	@Before
	public void setup() {
		sut = new ValidNumber();
	}

	@Test
	public void testReverseWordsInString12() {
		String i = "3.";
		ASSERT.that(sut.isNumber(i)).isTrue();
	}

	@Test
	public void testReverseWordsInString11() {
		String i = "e3.15";
		ASSERT.that(sut.isNumber(i)).isFalse();
	}

	@Test
	public void testReverseWordsInString10() {
		String i = ".15e315";
		ASSERT.that(sut.isNumber(i)).isTrue();
	}

	@Test
	public void testReverseWordsInString9() {
		String i = "2.15e3.15";
		ASSERT.that(sut.isNumber(i)).isFalse();
	}

	@Test
	public void testReverseWordsInString8() {
		String i = "2.15e315";
		ASSERT.that(sut.isNumber(i)).isTrue();
	}

	@Test
	public void testReverseWordsInString7() {
		String i = "00";
		ASSERT.that(sut.isNumber(i)).isFalse();
	}

	@Test
	public void testReverseWordsInString6() {
		String i = "2e10";
		ASSERT.that(sut.isNumber(i)).isTrue();
	}

	@Test
	public void testReverseWordsInString5() {
		String i = "1 a";
		ASSERT.that(sut.isNumber(i)).isFalse();
	}

	@Test
	public void testReverseWordsInString4() {
		String i = "1 a";
		ASSERT.that(sut.isNumber(i)).isFalse();
	}

	@Test
	public void testReverseWordsInString3() {
		String i = "abc";
		ASSERT.that(sut.isNumber(i)).isFalse();
	}

	@Test
	public void testReverseWordsInString2() {
		String i = "0";
		ASSERT.that(sut.isNumber(i)).isTrue();
	}

	@Test
	public void testReverseWordsInString1() {
		String i = " 0.1 ";
		ASSERT.that(sut.isNumber(i)).isTrue();
	}
}
