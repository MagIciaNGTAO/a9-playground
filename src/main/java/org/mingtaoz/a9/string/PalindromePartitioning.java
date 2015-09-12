package org.mingtaoz.a9.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PalindromePartitioning {

    private Map<String, Boolean> palinDromeCache = new HashMap<>();

    /**
     * Palindrome Partitioning
     * 
     * Given a string s, partition s such that every substring of the partition
     * is a palindrome.
     * 
     * Return all possible palindrome partitioning of s.
     * 
     * For example, given s = "aab", Return
     * 
     * [ ["aa","b"], ["a","a","b"] ]
     * 
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<List<String>>();
        StringBuilder left = new StringBuilder();
        for (char c : s.toCharArray()) {
            left.append(c);
            String temp = left.toString();
            if (isPalindrome(temp)) {
                if (left.length() == s.length()) {
                    List<String> last = new LinkedList<>();
                    last.add(temp);
                    ret.add(last);
                    return ret;
                } else {
                    List<List<String>> rights = partition(s.substring(left.length()));
                    for (List<String> right : rights) {
                        right.add(0, temp);
                        ret.add(right);
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s) {
        if (palinDromeCache.containsKey(s)) {
            return palinDromeCache.get(s);
        }
        boolean ret = true;
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (j > i) {
            if (chars[i++] != chars[j--]) {
                ret = false;
            }
        }
        palinDromeCache.put(s, ret);
        return ret;
    }

    /**
     * 
     * Palindrome Partitioning II
     * 
     * Given a string s, partition s such that every substring of the partition
     * is a palindrome.
     * 
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * 
     * For example, given s = "aab", Return 1 since the palindrome partitioning
     * ["aa","b"] could be produced using 1 cut.
     * 
     * @param s
     * @return
     */
    class Node {
        public int label;
        public List<Node> neighbors;

        public Node(int x) {
            label = x;
            neighbors = new ArrayList<Node>();
        }
    }

    public int minCut(String s) {
        if (s == null) {
            return 0;
        }
        int layer = 0, n = s.length();
        // build the graph
        boolean[] makred = new boolean[n + 1];
        Node[] palinGraph = buildPalinGraph(s);
        // BFS
        Queue<Node> curLayer = new LinkedList<>(), newLayer = new LinkedList<>();
        newLayer.add(palinGraph[0]);
        makred[0] = true;
        while (!newLayer.isEmpty()) {
            curLayer = newLayer;
            newLayer = new LinkedList<>();
            while (!curLayer.isEmpty()) {
                Node cur = curLayer.poll();
                if (cur.label == n) {
                    return layer - 1;
                }
                for (Node neighbour : cur.neighbors) {
                    if (!makred[neighbour.label]) {
                        // ensure making progress
                        makred[neighbour.label] = true;
                        newLayer.add(palinGraph[neighbour.label]);
                    }
                }
            }
            layer++;
        }
        return layer - 1;
    }

    // TODO 
    // why bother build the graph 
    public Node[] buildPalinGraph(String s) {
        int n = s.length();
        // the last one is dummy target
        Node[] p = new Node[n + 1];
        char[] chars = s.toCharArray();
        boolean[][] help = new boolean[n][n];
        // initial each node is connected with the next node
        for (int i = 0; i < n; i++) {
            help[i][i] = true;
            p[i] = new Node(i);
            p[i + 1] = new Node(i + 1);
            p[i].neighbors.add(p[i + 1]);
        }
        // dp to build the graph
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                if (help[i + 1][j - 1] || (i + 1) >= (j - 1)) {
                    // sub is palin or empty
                    if (chars[i] == chars[j]) {
                        help[i][j] = true;
                        // from i could reach j + 1
                        p[i].neighbors.add(p[j + 1]);
                    }
                }
            }
        }
        return p;
    }
}
