package org.mingtaoz.a9.string;

import java.util.Arrays;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 */
public class LargestNumber {

    class Wrapper implements Comparable<Wrapper> {
        public int number;

        public Wrapper(int number) {
            this.number = number;
        }

        public int compare(String s1, String s2) {
            char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
            int i = 0;
            while (i < c1.length && i < c2.length) {
                if (c1[i] != c2[i]) {
                    return c2[i] - c1[i];
                }
                i++;
            }
            // 95 951
            if (i == c1.length && i == c2.length) {
                return 0;
            }
            if (i == c1.length) {
                return compare(s1, s2.substring(i));
            }
            if (i == c2.length) {
                return compare(s1.substring(i), s2);
            }
            return 0;
        }

        @Override
        public int compareTo(Wrapper o2) {
            int n1 = this.number, n2 = o2.number;
            String s1 = String.valueOf(n1), s2 = String.valueOf(n2);
            return compare(s1, s2);
        }
    }

    public String largestNumber(int[] num) {
        Wrapper[] wrap = new Wrapper[num.length];
        for (int i = 0; i < num.length; i++) {
            wrap[i] = new Wrapper(num[i]);
        }
        Arrays.sort(wrap);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            ret.append(wrap[i].number);
        }
        // TODO special handling
        String retu = ret.toString();
        while (retu.startsWith("0") && retu.length() > 1) {
            retu = retu.substring(1);
        }
        return retu;
    }
}
