package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import org.junit.Before;

public class ExcelSheetTest {

	private ExcelSheet sut;

	@Before
	public void setup() {
		sut = new ExcelSheet();
	}

	@Test
	public void testExcelSheetColumnTitle6() {
		ASSERT.that(sut.convertToTitle(701)).is("ZY");
		ASSERT.that(sut.titleToNumber("ZY")).is(701);
	}

	@Test
	public void testExcelSheetColumnTitle5() {
		ASSERT.that(sut.convertToTitle(2147483647)).is("FXSHRXW");
		ASSERT.that(sut.titleToNumber("FXSHRXW")).is(2147483647);
	}

	@Test
	public void testExcelSheetColumnTitle4() {
		ASSERT.that(sut.convertToTitle(703)).is("AAA");
		ASSERT.that(sut.titleToNumber("AAA")).is(703);
	}

	@Test
	public void testExcelSheetColumnTitle3() {
		ASSERT.that(sut.convertToTitle(52)).is("AZ");
		ASSERT.that(sut.titleToNumber("AZ")).is(52);
	}

	@Test
	public void testExcelSheetColumnTitle2() {
		ASSERT.that(sut.convertToTitle(27)).is("AA");
		ASSERT.that(sut.titleToNumber("AA")).is(27);
	}

	@Test
	public void testExcelSheetColumnTitle1() {
		ASSERT.that(sut.convertToTitle(1)).is("A");
		ASSERT.that(sut.titleToNumber("A")).is(1);
	}
}
