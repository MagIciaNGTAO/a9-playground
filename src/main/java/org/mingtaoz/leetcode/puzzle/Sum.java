package org.mingtaoz.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sum {

    /**
     * 
     * Two Sum I - Input array is sorted
     * &
     * Two Sum II - Input array is sorte 
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> complement = new HashMap<>();
        int[] ret = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (complement.containsKey(numbers[i])) {
                ret[0] = complement.get(numbers[i]) + 1;
                ret[1] = i + 1;
                return ret;
            } else {
                complement.put(target - numbers[i], i);
            }
        }
        return ret;
    }

    /**
     * 
     * Two Sum III - Data structure design
     * 
     * Design and implement a TwoSum class. It should support the following operations: add and find.

    add - Add the number to an internal data structure.
    find - Find if there exists any pair of numbers which sum is equal to the value.

    For example,
    add(1); add(3); add(5);
    find(4) -> true
    find(7) -> false
     *
     */
    class TwoSum {

        List<Integer> numbers = new ArrayList<>();
        Set<Integer> cache = new HashSet<>();

        public void add(int number) {
            numbers.add(number);
        }

        public boolean find(int value) {
            if (cache.contains(value)) {
                return true;
            }
            Map<Integer, Integer> complement = new HashMap<>();
            for (int i = 0; i < numbers.size(); i++) {
                if (complement.containsKey(numbers.get(i))) {
                    cache.add(value);
                    return true;
                } else {
                    complement.put(value - numbers.get(i), i);
                }
            }
            return false;
        }
    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new LinkedList<>();
        if (num.length == 0) {
            return ret;
        }
        Set<String> dup = new HashSet<>();
        // 1. sort
        Arrays.sort(num);
        // 2. remove duplicate
        int right = removeDuplicate(num);
        // 3. search & prunning
        int left = 0;
        for (; left < right - 1 && num[left] <= 0; left++) {
            for (int j = right; j > left + 1; j--) {
                for (int i = j - 1; i > left & num[left] + num[i] + num[j] >= 0; i--) {
                    if ((num[left] + num[i] + num[j]) == 0) {
                        List<Integer> list = Arrays.asList(num[left], num[i], num[j]);
                        String s = list.toString();
                        if (!dup.contains(s)) {
                            dup.add(s);
                            ret.add(list);
                        }
                    }
                }
            }
        }
        return ret;
    }

    public int removeDuplicate(int[] num) {
        int total = 0, prev = num[total];
        int count = 0;
        for (int i = 1; i < num.length; i++) {
            if (prev != num[i]) {
                num[++total] = num[i];
                prev = num[i];
                count = 0;
            } else {
                if (count == 0) {
                    count++;
                    num[++total] = num[i];
                } else if (num[i] == 0 && count < 2) {
                    // TODO: missed three 0 case
                    count++;
                    num[++total] = num[i];
                } else {
                    count++;
                }
            }
        }
        return total;
    }

    public int threeSumClosest(int[] num, int target) {
        int ret = 0, dist = Integer.MAX_VALUE;
        Arrays.sort(num);
        int right = removeTrilicate(num);
        int left = 0;
        for (; left < right - 1; left++) {
            for (int j = right; j > left + 1; j--) {
                for (int i = j - 1; i > left; i--) {
                    if (num[left] + num[i] + num[j] - target == 0) {
                        return target;
                    }
                    if (Math.abs(num[left] + num[i] + num[j] - target) < dist) {
                        dist = Math.abs(num[left] + num[i] + num[j] - target);
                        ret = num[left] + num[i] + num[j];
                    }
                }
            }
        }
        return ret;
    }

    // 2222 333 -> 222 333
    public int removeTrilicate(int[] num) {
        int total = 0, prev = num[total];
        int count = 0;
        for (int i = 1; i < num.length; i++) {
            if (prev != num[i]) {
                num[++total] = num[i];
                prev = num[i];
                count = 0;
            } else {
                if (count < 2) {
                    count++;
                    num[++total] = num[i];
                }
            }
        }
        return total;
    }

    class Wrapper {

        public List<Integer> list;

        public Wrapper(List<Integer> list) {
            this.list = list;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Wrapper) {
                Wrapper that = (Wrapper) o;
                return list.toString().equals(that.list.toString());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return list.get(0) - list.get(1);
        }
    }

    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new LinkedList<>();
        if (num.length == 0) {
            return ret;
        }
        Set<Wrapper> dup = new HashSet<>();
        // 1. sort
        Arrays.sort(num);
        // 2. remove duplicate
        int right = removeQuaduplets(num), left = 0;
        // 3. search & pruning
        int quarter = target / 4 - 1, half = target / 2 - 1, threeQuarter = half + quarter;
        for (; right > left + 2; right--) {
            if (num[right] < quarter) {
                // right most is the largest, should be larger than 1/4 target
                break;
            }
            for (int i = right - 1; i > left + 1; i--) {
                int partialOut = num[right] + num[i];
                if (partialOut < half) {
                    // right two should be larger than half
                    break;
                }
                for (int j = i - 1; j > left; j--) {
                    int partial = partialOut + num[j];
                    if (partial < threeQuarter) {
                        // right three should be larger than 3 quarters
                        break;
                    }
                    for (int k = left; k < j; k++) {
                        int temp = partial + num[k];
                        if (temp == target) {
                            List<Integer> list = Arrays.asList(num[k], num[j], num[i], num[right]);
                            Wrapper w = new Wrapper(list);
                            if (!dup.contains(w)) {
                                dup.add(w);
                                ret.add(list);
                            }
                        } else if (temp > target) {
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }

    public int removeQuaduplets(int[] num) {
        int total = 0, prev = num[total];
        int count = 0;
        for (int i = 1; i < num.length; i++) {
            if (prev != num[i]) {
                num[++total] = num[i];
                prev = num[i];
                count = 0;
            } else {
                if (count < 3) {
                    count++;
                    num[++total] = num[i];
                }
            }
        }
        return total;
    }
}
