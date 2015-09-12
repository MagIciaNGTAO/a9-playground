package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.ValidNumber;

public class ValidNumberTest {

	private ValidNumber sut;

	@Before
	public void setup() {
		sut = new ValidNumber();
	}

	private static boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Test
	public void testReverseWordsInString23() {
		String i = " 005047e+6";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}
	
	
	@Test
	public void testReverseWordsInString22() {
		String i = "46e0.3";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString20() {
		String i = "46.e3";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString19() {
		String i = "-.";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString18() {
		String i = "-.";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString17() {
		String i = "+1.";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString16() {
		String i = "-1.";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString15() {
		String i = ".e1";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString14() {
		String i = "0.0";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString13() {
		String i = "1001";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString12() {
		String i = "3.";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString11() {
		String i = "e3.15";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString10() {
		String i = ".15e315";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString9() {
		String i = "2.15e3.15";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString8() {
		String i = "2.15e315";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString7() {
		String i = "00";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString6() {
		String i = "2e10";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString5() {
		String i = "1 a";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString4() {
		String i = "1 a";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString3() {
		String i = "abc";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString2() {
		String i = "0";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}

	@Test
	public void testReverseWordsInString1() {
		String i = " 0.1 ";
		ASSERT.that(sut.isNumber(i)).is(isNumber(i));
	}
}
