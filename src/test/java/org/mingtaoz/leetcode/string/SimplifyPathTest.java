package org.mingtaoz.leetcode.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class SimplifyPathTest {

    private SimplifyPath sut;

    @Before
    public void setup() {
        sut = new SimplifyPath();
    }

    @Test
    public void testSimplifyPath13() {
        String i = "/home/foo/.ssh/../.ssh2/authorized_keys/";
        String o = "/home/foo/.ssh2/authorized_keys";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath12() {
        String i = "///./wFmgf/R/fHhJ/./.././.././e///SF/.///JaO/../g/MJY/S/..";
        String o = "/wFmgf/e/SF/g/MJY";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath11() {
        String i = "///eHx/..";
        String o = "/";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath10() {
        String i = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        String o = "/e/f/g";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath9() {
        String i = "/home/of/foo/../../bar/../../is/./here/.";
        String o = "/is/here";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath8() {
        String i = "/home/../../..";
        String o = "/";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath7() {
        String i = "/.";
        String o = "/";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath6() {
        String i = "/...";
        String o = "/...";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath5() {
        String i = "/home/a/b/../";
        String o = "/home/a";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath4() {
        String i = "/home/a/b/../";
        String o = "/home/a";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath3() {
        String i = "/home/../";
        String o = "/";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath2() {
        String i = "/home/";
        String o = "/home";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }

    @Test
    public void testSimplifyPath1() {
        String i = "/a/./b/../../c/";
        String o = "/c";
        ASSERT.that(sut.simplifyPath(i)).isEqualTo(o);
    }
}
