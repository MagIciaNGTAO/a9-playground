package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;

public class Sum {
	
    public int[] twoSum(int[] numbers, int target) {
    	Map<Integer, Integer> complement = new HashMap<>();
    	int[] ret = new int[2];
    	
    	for(int i = 0; i < numbers.length; i++) {
    		if(complement.containsKey(numbers[i])) {
    			ret[0] = complement.get(numbers[i]) + 1;
    			ret[1] = i + 1;
    		} else {
    			complement.put(target - numbers[i], i);
    		}
    	}
    	return ret;
    }
}
