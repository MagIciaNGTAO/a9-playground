package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.StrStr;

public class StrStrTest {

    private StrStr sut;

    @Before
    public void setup() {
        sut = new StrStr();
    }

    @Test
    public void testStrStr5() {
        ASSERT.that(sut.strStr("a", "a")).is(0);
    }

    @Test
    public void testStrStr4() {
        ASSERT.that(sut.strStr("", "a")).is(-1);
    }

    @Test
    public void testStrStr3() {
        ASSERT.that(sut.strStr("", "")).is(0);
    }

    @Test
    public void testStrStr2() {
        ASSERT.that(sut.strStr("abdabcabc", "abcab")).is(3);
    }

    @Test
    public void testStrStr1() {
        ASSERT.that(sut.strStr("abcabcabc", "ababc")).is(-1);
    }
}
