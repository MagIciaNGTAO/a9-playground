package org.mingtaoz.a9.array;

public class ProductExcludeSelf {

    /**
     * 
     * get the product except the element itself
     * 
     * [1, 2, 3, 4] -> [24, 12, 8, 6]
     * 
     * @param array
     * @return
     */
    public static int[] productExcludeSelfNoDivision(int[] array) {
        int n = array.length;
        int[] left = new int[n], right = new int[n], ret = new int[n];
        // build
        left[0] = array[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * array[i];
        }
        right[n - 1] = array[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * array[i];
        }
        // ret
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ret[i] = right[1];
            } else if (i == n - 1) {
                ret[i] = left[n - 1];
            } else {
                ret[i] = left[i - 1] * right[i + 1];
            }
        }
        return ret;
    }
}
