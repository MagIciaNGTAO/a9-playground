package org.mingtaoz.leetcode.puzzle;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator sut;

    @Before
    public void setup() {
        sut = new Calculator();
    }

    @Test
    public void testCalculate24() {
        ASSERT.that(sut.calculate2("3+5 / 2")).is(5);
    }

    @Test
    public void testCalculate23() {
        ASSERT.that(sut.calculate2("1 * 2 / 2")).is(1);
    }

    @Test
    public void testCalculate22() {
        ASSERT.that(sut.calculate2("1 * 2")).is(2);
    }

    @Test
    public void testCalculate21() {
        ASSERT.that(sut.calculate2("1 + 2")).is(3);
    }

    @Test
    public void testCalculate5() {
        ASSERT.that(sut.calculate("(1+(4+5+2)-3)+(6+8)")).is(23);
    }

    @Test
    public void testCalculate4() {
        ASSERT.that(sut.calculate("1 - (2 + 3)")).is(-4);
    }

    @Test
    public void testCalculate3() {
        ASSERT.that(sut.calculate("1 - 2 + 3")).is(2);
    }

    @Test
    public void testCalculate2() {
        ASSERT.that(sut.calculate("1 + 2 + 3")).is(6);
    }

    @Test
    public void testCalculate1() {
        ASSERT.that(sut.calculate("1 + 2")).is(3);
    }
}
