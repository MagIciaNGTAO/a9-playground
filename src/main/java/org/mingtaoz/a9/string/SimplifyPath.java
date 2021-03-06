package org.mingtaoz.a9.string;

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

    // the core is recognize / to / is boundary to boundary
    // and .ssh can be file name ...
    public String simplifyPath(String path) {
        StringBuilder ret = new StringBuilder();
        Stack<String> folders = new Stack<>();
        while (path.length() > 0 && path.startsWith("/")) {
            path = path.substring(1);
            int i = 0;
            for (; i < path.length() && '/' != path.charAt(i); i++)
                ;
            String temp = path.substring(0, i);
            if (i == 0) {
                continue;
            }
            path = path.substring(i);
            if ("..".equals(temp)) {
                if (!folders.isEmpty()) {
                    folders.pop();
                }
            } else if (!".".equals(temp)) {
                folders.push(temp);
            }
        }
        while (!folders.isEmpty()) {
            ret.insert(0, "/" + folders.pop());
        }
        if (ret.length() == 0) {
            ret.append("/");
        }
        return ret.toString();
    }
}
