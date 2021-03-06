package org.mingtaoz.a9.heap;

import static org.truth0.Truth.ASSERT;

import org.junit.Test;

public class HeapTest {

    private Heap sut;

    @Test
    public void testHeapify3() {
        int[] i = new int[] { 20, 5, 10, 12, 15, 8, 2, 6, 2, 9 };
        sut = new Heap(i);
        ASSERT.that(i).is(new int[] { 20, 15, 10, 12, 9, 8, 2, 6, 2, 5 });
    }

    @Test
    public void testHeapify2() {
        int[] i = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        sut = new Heap(i);
        ASSERT.that(i).is(new int[] { 7, 5, 6, 4, 2, 1, 3 });
    }

    @Test
    public void testHeapify1() {
        int[] i = new int[] { 1, 2, 3 };
        sut = new Heap(i);
        ASSERT.that(i).is(new int[] { 3, 2, 1 });
    }

}
