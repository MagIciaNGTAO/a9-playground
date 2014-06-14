package org.mingtaoz.leetcode.puzzle;

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
    	int ret = 0;
        
    	if(A == null) {
    		return ret;
    	}
    	
    	for(int a : A) {
    		ret ^= a;
    	}
    	
    	return ret;
    }
}
