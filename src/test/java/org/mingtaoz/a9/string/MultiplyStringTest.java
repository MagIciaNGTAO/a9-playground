package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.MultiplyString;

public class MultiplyStringTest {

    private MultiplyString sut;

    @Before
    public void setup() {
        sut = new MultiplyString();
    }

    @Test
    public void testMultiplyString5() {
        String i1 = "123", i2 = "456";
        String o = "56088";
        ASSERT.that(sut.multiply(i1, i2)).isEqualTo(o);
    }

    @Test
    public void testMultiplyString4() {
        String i1 = "9", i2 = "9";
        String o = "81";
        ASSERT.that(sut.multiply(i1, i2)).isEqualTo(o);
    }

    @Test
    public void testMultiplyString3() {
        String i1 = "112", i2 = "-334";
        String o = "-37408";
        ASSERT.that(sut.multiply(i1, i2)).isEqualTo(o);
    }

    @Test
    public void testMultiplyString2() {
        String i1 = "-112", i2 = "-334";
        String o = "37408";
        ASSERT.that(sut.multiply(i1, i2)).isEqualTo(o);
    }

    @Test
    public void testMultiplyString1() {
        String i1 = "112", i2 = "334";
        String o = "37408";
        ASSERT.that(sut.multiply(i1, i2)).isEqualTo(o);
    }
}
