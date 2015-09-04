package org.mingtaoz.leetcode.permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    /**
     * 
     * Given a set of candidate numbers (C) and a target number (T), find all
     * unique combinations in C where the candidate numbers sums to T.
     * 
     * The same repeated number may be chosen from C unlimited number of times.
     * 
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, … , ak) must be in non-descending
     * order. (ie, a1 ≤ a2 ≤ … ≤ ak).
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set 2,3,6,7 and target 7,
     * A solution set is:
     * [7]
     * [2, 2, 3]
     * 
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumHelper(removeDuplicates(candidates), target, 0, new LinkedList<Integer>(), 0,
                candidates.length);
    }

    // the helper will return the final result using current list combined with
    // search trough i to n
    public List<List<Integer>> combinationSumHelper(int[] candidates, int target, int sum, List<Integer> current,
            int start, int n) {
        List<List<Integer>> ret = new LinkedList<>();
        if (sum == target) {
            List<Integer> temp = new LinkedList<Integer>(current);
            ret.add(temp);
            return ret;
        }
        // i = start make sure: The same repeated number may be chosen from C unlimited number of times.
        for (int i = start; i < n; i++) {
            if (sum + candidates[i] <= target) {
                current.add(candidates[i]);
                List<List<Integer>> temp = combinationSumHelper(candidates, target, sum + candidates[i], current, i, n);
                ret.addAll(temp);
                current.remove(current.size() - 1);
            } else {
                // this pruning is important
                break;
            }

        }
        return ret;
    }

    private int[] removeDuplicates(int[] A) {
        int n = A.length, j = 0;
        Arrays.sort(A);
        for (int i = 0, prev = -1; i < n; i++) {
            if (prev != A[i]) {
                prev = A[i];
                A[j++] = prev;
            }
        }
        return Arrays.copyOf(A, j);
    }

    /**
     * 
     * Given a collection of candidate numbers (C) and a target number (T), find
     * all unique combinations in C where the candidate numbers sums to T.
     * 
     * Each number in C may only be used once in the combination.
     * 
     * Note:
     * All numbers (including target) will be positive integers.
     * Elements in a combination (a1, a2, … , ak) must be in non-descending
     * order. (ie, a1 ≤ a2 ≤ … ≤ ak).
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
     * A solution set is:
     * [1, 7]
     * [1, 2, 5]
     * [2, 6]
     * [1, 1, 6]
     * 
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Set<String> rep = new HashSet<>();
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(num);
        List<List<Integer>> all = combinationSumHelper2(num, target, 0, new LinkedList<Integer>(), -1);
        for (List<Integer> one : all) {
            String s = one.toString();
            if (!rep.contains(s)) {
                ret.add(one);
                rep.add(s);
            }
        }
        return ret;
    }

    public List<List<Integer>> combinationSumHelper2(int[] candidates, int target, int sum, List<Integer> current,
            int start) {
        List<List<Integer>> ret = new LinkedList<>();
        if (sum == target) {
            List<Integer> temp = new LinkedList<Integer>(current);
            ret.add(temp);
            return ret;
        }
        for (int i = start + 1, prev = -1; i < candidates.length; i++) {
            if (prev != candidates[i] || prev == -1) {
                if (sum + candidates[i] <= target) {
                    current.add(candidates[i]);
                    List<List<Integer>> temp = combinationSumHelper2(candidates, target, sum + candidates[i], current,
                            i);
                    current.remove(current.size() - 1);
                    ret.addAll(temp);
                } else {
                    break;
                }
                prev = candidates[i];
            }
        }
        return ret;
    }
}
