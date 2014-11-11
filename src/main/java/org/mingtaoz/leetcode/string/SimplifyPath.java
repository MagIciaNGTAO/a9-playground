package org.mingtaoz.leetcode.string;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 */
public class SimplifyPath {
    // TODO DRY ... the problem is kinda nasty
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        char[] characters = path.toCharArray();
        int dotCount = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '/') {
                // case /
                if (dotCount == 1) {
                    stack.pop();
                } else if (dotCount == 2) {
                    while (!stack.isEmpty() && !stack.peek().equals("/")) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.size() > 1) {
                        // pop / if exist
                        stack.pop();
                        // further go to next /
                        while (!stack.isEmpty() && !stack.peek().equals("/")) {
                            stack.pop();
                        }
                    }
                } else if (!stack.isEmpty() && stack.peek().equals("/")) {
                    // noop
                } else {
                    stack.push("/");
                }
                dotCount = 0;
            } else if (characters[i] == '.') {
                dotCount++;
                stack.push(".");
            } else {
                // case [a-zA-Z]
                stack.push(characters[i] + "");
                dotCount = 0;
            }
        }
        StringBuilder ret = new StringBuilder();
        if (stack.size() > 1 && stack.peek().equals("/")) {
            stack.pop();
        }
        if (dotCount < 3) {
            if (dotCount == 2) {
                while (!stack.isEmpty() && !stack.peek().equals("/")) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.size() > 1) {
                    // pop / if exist
                    stack.pop();
                    // further go to next /
                    while (!stack.isEmpty() && !stack.peek().equals("/")) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.size() > 1) {
                        stack.pop();
                    }
                }
            } else {
                while (dotCount-- > 0) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek().equals("/")) {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            stack.push("/");
        }
        while (!stack.isEmpty()) {
            ret.insert(0, stack.pop());
        }
        return ret.toString();
    }
}
