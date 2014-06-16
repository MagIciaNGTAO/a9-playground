package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
	
    public int singleNumberFrom2Duplicates(int[] A) {
    	int ret = 0;
    
    	if(A == null) {
    		return ret;
    	}
    	
    	for(int a : A) {
    		ret ^= a;
    	}
    	
    	return ret;
    }
    
    public int singleNumberFrom3Duplicates(int[] A) {
    	Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
    	
    	int ret = 0;
        
    	if(A == null) {
    		return ret;
    	}
    	
    	for(int a : A) {
    		if(!visited.containsKey(a)) {
    			visited.put(a, 1);
    		} else {
    			visited.put(a, visited.get(a) + 1);
    		}
    	}

    	for(int a : A) {
    		if(visited.get(a) == 1) {
    			ret = a;
    		}
    	}
    	
    	return ret;
    }
    
    public int singleNumberFrom3DuplicatesConstantMemory(int[] A) {
    	int ret = 0;
        
    	
    	
    	return ret;
    }
}
