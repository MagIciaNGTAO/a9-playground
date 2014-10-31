package org.mingtaoz.leetcode.string;

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
        List<List<String>> ret = new LinkedList<>();
        StringBuilder subString = new StringBuilder();
        for (char c : s.toCharArray()) {
            subString.append(c);
            if (isPalindrome(subString.toString())) {
                if (s.length() == subString.length()) {
                    List<String> curRet = new LinkedList<>();
                    curRet.add(s);
                    ret.add(curRet);
                } else {
                    List<List<String>> subPartitions = partition(s
                            .substring(subString.length()));
                    for (List<String> subPartition : subPartitions) {
                        subPartition.add(0, subString.toString());
                    }
                    ret.addAll(subPartitions);
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
    class UndirectedGraphNode {
        public int label;
        public List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public int minCut(String s) {
        if (s == null) {
            return 0;
        }
        int layer = 0, n = s.length();
        // build the graph
        boolean[] makred = new boolean[n + 1];
        UndirectedGraphNode[] palinGraph = buildPalinGraph(s);
        // BFS
        Queue<UndirectedGraphNode> curLayer = new LinkedList<>(), newLayer = new LinkedList<>();
        newLayer.add(palinGraph[0]);
        makred[0] = true;
        while (!newLayer.isEmpty()) {
            curLayer = newLayer;
            newLayer = new LinkedList<>();
            while (!curLayer.isEmpty()) {
                UndirectedGraphNode cur = curLayer.poll();
                if (cur.label == n) {
                    // find minCut
                    return layer - 1;
                }
                for (UndirectedGraphNode neighbour : cur.neighbors) {
                    if (!makred[neighbour.label] && cur.label < neighbour.label) {
                        // only make progress
                        makred[neighbour.label] = true;
                        newLayer.add(palinGraph[neighbour.label]);
                    }
                }
            }
            layer++;
        }
        return layer - 1;
    }

    public UndirectedGraphNode[] buildPalinGraph(String s) {
        int n = s.length();
        // the last one is dummy target
        UndirectedGraphNode[] p = new UndirectedGraphNode[n + 1];
        char[] chars = s.toCharArray();
        boolean[][] help = new boolean[n][n];
        // initial each node is connected with the next node
        for (int i = 0; i < n; i++) {
            help[i][i] = true;
            p[i] = new UndirectedGraphNode(i);
            p[i + 1] = new UndirectedGraphNode(i + 1);
            p[i].neighbors.add(p[i + 1]);
            p[i + 1].neighbors.add(p[i]);
        }
        // dp to build the graph
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                if (help[i + 1][j - 1] || (i + 1) >= (j - 1)) {
                    // sub is palin
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
