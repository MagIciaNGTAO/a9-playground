package org.mingtaoz.leetcode.stack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    private Stack<Integer> stack = new Stack<Integer>();

    public int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            int current;
            if (Eval.evals.containsKey(tokens[i])) {
                current = Eval.evals.get(tokens[i]).eval(stack.pop(), stack.pop());
            } else {
                current = Integer.parseInt(tokens[i]);
            }
            stack.push(current);
        }
        return stack.peek();
    }

    enum Eval {

        plus("+") {
            @Override
            int eval(int a, int b) {
                return b + a;
            }
        },

        minus("-") {
            @Override
            int eval(int a, int b) {
                return b - a;
            }
        },

        multiply("*") {
            @Override
            int eval(int a, int b) {
                return b * a;
            }
        },

        divide("/") {
            @Override
            int eval(int a, int b) {
                return b / a;
            }
        };

        private String value;

        public String getValue() {
            return value;
        }

        Eval(String value) {
            this.value = value;
        }

        abstract int eval(int a, int b);

        public static final Map<String, Eval> evals = Collections.unmodifiableMap(initializeMapping());

        private static Map<String, Eval> initializeMapping() {
            Map<String, Eval> map = new HashMap<>();
            for (Eval eval : Eval.values()) {
                map.put(eval.getValue(), eval);
            }
            return map;
        }
    }
}
