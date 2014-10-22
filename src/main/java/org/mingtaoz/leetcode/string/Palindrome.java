package org.mingtaoz.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.mingtaoz.leetcode.graph.UndirectedGraph.UndirectedGraphNode;

public class Palindrome {

	private Map<String, Boolean> palinDromeCache = new HashMap<>();

	/**
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

		char[] chars = s.toCharArray();
		int i = 0, j = chars.length - 1;

		while (j > i) {
			if (chars[i++] != chars[j--]) {
				palinDromeCache.put(s, false);
				return false;
			}
		}

		palinDromeCache.put(s, true);
		return true;
	}

	/**
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
	public int minCutDPnSquare(String s) {
		if (s == null) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int n = s.length();
		// build the table
		boolean p[][] = new boolean[n][n]; // p[i][j] == true <=> s(i, j) is
		int[][] m = new int[n][n]; // initial 0 is default

		// initial
		for (int i = 0; i < n; i++) {
			p[i][i] = true;
		}

		// another dp
		for (int k = 1; k < n; k++) {
			for (int i = 0; i < n - k; i++) {
				int j = i + k;

				if (p[i + 1][j - 1] || (i + 1) >= (j - 1)) { // rare second case
					// sub is palin
					p[i][j] = chars[i] == chars[j];
				}

				if (p[i][j]) {
					m[i][j] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					for (int mid = i; mid < j; mid++) {
						// min through another cut
						min = Math.min(min, m[i][mid] + m[mid + 1][j]);
						if (min == 0) {
							break;
						}
					}
					m[i][j] = min + 1;
				}
			}
		}

		return m[0][n - 1];
	}

	/**
	 * 
	 * could be further optimized with two way BFS
	 * 
	 * @param s
	 * @return
	 */
	public int minCut(String s) {
		if (s == null) {
			return 0;
		}
		int layer = 0;
		int n = s.length();
		// build the graph
		boolean[] makred = new boolean[n + 1];
		UndirectedGraphNode[] p = buildPalinGraph(s);
		// simple layered BFS
		Queue<UndirectedGraphNode> curLayer = new LinkedList<>();
		Queue<UndirectedGraphNode> newLayer = new LinkedList<>();
		newLayer.add(p[0]);
		makred[0] = true;
		while (!newLayer.isEmpty()) {
			curLayer = newLayer;
			newLayer = new LinkedList<>();
			while (!curLayer.isEmpty()) {
				UndirectedGraphNode cur = curLayer.poll();
				if (cur.label == n) {
					return layer - 1; // find minCut
				}
				for (UndirectedGraphNode neighbour : cur.neighbors) {
					if (!makred[neighbour.label] && cur.label < neighbour.label) {
						// only try to make progress
						makred[neighbour.label] = true;
						newLayer.add(p[neighbour.label]);
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
						p[i].neighbors.add(p[j + 1]); // from i could reach j +
														// 1
					}
				}
				// else leave the table as false
			}
		}
		return p;
	}

	public boolean[][] buildPalintable(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();

		boolean p[][] = new boolean[n][n]; // p[i][j] == true <=> s(i, j) is

		// initial
		for (int i = 0; i < n; i++) {
			p[i][i] = true;
		}
		// dp
		for (int k = 1; k < n; k++) {
			for (int i = 0; i < n - k; i++) {
				int j = i + k;
				if (p[i + 1][j - 1] || (i + 1) >= (j - 1)) { // rare second case
					// sub is palin
					p[i][j] = chars[i] == chars[j];
				}
				// else leave the table as false
			}
		}

		return p;
	}

	/**
	 * 
	 * recursion is not good enough in this context, as the recursion tree will
	 * overlap deep
	 * 
	 * @param s
	 * @return
	 */
	public int minCutHelper(int start, int end, boolean p[][]) {
		int ret = Integer.MAX_VALUE;

		if (p[start][end]) {
			return 0;
		} else {
			int i = start;
			while (i < end) {
				if (p[start][i]) {
					ret = Math.min(ret, minCutHelper(i + 1, end, p));
				}
				i++;
			}
		}

		return ret + 1;
	}

}
