package org.mingtaoz.leetcode.iteration;

import java.util.HashMap;
import java.util.Map;

public class Roman {

    public enum RomanNumerical {
        ONE("I"), FIVE("V"), TEN("X"), FIFTY("L"), HUNDRED("C"), FIVEHUNDRED("D"), THOUSAND("M");

        private final String repr;

        RomanNumerical(String s) {
            repr = s;
        }

        @Override
        public String toString() {
            return repr;
        }
    }

    // reverse scanning :)
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] c = s.toCharArray();
        int ret = 0;
        if (c.length == 0) {
            return ret;
        }
        char prev = c[c.length - 1];
        for (int j = c.length - 2; j >= 0; j--) {
            if (prev == c[j]) {
                ret += map.get(prev);
                prev = c[j];
            } else if (map.get(prev) > map.get(c[j])) {
                ret += map.get(prev) - map.get(c[j]);
                if (j >= 1) {
                    prev = c[--j];
                } else {
                    return ret;
                }
            } else {
                ret += map.get(prev);
                prev = c[j];
            }
        }
        ret += map.get(prev);
        return ret;
    }

    // DRY out
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();

        int t = num / 1000;
        while (t-- > 0) {
            s.append(RomanNumerical.THOUSAND);
        }
        num -= num / 1000 * 1000;

        t = num / 100;
        if (t == 9) {
            s.append(RomanNumerical.HUNDRED).append(RomanNumerical.THOUSAND);
        } else if (t >= 5) {
            s.append(RomanNumerical.FIVEHUNDRED);
            t -= 5;
            while (t-- > 0) {
                s.append(RomanNumerical.HUNDRED);
            }
        } else if (t == 4) {
            s.append(RomanNumerical.HUNDRED).append(RomanNumerical.FIVEHUNDRED);
        } else {
            while (t-- > 0) {
                s.append(RomanNumerical.HUNDRED);
            }
        }
        num -= num / 100 * 100;

        t = num / 10;
        if (t == 9) {
            s.append(RomanNumerical.TEN).append(RomanNumerical.HUNDRED);
        } else if (t >= 5) {
            s.append(RomanNumerical.FIFTY);
            t -= 5;
            while (t-- > 0) {
                s.append(RomanNumerical.TEN);
            }
        } else if (t == 4) {
            s.append(RomanNumerical.TEN).append(RomanNumerical.FIFTY);
        } else {
            while (t-- > 0) {
                s.append(RomanNumerical.TEN);
            }
        }
        num -= num / 10 * 10;

        t = num;
        if (t == 9) {
            s.append(RomanNumerical.ONE).append(RomanNumerical.TEN);
        } else if (t >= 5) {
            s.append(RomanNumerical.FIVE);
            t -= 5;
            while (t-- > 0) {
                s.append(RomanNumerical.ONE);
            }
        } else if (t == 4) {
            s.append(RomanNumerical.ONE).append(RomanNumerical.FIVE);
        } else {
            while (t-- > 0) {
                s.append(RomanNumerical.ONE);
            }
        }

        return s.toString();
    }
}
