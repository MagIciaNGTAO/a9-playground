package org.mingtaoz.leetcode.string;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class InterlevingStringTest extends TestCase {

    private InterleavingString sut;

    public InterlevingStringTest(String testName) {
        super(testName);
        sut = new InterleavingString();
    }

    public static Test suite() {
        return new TestSuite(InterlevingStringTest.class);
    }

    public void testIsInterleave1() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        assertTrue(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave2() {
        String s1 = "a";
        String s2 = "ab";
        String s3 = "aba";
        assertTrue(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave3() {
        String s1 = "ab";
        String s2 = "ab";
        String s3 = "abab";
        assertTrue(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave4() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        assertFalse(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave5() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        assertTrue(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave6() {
        String s1 = "ab";
        String s2 = "";
        String s3 = "ab";
        assertTrue(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave7() {
        String s1 = "";
        String s2 = "";
        String s3 = "aa";
        assertFalse(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave8() {
        String s1 = "a";
        String s2 = "";
        String s3 = "";
        assertFalse(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave9() {
        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        assertFalse(sut.isInterleave(s1, s2, s3));
    }

    public void testIsInterleave10() {
        assertFalse(sut.isInterleave("aa", "ab", "aaba"));
    }

}
