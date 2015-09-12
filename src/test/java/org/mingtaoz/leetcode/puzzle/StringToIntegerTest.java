package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.a9.string.StringToInteger;

public class StringToIntegerTest {

    private StringToInteger sut;

    @Before
    public void setup() {
        sut = new StringToInteger();
    }

    @Test
    public void testStringToInteger1() {
        ASSERT.that(sut.atoi("+-1")).is(0);
    }

    @Test
    public void testStringToInteger2() {
        ASSERT.that(sut.atoi("-255")).is(-255);
    }

    @Test
    public void testStringToInteger3() {
        ASSERT.that(sut.atoi("255")).is(255);
    }

    @Test
    public void testStringToInteger4() {
        ASSERT.that(sut.atoi("2147483647")).is(Integer.MAX_VALUE);
    }

    @Test
    public void testStringToInteger5() {
        ASSERT.that(sut.atoi("-2147483648")).is(Integer.MIN_VALUE);
    }

    @Test
    public void testStringToInteger6() {
        ASSERT.that(sut.atoi("0")).is(0);
    }

    @Test
    public void testStringToInteger7() {
        ASSERT.that(sut.atoi("    010")).is(10);
    }

    @Test
    public void testStringToInteger8() {
        ASSERT.that(sut.atoi("  -0012a42")).is(-12);
    }

    @Test
    public void testStringToInteger9() {
        ASSERT.that(sut.atoi("2147483648")).is(Integer.MAX_VALUE);
    }

    @Test
    public void testStringToInteger10() {
        ASSERT.that(sut.atoi("-2147483649")).is(Integer.MIN_VALUE);
    }
}
