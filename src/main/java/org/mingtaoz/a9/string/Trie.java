package org.mingtaoz.a9.string;

import java.util.HashMap;
import java.util.Map;

public class Trie {
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
