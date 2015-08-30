package org.mingtaoz.a9.heap;

/**
 * 
 *   O(n) building a heap
     bottom up approach right to left
     n/2 * 0 + n/4 * 1 + n/8 * 2 + ... n/n * log(n)
     = n/2 * 1 + n/4 * 2 + n/8 * 3 + ... n/n * log(n)
     < n * SUM{1, log(n)}(i/(2^i))
     S = SUM, S/2 = SUM * 1/2
     S/2 = n/4*1 + n/8*2 +...+ n/n*log(n) - n/8*1 - n/16*2 -...- n/2n*log(n)
     S/2 = n/4 + n/8 + n/16 + ... + n/(n/2) - log(n)/2
     S < n/2 + n/4 + n/8 + n/2^log(n) = n * SUM(1/(2^i)) -> O(n)
 *
 */
public class Heap {

    int[] array;
    int size;

    public Heap(int[] array) {
        this.array = array;
        this.size = array.length;
        for (int i = size; i > 0; i /= 2) {
            int left = i / 2, right = i;
            for (int j = left; j < right; j++) {
                siftDown(j);
            }
        }
    }

    public void siftDown(int i) {
        int leftChildIndex, rightChildIndex;
        while ((i + 1) * 2 < size) {
            leftChildIndex = i * 2 + 1;
            rightChildIndex = i * 2 + 2;
            if (array[leftChildIndex] < array[rightChildIndex]) {
                if (array[i] < array[rightChildIndex]) {
                    swap(rightChildIndex, i);
                    i = rightChildIndex;
                } else {
                    break;
                }
            } else {
                if (array[i] < array[leftChildIndex]) {
                    swap(leftChildIndex, i);
                    i = leftChildIndex;
                } else {
                    break;
                }
            }
        }
        leftChildIndex = i * 2 + 1;
        if (leftChildIndex < size && array[i] < array[leftChildIndex]) {
            swap(i, leftChildIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
