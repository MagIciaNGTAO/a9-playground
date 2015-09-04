package org.mingtaoz.leetcode.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    /**
     * 
     * Implement next permutation, which rearranges numbers into the
     * lexicographically next greater permutation of numbers.
     * 
     * Here are some examples. Inputs are in the left-hand column and its
     * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
     * 1,2,3 1,1,5 → 1,5,1
     * 
     * no disorder until the end, switch last two: 1234->1243 some disorder but
     * one in order 2134->2143 3214->3241 => find last piece of in order and
     * switch
     * failed to find ??: 4321 => 'switching sort': keep switching left++ and
     * right-- 14315 -> 14351 1237654 -> 1247653 'switching sort' -> 1243567
     * 1257643 -> 1263457 -> ; 16375 -> 16537
     * 
     * @param num
     */
    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n == 1) {
            return;
        }
        int rightMostDecrease = -1, rightMostIncrease = -1;
        for (int i = 0; i < n - 1; i++) {
            if (num[i] < num[i + 1]) {
                rightMostIncrease = i;
            } else if (num[i] > num[i + 1]) {
                rightMostDecrease = i;
            } else {
                // no-op
            }
        }
        if (rightMostIncrease > rightMostDecrease) {
            // switch right most two not equal
            int last = n - 1;
            while (num[last] == num[last - 1]) {
                last--;
            }
            int temp = num[last - 1];
            num[last - 1] = num[last];
            num[last] = temp;
        } else {
            if (rightMostIncrease != -1) {
                // search back find first element larger than rightMostIncrease
                // and switch
                int temp = num[rightMostIncrease];
                int search = n - 1;
                // TODO could be a binary search as it's sorted desc
                while (num[search] <= temp && search > rightMostIncrease) {
                    search--;
                }
                num[rightMostIncrease] = num[search];
                num[search] = temp;
            }
            n--;
            rightMostIncrease++;
            while (n > rightMostIncrease) {
                int temp = num[n];
                num[n--] = num[rightMostIncrease];
                num[rightMostIncrease++] = temp;
            }
        }
    }

    /**
     * 
     * Permutations II
     *
     * Given a collection of numbers that might contain duplicates, return all
     * possible unique permutations.
     * 
     * For example, [1,1,2] have the following unique permutations: [1,1,2],
     * [1,2,1], and [2,1,1].
     * 
     * @param num
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] num) {
        List<Integer> candidates = new ArrayList<>();
        for (int n : num) {
            candidates.add(n);
        }
        Collections.sort(candidates);
        return permuteUniqueHelper(candidates);
    }

    // again need to be clear what's the recursive function returns
    public List<List<Integer>> permuteUniqueHelper(List<Integer> candidates) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates.size() == 1) {
            List<Integer> temp = new LinkedList<>();
            temp.add(candidates.get(0));
            result.add(temp);
            return result;
        }
        int prev = candidates.get(0) - 1;
        for (int i = 0; i < candidates.size(); i++) {
            int current = candidates.get(i);
            if (current != prev) {
                candidates.remove(i);
                List<List<Integer>> subs = permuteUniqueHelper(candidates);
                candidates.add(i, current);
                for (List<Integer> sub : subs) {
                    sub.add(0, current);
                }
                result.addAll(subs);
                prev = current;
            }
        }
        return result;
    }

    /**
     * Permutation
     * 
     * Given a collection of numbers, return all possible permutations.
     * 
     * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
     * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     * 
     * @param num
     * @return
     */
    public List<List<Integer>> permute(int[] num) {
        List<Integer> candidates = new ArrayList<>();
        for (int n : num) {
            candidates.add(n);
        }
        return permuteHelper(candidates);
    }

    public List<List<Integer>> permuteHelper(List<Integer> candidates) {
        List<List<Integer>> result = new LinkedList<>();
        if (candidates.size() == 1) {
            List<Integer> temp = new LinkedList<>();
            temp.add(candidates.get(0));
            result.add(temp);
            return result;
        }
        for (int i = 0; i < candidates.size(); i++) {
            int current = candidates.remove(i);
            List<List<Integer>> subs = permuteHelper(candidates);
            candidates.add(i, current);
            for (List<Integer> sub : subs) {
                sub.add(0, current);
            }
            result.addAll(subs);
        }
        return result;
    }

    /**
     * 
     * Permutation Sequence
     * 
     * The set [1,2,3,…,n] contains a total of n! unique permutations.
     * 
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (ie, for n = 3):
     * 
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * 
     * Note: Given n will be between 1 and 9 inclusive.
     *
     */
    public String getPermutation(int n, int k) {
        k--; // starting from 0
        StringBuilder ret = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int i = 1, permutation = 1;
        while (i <= n) {
            permutation *= i;
            list.add(i++);
        }
        while (list.size() > 0) {
            permutation /= n--;
            int seq = k / permutation;
            k = k % permutation;
            ret.append(list.remove(seq));
        }
        return ret.toString();
    }
}
