package org.mingtaoz.leetcode.puzzle;

/**
 * 
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int ret = 1, prev = ratings[0], candy = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > prev) {
                // case increase: give 1 more candy
                ret += ++candy;
            } else if (ratings[i] < prev) {
                // case decrease: find local min -> give candy backwards
                int j = i - 1;
                while (i < ratings.length && ratings[i] < prev) {
                    prev = ratings[i++];
                }
                int k = i - 1;
                int tempCandy = 1;
                while (k > j) {
                    k--;
                    ret += tempCandy++;
                }
                ret += (tempCandy - candy) > 0 ? (tempCandy - candy) : 0;
                i--;
                candy = 1;
            } else {
                // case equal: give 1 candy
                candy = 0;
                ret += ++candy;
            }
            prev = ratings[i];
        }
        return ret;
    }
}
