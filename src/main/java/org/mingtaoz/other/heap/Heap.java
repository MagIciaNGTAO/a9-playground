package org.mingtaoz.other.heap;

public class Heap {

    // O(n) building a heap
    // bottom up approach
    // n/2 * 0 + n/4 * 1 + n/8 * 2 + ... n/n * log(n)
    // = n/2 * 1 + n/4 * 2 + n/8 * 3 + ... n/n * log(n)
    // < n * SUM{1, log(n)}(i/(2^i))
    // S = SUM, S/2 = SUM * 1/2
    // S/2 = n/4*1 + n/8*2 +...+ n/n*log(n) - n/8*1 - n/16*2 -...- n/2n*log(n)
    // S/2 = n/4 + n/8 + n/16 + ... + n/(n/2) - log(n)/2
    // S < n/2 + n/4 + n/8 + n/2^log(n) = n * SUM(1/(2^i)) -> O(n)
    public void heapify(int[] unSortedArray) {
        int n = unSortedArray.length, layers = logBase2RoundDownPlug1(n);
        for (int i = layers - 1; i >= 0; i--) {
            int left = (int) Math.pow(2, i - 1), right = left * 2;
            for (int j = left - 1; j < right - 1; j++) {
                swapDown(unSortedArray, j);
            }
        }
    }

    // TODO clean up this process
    public void swapDown(int[] halfHeap, int i) {
        int leftChildIndex = i * 2 + 1, rightChildIndex = i * 2 + 2;
        if (leftChildIndex < halfHeap.length && rightChildIndex < halfHeap.length) {
            if (halfHeap[i] < halfHeap[leftChildIndex] && halfHeap[i] < halfHeap[rightChildIndex]) {
                if (halfHeap[leftChildIndex] < halfHeap[rightChildIndex]) {
                    swap(halfHeap, rightChildIndex, i);
                    swapDown(halfHeap, rightChildIndex);
                } else {
                    swap(halfHeap, leftChildIndex, i);
                    swapDown(halfHeap, leftChildIndex);
                }
            } else if (halfHeap[i] < halfHeap[leftChildIndex]) {
                swap(halfHeap, leftChildIndex, i);
                swapDown(halfHeap, leftChildIndex);
            } else if (halfHeap[i] < halfHeap[rightChildIndex]) {
                swap(halfHeap, rightChildIndex, i);
                swapDown(halfHeap, rightChildIndex);
            }
        } else if (leftChildIndex < halfHeap.length) {
            if (halfHeap[i] < halfHeap[leftChildIndex]) {
                swap(halfHeap, i, leftChildIndex);
            }
        }
    }

    private void swap(int[] halfHeap, int i, int j) {
        int temp = halfHeap[i];
        halfHeap[i] = halfHeap[j];
        halfHeap[j] = temp;
    }

    public int logBase2RoundDownPlug1(int numberOfElements) {
        return (int) (long) (Math.log(numberOfElements) / Math.log(2)) + 1;
    }
}
