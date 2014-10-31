package org.mingtaoz.other.heap;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

    private Heap sut;

    @Before
    public void setup() {
        sut = new Heap();
    }

    @Test
    public void testHeapify1() {
        int[] i = new int[] { 1, 2, 3 };
        sut.heapify(i);
        ASSERT.that(i).is(new int[] { 3, 1, 2 });
    }

}
