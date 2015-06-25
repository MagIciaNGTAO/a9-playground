package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {

    class Wrapper {
        public Wrapper(int sum, boolean plus) {
            this.sum = sum;
            this.plus = plus;
        }

        public int sum;
        public boolean plus;
    }

    public int calculate(String s) {
        Stack<Integer> pos = new Stack<>();
        Map<Integer, Wrapper> posLeftState = new HashMap<>();// merge map
        boolean plus = true;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                // skip
            } else if (s.charAt(i) == '+') {
                plus = true;
            } else if (s.charAt(i) == '-') {
                plus = false;
            } else if (s.charAt(i) == '(') {
                pos.push(i);
                posLeftState.put(i, new Wrapper(ret, plus));
                plus = true;
                ret = 0;
            } else if (s.charAt(i) == ')') {
                int leftParenIndex = pos.pop();
                Wrapper w = posLeftState.get(leftParenIndex);
                if (w.plus) {
                    ret = w.sum + ret;
                } else {
                    ret = w.sum - ret;
                }
            } else if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                String next = nextNumberString(i, s);
                if (plus) {
                    ret += Integer.parseInt(next);
                } else {
                    ret -= Integer.parseInt(next);
                }
                i += next.length() - 1;
            }
        }
        return ret;
    }

    class N {
        public boolean sign;
        public long n;

        public N(boolean sign, long n) {
            this.sign = sign;
            this.n = n;
        }
    }

    public int calculate2(String s) {
        Stack<N> numbers = new Stack<>();
        boolean sign = true, multi = false, divide = false;
        int ret = 0;
        N n = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                // skip
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                sign = (s.charAt(i) == '+');
                multi = false;
                divide = false;
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                multi = (s.charAt(i) == '*');
                divide = (s.charAt(i) == '/');
                n = numbers.pop();
            } else if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                String next = nextNumberString(i, s);
                if (multi || divide) {
                    if (multi) {
                        numbers.push(new N(n.sign, n.n * Long.parseLong(next)));
                    } else {
                        numbers.push(new N(n.sign, n.n / Long.parseLong(next)));
                    }
                } else {
                    numbers.push(new N(sign, Long.parseLong(next)));
                }
                i += next.length() - 1;
            }
        }
        while (!numbers.isEmpty()) {
            n = numbers.pop();
            if (n.sign) {
                ret += n.n;
            } else {
                ret -= n.n;
            }
        }
        return ret;
    }

    public String nextNumberString(int i, String s) {
        int start = i;
        while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
            i++;
        }
        return s.substring(start, i);
    }
}
