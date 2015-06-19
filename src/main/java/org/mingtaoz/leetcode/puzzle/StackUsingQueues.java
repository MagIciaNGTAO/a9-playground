package org.mingtaoz.leetcode.puzzle;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int n = q1.poll();
        while (!q1.isEmpty()) {
            q2.offer(n);
            n = q1.poll();
        }
        q1 = q2;
        q2 = new LinkedList<>();
    }

    // Get the top element.
    public int top() {
        int ret = 0;
        while (!q1.isEmpty()) {
            ret = q1.poll();
            q2.offer(ret);
        }
        q1 = q2;
        q2 = new LinkedList<>();
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
