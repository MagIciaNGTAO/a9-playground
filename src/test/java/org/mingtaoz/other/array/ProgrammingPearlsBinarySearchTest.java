package org.mingtaoz.other.array;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class ProgrammingPearlsBinarySearchTest {

    private ProgrammingPearlsBinarySearch sut;

    @Before
    public void setup() {
        sut = new ProgrammingPearlsBinarySearch();
    }

    @Test
    public void testBinarySearchRecursive5() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 3 };
        ASSERT.that(sut.binarySearchRecursive(i, 3)).isEqualTo(2);
    }

    @Test
    public void testBinarySearchRecursive4() {
        int[] i = new int[] { 3, 3, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchRecursive(i, 3)).isEqualTo(0);
    }

    @Test
    public void testbinarySearchRecursive3() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchRecursive(i, 0)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearchRecursive2() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchRecursive(i, 26)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearchRecursive1() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchRecursive(i, 3)).isEqualTo(2);
    }

    @Test
    public void testBinarySearchDup5() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 3 };
        ASSERT.that(sut.binarySearchDup(i, 3)).isEqualTo(2);
    }

    @Test
    public void testBinarySearchDup4() {
        int[] i = new int[] { 3, 3, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchDup(i, 3)).isEqualTo(0);
    }

    @Test
    public void testBinarySearchDup3() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchDup(i, 0)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearchDup2() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchDup(i, 26)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearchDup1() {
        int[] i = new int[] { 1, 2, 3, 3, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearchDup(i, 3)).isEqualTo(2);
    }

    @Test
    public void testBinarySearch5() {
        int[] i = new int[] { 1, 2, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearch(i, 0)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearch4() {
        int[] i = new int[] { 1, 2, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearch(i, 26)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearch3() {
        int[] i = new int[] { 1, 2, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearch(i, 5)).isEqualTo(-1);
    }

    @Test
    public void testBinarySearch2() {
        int[] i = new int[] { 1, 2, 3, 6, 20, 25 };
        ASSERT.that(sut.binarySearch(i, 6)).isEqualTo(3);
    }

    @Test
    public void testBinarySearch1() {
        int[] i = new int[] { 1, 2, 3 };
        ASSERT.that(sut.binarySearch(i, 3)).isEqualTo(2);
    }
}
