package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huasong.cl
 */
public class Q1032 {

//    class StreamChecker {
//
//        Map<Character, List<String>> wordMap;
//
//        List<CountItem> countItemList;
//
//        public StreamChecker(String[] words) {
//            wordMap = new HashMap<>();
//            for (String word : words) {
//                char c = word.charAt(0);
//                List<String> list = wordMap.get(c);
//                if (list == null) {
//                    list = new ArrayList<>();
//                    wordMap.put(c, list);
//                }
//                list.add(word);
//            }
//            countItemList = new ArrayList<>();
//        }
//
//        public boolean query(char letter) {
//            boolean found = false;
//            List<CountItem> list = new ArrayList<>();
//            for (CountItem countItem : countItemList) {
//                String word = countItem.getWord();
//                int index = countItem.getIndex();
//                if (word.charAt(index++) == letter) {
//                    if (index >= word.length()) {
//                        found = true;
//                    } else {
//                        countItem.setIndex(index);
//                        list.add(countItem);
//                    }
//                }
//            }
//            List<String> wordList = wordMap.get(letter);
//            if (wordList != null) {
//                for (String word : wordList) {
//                    if (word.length() <= 1) {
//                        found = true;
//                    } else {
//                        CountItem countItem = new CountItem();
//                        countItem.setIndex(1);
//                        countItem.setWord(word);
//                        list.add(countItem);
//                    }
//                }
//            }
//            countItemList = list;
//            return found;
//        }
//
//        private class CountItem {
//
//            String word;
//
//            int index;
//
//            public String getWord() {
//                return word;
//            }
//
//            public void setWord(String word) {
//                this.word = word;
//            }
//
//            public void setIndex(int index) {
//                this.index = index;
//            }
//
//            public int getIndex() {
//                return index;
//            }
//        }
//    }

    class StreamChecker {

        TrieNode root;

        TrieNode[] queryArray;

        int low;

        int high;

        public StreamChecker(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    int index = c - 'a';
                    if (cur.getChildren()[index] == null) {
                        cur.getChildren()[index] = new TrieNode();
                    }
                    cur = cur.getChildren()[index];
                    if (i == word.length() - 1) {
                        cur.hasChildEnd = true;
                    }
                }
            }
            queryArray = new TrieNode[2000];
            low = 0;
            high = 0;
        }

        public boolean query(char letter) {
            boolean found = false;
            int index = letter - 'a';
            TrieNode cur;
            int nHigh = high;
            if (high < low) {
                high += 2000;
            }
            for (int i = low; i < high; i++) {
                cur = queryArray[i % 2000].getChildren()[index];
                if (cur != null) {
                    queryArray[nHigh] = cur;
                    nHigh = (nHigh + 1) % 2000;
                    if (cur.isHasChildEnd()) {
                        found = true;
                    }
                }
            }
            cur = root.getChildren()[index];
            if (cur != null) {
                queryArray[nHigh] = cur;
                nHigh = (nHigh + 1) % 2000;
                if (cur.isHasChildEnd()) {
                    found = true;
                }
            }
            low = high % 2000;
            high = nHigh;
            return found;
        }

        private class TrieNode {

            TrieNode[] children = new TrieNode[26];

            boolean hasChildEnd = false;

            public TrieNode[] getChildren() {
                return children;
            }

            public void setChildren(TrieNode[] children) {
                this.children = children;
            }

            public boolean isHasChildEnd() {
                return hasChildEnd;
            }

            public void setHasChildEnd(boolean hasChildEnd) {
                this.hasChildEnd = hasChildEnd;
            }
        }
    }

}
