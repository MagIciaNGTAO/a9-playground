package org.mingtaoz.leetcode.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadder {

	/**
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

	// one way breadth-first search
	// TODO two way BFS could improve that exponentially
	public int ladderLength(String start, String end, Set<String> dict) {
		dict.add(end); // for searching purpose
		int layer = 0;
		Set<String> marked = new HashSet<>();
		Queue<String> toBeVisited = new LinkedList<>(), nextFront;
		marked.add(start);
		toBeVisited.add(start);

		while (!toBeVisited.isEmpty()) {
			nextFront = new LinkedList<>();
			while (!toBeVisited.isEmpty()) {
				String current = toBeVisited.poll();
				if (end.equals(current)) {
					dict.remove(end);
					return layer + 1; // TODO reduce one layer of search ??
				}
				List<String> neighbours = neighbours(current, dict);
				for (String neighbour : neighbours) {
					if (!marked.contains(neighbour)) {
						marked.add(neighbour);
						nextFront.add(neighbour);
					}
				}
			}
			layer++;
			toBeVisited = nextFront;
		}

		dict.remove(end);
		return 0;
	}

	/**
	 * PRE: s is not null not empty
	 * 
	 * @param s
	 * @return
	 */
	public List<String> neighbours(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return null;
		char[] chars = s.toCharArray();
		List<String> ret = new LinkedList<>();

		for (int i = 0; i < chars.length; i++) {
			StringBuilder sb = new StringBuilder(s);
			for (char c = 'a'; c <= 'z'; c++) {
				if (chars[i] == c)
					continue;
				String potentialNeighbour = sb.replace(i, i + 1, c + "")
						.toString();
				if (dict.contains(potentialNeighbour)) {
					ret.add(potentialNeighbour);
				}
			}
		}

		return ret;
	}

	/**
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
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> ret = new LinkedList<>();
		Map<String, List<String>> subGraph = new HashMap<>();
		Map<String, List<String>> tempSubGraph = new HashMap<>();
		Set<String> visited = new HashSet<String>();
		Queue<String> curLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		dict.add(end);
		curLevel.add(start);
		boolean reachShortest = false;
		while (!curLevel.isEmpty()) {
			String current = curLevel.remove();
			for (String neighbour : neighbours(current, dict)) {
				if (neighbour.equals(end)) {
					reachShortest = true; // Reach the shortest path.
				}
				if (!subGraph.containsKey(neighbour)) {
					if (!tempSubGraph.containsKey(neighbour)) {
						List<String> temp = new LinkedList<String>();
						temp.add(current);
						tempSubGraph.put(neighbour, temp);
						nextLevel.add(neighbour);
						visited.add(neighbour);
					} else {
						List<String> temp = tempSubGraph.get(neighbour);
						temp.add(current);
						tempSubGraph.put(neighbour, temp);
					}
				}
			}
			if (curLevel.isEmpty()) {
				curLevel = nextLevel; // nextLevel
				nextLevel = new LinkedList<String>();
				subGraph.putAll(tempSubGraph);
				tempSubGraph = new HashMap<String, List<String>>();
				if (reachShortest) {
					// after reachShortest, exhaust the current BFS
					generateResult(ret, subGraph, start, end);
					return ret;
				}
			}
		}
		return ret;
	}

	// DFS iterative
	private void generateResult(List<List<String>> result,
			Map<String, List<String>> mapVisited, String start, String end) {
		Map<String, Integer> visited = new HashMap<String, Integer>();
		// null, 0, 1
		Stack<String> stack = new Stack<String>();
		List<String> retEntry = new LinkedList<String>();
		stack.add(end);
		visited.put(end, 0);
		while (!stack.isEmpty()) {
			String cur = stack.peek();
			if (visited.get(cur) == 1) {
				stack.pop();
				visited.remove(cur);
				retEntry.remove(cur);
				continue;
			} else {
				retEntry.add(cur);
				visited.put(cur, 1);
				if (cur.equals(start)) {
					result.add(reverseCopy(retEntry));
				}
				List<String> neighbors = mapVisited.get(cur);
				if (neighbors != null) {
					for (String s : neighbors) {
						if (!visited.containsKey(s)) {
							stack.push(s);
							visited.put(s, 0);
						}
					}
				}
			}
		}
	}

	private List<String> reverseCopy(List<String> source) {
		List<String> ret = new LinkedList<>();
		for (String s : source) {
			ret.add(0, s);
		}
		return ret;
	}
}
