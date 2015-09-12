package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.ShortestPalindrome;

public class ShortestPalindromeTest {

    private ShortestPalindrome sut;

    @Before
    public void setup() {
        sut = new ShortestPalindrome();
    }

    @Test
    public void test4() {
        ASSERT.that(sut.shortestPalindrome("abbacd")).is("dcabbacd");
    }

    @Test
    public void test3() {
        ASSERT.that(sut.shortestPalindrome("")).is("");
    }

    @Test
    public void test2() {
        ASSERT.that(sut.shortestPalindrome("aba")).is("aba");
    }

    @Test
    public void test1() {
        ASSERT.that(sut.shortestPalindrome("ba")).is("aba");
    }
}
