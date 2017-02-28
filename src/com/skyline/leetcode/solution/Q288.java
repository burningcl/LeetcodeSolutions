package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Unique Word Abbreviation
 * https://leetcode.com/problems/unique-word-abbreviation/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q288 {

//    public class ValidWordAbbr {
//
//        Map<String, Integer> map;
//
//        Set<String> set;
//
//        public ValidWordAbbr(String[] dictionary) {
//            map = new HashMap<>();
//            set = new HashSet<>();
//            if (dictionary == null || dictionary.length <= 0) {
//                return;
//            }
//            for (int i = 0; i < dictionary.length; i++) {
//                String word = dictionary[i];
//                if (set.contains(word)) {
//                    continue;
//                }
//                String key = this.toKey(word);
//                int cnt = map.getOrDefault(key, 0);
//                map.put(key, cnt + 1);
//                set.add(word);
//            }
//        }
//
//        private String toKey(String word) {
//            if (word.length() <= 2) {
//                return word;
//            }
//            char firstChar = word.charAt(0);
//            char lastChar = word.charAt(word.length() - 1);
//            return new StringBuilder().append(firstChar).append(word.length() - 2).append(lastChar).toString();
//        }
//
//        public boolean isUnique(String word) {
//            String key = this.toKey(word);
//            int cnt = map.getOrDefault(key, 0);
//            if (cnt == 0) {
//                return true;
//            } else if (cnt >= 2) {
//                return false;
//            } else {
//                return set.contains(word);
//            }
//        }
//    }

    public class ValidWordAbbr {

        int[][][] map;

        Set<String> set;

        public ValidWordAbbr(String[] dictionary) {
            map = new int[128][128][128];
            set = new HashSet<>();
            if (dictionary == null || dictionary.length <= 0) {
                return;
            }
            for (int i = 0; i < dictionary.length; i++) {
                String word = dictionary[i];
                if (set.contains(word) || word == null || word.length() <= 0) {
                    continue;
                }
                char firstChar = word.charAt(0);
                char lastChar = word.charAt(word.length() - 1);
                int len = word.length();
                map[firstChar][lastChar][len]++;
                set.add(word);
            }
        }

        public boolean isUnique(String word) {
            if (word == null || word.length() <= 0) {
                return true;
            }
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            int len = word.length();
            int cnt = map[firstChar][lastChar][len];
            if (cnt == 0) {
                return true;
            } else if (cnt >= 2) {
                return false;
            } else {
                return set.contains(word);
            }
        }
    }

}
