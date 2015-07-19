package org.mingtaoz.leetcode.puzzle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch {
    class Trie {
        class TrieNode {
            public boolean isWord;
            public Map<Character, TrieNode> children; // outlink -> node

            public TrieNode() {
                children = new HashMap<>();
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            char[] wordChars = word.toCharArray();
            int i = 0;
            TrieNode current = root;
            while (i < wordChars.length && current.children.containsKey(wordChars[i])) {
                current = current.children.get(wordChars[i]);
                i++;
            }
            while (i < wordChars.length) {
                TrieNode newNode = new TrieNode();
                current.children.put(wordChars[i], newNode);
                current = newNode;
                i++;
            }
            current.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            char[] wordChars = word.toCharArray();
            int i = 0;
            TrieNode current = root;
            while (i < wordChars.length && current.children.containsKey(wordChars[i])) {
                current = current.children.get(wordChars[i]);
                i++;
            }
            if (i == wordChars.length && current.isWord) {
                return true;
            }
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            char[] wordChars = prefix.toCharArray();
            int i = 0;
            TrieNode current = root;
            while (i < wordChars.length && current.children.containsKey(wordChars[i])) {
                current = current.children.get(wordChars[i]);
                i++;
            }
            if (i == wordChars.length) {
                return true;
            }
            return false;
        }
    }

    /**
     * 
     * Given board =
     * 
     * [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word =
     * "SEE", -> returns true, word = "ABCB", -> returns false.
     * 
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        int n = board.length, m = board[0].length;
        boolean[][] mask = getNewMask(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (existHelper(board, word, i, j, mask)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean[][] getNewMask(int n, int m) {
        boolean[][] mask = new boolean[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            mask[i][0] = true;
            mask[i][m + 1] = true;
        }
        for (int i = 0; i < m + 2; i++) {
            mask[0][i] = true;
            mask[n + 1][i] = true;
        }
        return mask;
    }

    private boolean existHelper(char[][] board, String word, int i, int j, boolean[][] visited) {
        if (word.length() == 0) {
            return true;
        }
        if (visited[i + 1][j + 1]) {
            return false;
        }
        // TODO offset
        if (word.startsWith(board[i][j] + "")) {
            String next = word.substring(1);
            visited[i + 1][j + 1] = true;
            // TODO array
            if (existHelper(board, next, i + 1, j, visited) || existHelper(board, next, i - 1, j, visited)
                    || existHelper(board, next, i, j + 1, visited) || existHelper(board, next, i, j - 1, visited)) {
                return true;
            }
            visited[i + 1][j + 1] = false;
        }
        return false;
    }

    /**
     * Given a 2D board and a list of words from the dictionary, find all words in the board.

    Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

    For example,
    Given words = ["oath","pea","eat","rain"] and board =

    [
    ['o','a','a','n'],
    ['e','t','a','e'],
    ['i','h','k','r'],
    ['i','f','l','v']
    ]
    Return ["eat","oath"].
     * 
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        Trie wordTrie = new Trie();

        for (String word : words) {
            wordTrie.insert(word);
        }

        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] mask = getNewMask(n, m);
                helper(board, wordTrie, "", i, j, mask, set);
            }
        }

        List<String> ret = new LinkedList<>();
        ret.addAll(set);

        return ret;
    }

    private void helper(char[][] board, Trie wordTrie, String prev, int i, int j, boolean[][] visited, Set<String> ret) {
        if (visited[i + 1][j + 1]) {
            return;
        }
        String current = prev + board[i][j];
        if (wordTrie.startsWith(current)) {
            if (wordTrie.search(current)) {
                ret.add(current);
            }
            // continue search
            visited[i + 1][j + 1] = true;
            helper(board, wordTrie, current, i + 1, j, visited, ret);
            helper(board, wordTrie, current, i - 1, j, visited, ret);
            helper(board, wordTrie, current, i, j + 1, visited, ret);
            helper(board, wordTrie, current, i, j - 1, visited, ret);
            visited[i + 1][j + 1] = false;
        }
        // stop search
    }
}
