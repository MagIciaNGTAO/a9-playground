package org.mingtaoz.leetcode.array;

public class Arrays {

    public int search(int A[], int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[left] < A[mid]) {
                if (target >= A[left] && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (A[left] > A[mid]) {
                if (target > A[mid] && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // skip duplicate one, A[left] == A[mid]
                left++;
            }
        }
        return -1;
    }

    /**
     * Search in Rotated Sorted Array
     * 
     * Suppose a sorted array is rotated at some pivot unknown to you
     * beforehand.
     * 
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * 
     * You are given a target value to search. If found in the array return its
     * index, otherwise return -1.
     * 
     * You may assume no duplicate exists in the array.
     * 
     * @param A
     * @param target
     * @return
     */
    public int searchMine(int[] A, int target) {
        int minIndex = findMinIndex(A);
        int left = minIndex, right = (left == 0 ? A.length : left) - 1;
        return searchHelper(A, target, left, right);
    }

    /**
     * Search in Rotated Sorted Array II
     * 
     * @param A
     * @param target
     * @return
     */
    public boolean search2(int[] A, int target) {
        return searchMine(A, target) != -1;
    }

    // A is sorted bu rotated once
    public int findMinIndex(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right && A[left] == A[left + 1]) {
            left++;
        }
        while (left < right && A[right] == A[right - 1]) {
            right--;
        }
        while (left != right) {
            int mid = (left + right) / 2;
            if (A[mid] < A[right]) {
                right = mid;
            } else if (A[mid] > A[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // binary search, known the messed up spot
    public int searchHelper(int[] A, int target, int left, int right) {
        // one cost to get it right
        if (left > right) {
            int mid = A.length - 1;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = 0;
            } else {
                right = mid;
            }
        }
        while (left <= right) {
            int mid = (left + right + 1) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void merge(int[] A, int m, int[] B, int n) {
        // move A to offset B.length
        moveAToRight(A, m, n);
        // merge
        int a = n, b = 0, merged = 0;
        while (merged < m + n && a < m + n && b < n) {
            if (A[a] < B[b]) {
                A[merged++] = A[a++];
            } else if (A[a] > B[b]) {
                A[merged++] = B[b++];
            } else {
                A[merged++] = B[b++];
            }
        }
        // copy the rest
        while (a < m + n) {
            A[merged++] = A[a++];
        }
        while (b < n) {
            A[merged++] = B[b++];
        }
    }

    public void moveAToRight(int[] A, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            A[i + n] = A[i];
        }
    }

    public int[] plusOne(int[] digits) {
        int carry = 1, i = digits.length - 1;
        while (carry > 0 && i >= 0) {
            int temp = digits[i] + carry;
            if (temp >= 10) {
                digits[i--] = temp - 10;
                carry = 1;
            } else {
                digits[i--] = temp;
                carry = 0;
            }
        }
        if (carry > 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            for (i = 1; i < digits.length + 1; i++) {
                ret[i] = digits[i - 1];
            }
            return ret;
        }
        return digits;
    }

    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        int left = 0, right = A.length - 1, mid;
        while (left <= right) {
            mid = (left + right + 1) / 2;
            if (A[mid] > target) {
                right = mid - 1;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                // find larget index -> right
                int rLeft = mid;
                while (A[right] != A[mid]) {
                    int rMid = (right + rLeft + 1) / 2;
                    if (A[rMid] > A[mid]) {
                        right = rMid - 1;
                    } else {
                        rLeft = rMid;
                    }
                }
                // find smallest index <- left
                int lRight = mid;
                while (A[left] != A[mid]) {
                    int lMid = (left + lRight) / 2;
                    if (A[lMid] < A[mid]) {
                        left = lMid + 1;
                    } else {
                        lRight = lMid;
                    }
                }
                break;
            }
        }
        if (A[left] == A[right] && A[left] == target) {
            ret[0] = left;
            ret[1] = right;
        }
        return ret;
    }

    public int searchInsert(int[] A, int target) {
        int left = 0, right = A.length - 1, mid;
        while (left <= right) {
            mid = (left + right + 1) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return 0;
        } else {
            return left;
        }
    }

    public int removeElement(int[] A, int elem) {
        int current = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[current++] = A[i];
            }
        }
        return current;
    }

    /**
     * 
     * Remove Duplicates from Sorted Array II
     * 
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // the only tricky part might be this A[0] - 1.
        int prev = A[0] - 1, j = 0, n = A.length;
        int count = 0, N = 2;
        for (int i = 0; i < n; i++) {
            if (prev != A[i]) {
                prev = A[i];
                A[j++] = prev;
                count = 1;
            } else if (count < N) {
                prev = A[i];
                A[j++] = prev;
                count++;
            }
        }
        return j;
    }
}
