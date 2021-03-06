package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;
import org.junit.Before;
import org.mingtaoz.a9.string.MinimumWindowSubstring;

public class MinimumWindowSubstringTest {

    private MinimumWindowSubstring sut;

    @Before
    public void setup() {
        sut = new MinimumWindowSubstring();
    }

    @Test
    public void testMinWindow3() {
        ASSERT.that(sut.minWindow("a", "aa")).is("");
    }

    @Test
    public void testMinWindow2() {
        ASSERT.that(sut.minWindow("ADOBECODEBANC", "ABC")).is("BANC");
    }

    @Test
    public void testMinWindow1() {
        ASSERT.that(sut.minWindow("a", "a")).is("a");
    }
}
