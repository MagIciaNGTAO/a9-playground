package org.mingtaoz.leetcode.stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack sut = new MinStack();
        sut.push(512);
        sut.push(-1024);
        sut.push(-1024);
        sut.push(512);
        sut.pop();
        sut.getMin();
        sut.pop();
        sut.getMin();
        sut.pop();
        sut.getMin();
    }

}
