package com.skyline.leetcode.solution;

/**
 * Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * Created by chenliang on 2017/1/26.
 */
public class Q208 {

    public class Trie {

        public class TrieNode {

            public boolean isWord = false;

            public TrieNode[] array = new TrieNode[26];
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() <= 0) {
                return;
            }
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int arrayIndex = word.charAt(i) - 'a';
                if (curNode.array[arrayIndex] == null) {
                    curNode.array[arrayIndex] = new TrieNode();
                }
                curNode = curNode.array[arrayIndex];
            }
            curNode.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() <= 0) {
                return false;
            }
            TrieNode curNode = root;
            for (int i = 0; i < word.length(); i++) {
                int arrayIndex = word.charAt(i) - 'a';
                if (curNode.array[arrayIndex] == null) {
                    return false;
                } else {
                    curNode = curNode.array[arrayIndex];
                }
            }
            return curNode.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() <= 0) {
                return true;
            }
            TrieNode curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                int arrayIndex = prefix.charAt(i) - 'a';
                if (curNode.array[arrayIndex] == null) {
                    return false;
                } else {
                    curNode = curNode.array[arrayIndex];
                }
            }
            return true;
        }
    }

}
