package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator {

    Stack<Integer> pos = new Stack<>();
    Map<Integer, Wrapper> posLeftState = new HashMap<>();// merge map
    boolean plus = true;

    class Wrapper {
        public Wrapper(int sum, boolean plus) {
            this.sum = sum;
            this.plus = plus;
        }

        public int sum;
        public boolean plus;
    }

    public int calculate(String s) {
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
                int start = i;
                while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    i++;
                }
                if (plus) {
                    ret += Integer.parseInt(s.substring(start, i));
                } else {
                    ret -= Integer.parseInt(s.substring(start, i));
                }
                i--;
            }
        }
        return ret;
    }

    public int calculate2(String s) {
        // TODO
        
        return -1;
    }
}
