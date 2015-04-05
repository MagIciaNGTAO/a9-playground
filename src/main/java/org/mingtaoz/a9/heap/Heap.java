package org.mingtaoz.a9.heap;

/**
 * 
 *     // O(n) building a heap
    // bottom up approach
    // n/2 * 0 + n/4 * 1 + n/8 * 2 + ... n/n * log(n)
    // = n/2 * 1 + n/4 * 2 + n/8 * 3 + ... n/n * log(n)
    // < n * SUM{1, log(n)}(i/(2^i))
    // S = SUM, S/2 = SUM * 1/2
    // S/2 = n/4*1 + n/8*2 +...+ n/n*log(n) - n/8*1 - n/16*2 -...- n/2n*log(n)
    // S/2 = n/4 + n/8 + n/16 + ... + n/(n/2) - log(n)/2
    // S < n/2 + n/4 + n/8 + n/2^log(n) = n * SUM(1/(2^i)) -> O(n)
 * 
 *
 */
public class Heap {

    int[] back;
    int size;

    public Heap(int[] array) {
        this.back = array;
        this.size = array.length;
        int layers = logBase2RoundDownPlug1();
        for (int i = layers - 1; i >= 0; i--) {
            int left = (int) Math.pow(2, i - 1), right = left * 2;
            for (int j = left - 1; j < right - 1; j++) {
                siftDown(j);
            }
        }
    }

    // TODO clean up this process
    public void siftDown(int i) {
        int leftChildIndex = i * 2 + 1, rightChildIndex = i * 2 + 2;
        if (leftChildIndex < back.length && rightChildIndex < back.length) {
            if (back[i] < back[leftChildIndex] && back[i] < back[rightChildIndex]) {
                if (back[leftChildIndex] < back[rightChildIndex]) {
                    swap(rightChildIndex, i);
                    siftDown(rightChildIndex);
                } else {
                    swap(leftChildIndex, i);
                    siftDown(leftChildIndex);
                }
            } else if (back[i] < back[leftChildIndex]) {
                swap(leftChildIndex, i);
                siftDown(leftChildIndex);
            } else if (back[i] < back[rightChildIndex]) {
                swap(rightChildIndex, i);
                siftDown(rightChildIndex);
            }
        } else if (leftChildIndex < back.length) {
            if (back[i] < back[leftChildIndex]) {
                swap(i, leftChildIndex);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = back[i];
        back[i] = back[j];
        back[j] = temp;
    }

    public int logBase2RoundDownPlug1() {
        // TODO casting
        return (int) (long) (Math.log(size) / Math.log(2)) + 1;
    }
}
