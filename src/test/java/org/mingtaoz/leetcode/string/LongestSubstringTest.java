package org.mingtaoz.leetcode.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LongestSubstringTest extends TestCase {

    private LongestSubstring sut;

    public LongestSubstringTest(String testName) {
        super(testName);
        sut = new LongestSubstring();
    }

    public static Test suite() {
        return new TestSuite(LongestSubstringTest.class);
    }

    public void testNumDistinct7() {
        String S = "ccaabbb";
        assertEquals(5, sut.lengthOfLongestSubstringTwoDistinct(S));
    }

    public void testNumDistinct6() {
        String S = "abaccc";
        assertEquals(4, sut.lengthOfLongestSubstringTwoDistinct(S));
    }

    public void testNumDistinct5() {
        String S = "aaabc";
        assertEquals(4, sut.lengthOfLongestSubstringTwoDistinct(S));
    }

    public void testNumDistinct4() {
        String S = "aba";
        assertEquals(3, sut.lengthOfLongestSubstringTwoDistinct(S));
    }

    public void testNumDistinct3() {
        String S = "bbb";
        assertEquals(3, sut.lengthOfLongestSubstringTwoDistinct(S));
    }

    public void testNumDistinct2() {
        String S = "abbb";
        assertEquals(4, sut.lengthOfLongestSubstringTwoDistinct(S));
    }

    public void testNumDistinct1() {
        String S = "rabbbit";
        assertEquals(4, sut.lengthOfLongestSubstringTwoDistinct(S));
    }
}
