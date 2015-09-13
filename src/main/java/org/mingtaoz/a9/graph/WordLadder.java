package org.mingtaoz.a9.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.mingtaoz.leetcode.list.SinglyLinkedList;

public class WordLadder {

    /**
     *
     * Word Ladder 1
     * 
     * Given two words (start and end), and a dictionary, find the length of
     * shortest transformation sequence from start to end, such that:
     * 
     * Only one letter can be changed at a time Each intermediate word must
     * exist in the dictionary For example,
     * 
     * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" ->
     * "cog", return its length 5.
     * 
     * Note: Return 0 if there is no such transformation sequence. All words
     * have the same length. All words contain only lowercase alphabetic
     * characters.
     * 
     * @param start
     * @param end
     * @param dict
     * @return
     */
    // two way BFS
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end); // for searching purpose

        if (neighbours(start, dict).contains(end)) {
            return 2;
        }

        int forwardLayer = 0, backwardLayer = 0;
        Set<String> forwardMarked = new HashSet<>();
        Set<String> backwardMarked = new HashSet<>();
        Queue<String> forwardCurLayer = new LinkedList<>(), forwardNextLayer;
        Queue<String> backwardCurLayer = new LinkedList<>(), backwardNextLayer;
        forwardMarked.add(start);
        backwardMarked.add(end);
        forwardCurLayer.add(start);
        backwardCurLayer.add(end);

        while (!forwardCurLayer.isEmpty() && !backwardCurLayer.isEmpty()) {
            forwardNextLayer = new LinkedList<>();
            backwardNextLayer = new LinkedList<>();
            for (String forword : forwardCurLayer) {
                for (String neighbour : neighbours(forword, dict)) {
                    if (backwardCurLayer.contains(neighbour)) {
                        dict.remove(end);
                        return forwardLayer + backwardLayer + 2;
                    } else {
                        if (!forwardMarked.contains(neighbour)) {
                            forwardMarked.add(neighbour);
                            forwardNextLayer.add(neighbour);
                        }
                    }
                }
            }
            for (String backword : backwardCurLayer) {
                for (String neighbour : neighbours(backword, dict)) {
                    if (forwardCurLayer.contains(neighbour)) {
                        dict.remove(end);
                        return forwardLayer + backwardLayer + 2;
                    } else {
                        if (!backwardMarked.contains(neighbour)) {
                            backwardMarked.add(neighbour);
                            backwardNextLayer.add(neighbour);
                            if (forwardNextLayer.contains(neighbour)) {
                                dict.remove(end);
                                return forwardLayer + backwardLayer + 3;
                            }
                        }
                    }
                }
            }
            forwardLayer++;
            backwardLayer++;
            forwardCurLayer = forwardNextLayer;
            backwardCurLayer = backwardNextLayer;
        }
        dict.remove(end);
        return 0;
    }

    Map<String, List<String>> cache = new HashMap<>();

    /**
     * PRE: s is not null not empty
     * 
     * @param s
     * @return
     */
    public List<String> neighbours(String s, Set<String> dict) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s == null || s.length() == 0)
            return new LinkedList<>();
        char[] chars = s.toCharArray();
        List<String> ret = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder(s);
            for (char c = 'a'; c <= 'z'; c++) {
                if (chars[i] == c) {
                    continue;
                }
                String potentialNeighbour = sb.replace(i, i + 1, c + "").toString();
                if (dict.contains(potentialNeighbour)) {
                    ret.add(potentialNeighbour);
                }
            }
        }
        cache.put(s, ret);
        return ret;
    }

    /**
     * 
     * Word Ladder 2
     * 
     * Given two words (start and end), and a dictionary, find all shortest
     * transformation sequence(s) from start to end, such that:
     * 
     * Only one letter can be changed at a time Each intermediate word must
     * exist in the dictionary For example,
     * 
     * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
     * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"]
     * ] Note: All words have the same length. All words contain only lowercase
     * alphabetic characters.
     * 
     * @param start
     * @param end
     * @param dict
     * @return
     */
    // BFS to collect all routes, DFS to generate result
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // reversed reference
        Map<String, List<String>> subGraph = new HashMap<>(), tempSubGraph = new HashMap<>();
        Queue<String> curLayer = new LinkedList<String>(), nextLayer = new LinkedList<String>();
        dict.add(end);
        curLayer.add(start);
        boolean reachShortest = false;
        while (!curLayer.isEmpty()) {
            String current = curLayer.poll();
            for (String neighbour : neighbours(current, dict)) {
                if (neighbour.equals(end)) {
                    reachShortest = true;
                }
                if (!subGraph.containsKey(neighbour)) {
                    if (!tempSubGraph.containsKey(neighbour)) {
                        List<String> temp = new LinkedList<String>();
                        temp.add(current);
                        tempSubGraph.put(neighbour, temp);
                        nextLayer.add(neighbour);
                    } else {
                        List<String> temp = tempSubGraph.get(neighbour);
                        temp.add(current);
                        tempSubGraph.put(neighbour, temp);
                    }
                }
            }
            if (curLayer.isEmpty()) {
                // always finish current layer
                curLayer = nextLayer;
                nextLayer = new LinkedList<String>();
                subGraph.putAll(tempSubGraph);
                tempSubGraph = new HashMap<String, List<String>>();
                if (reachShortest) {
                    // generate result
                    break;

                }
            }
        }
        return generateResult(subGraph, start, end);
    }

    // DFS
    private List<List<String>> generateResult(Map<String, List<String>> reversedGraph, String start, String end) {
        List<List<String>> ret = new LinkedList<>();
        // null - never seen for current DFS stack
        // 0 - to be visited
        // 1 - visited
        Map<String, Integer> mark = new HashMap<String, Integer>();
        Stack<String> stack = new Stack<String>();
        List<String> temp = new LinkedList<String>();
        stack.add(end);
        mark.put(end, 0);
        while (!stack.isEmpty()) {
            String cur = stack.peek();
            if (mark.get(cur) == 1) {
                stack.pop();
                mark.remove(cur);
                temp.remove(cur);
            } else {
                mark.put(cur, 1);
                temp.add(cur);
                if (cur.equals(start)) {
                    ret.add(SinglyLinkedList.reverseCopy(temp));
                }
                List<String> neighbors = reversedGraph.get(cur);
                if (neighbors != null) {
                    for (String s : neighbors) {
                        if (!mark.containsKey(s)) {
                            stack.push(s);
                            mark.put(s, 0);
                        }
                    }
                }
            }
        }
        return ret;
    }
}
