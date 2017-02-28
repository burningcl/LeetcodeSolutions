package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Palindrome Permutation II
 * https://leetcode.com/problems/palindrome-permutation-ii/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q267 {


//    public List<String> generatePalindromes(String s) {
//        List<String> list = new ArrayList<>();
//        if (s.length() <= 1) {
//            list.add(s);
//            return list;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            int cnt = map.getOrDefault(c, 0);
//            map.put(c, cnt + 1);
//        }
//        boolean allowOddChar = s.length() % 2 == 0 ? false : true;
//        char oddChar = ' ';
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() % 2 == 1) {
//                if (allowOddChar) {
//                    allowOddChar = false;
//                } else {
//                    return list;
//                }
//                oddChar = entry.getKey();
//                map.put(oddChar, entry.getValue() - 1);
//            }
//        }
//        this.generatePalindromes(new StringBuilder(), map, oddChar, list);
//        return list;
//    }
//
//    public void generatePalindromes(StringBuilder sb, Map<Character, Integer> map, char oddChar, List<String> list) {
//        boolean isLast = true;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() >= 2) {
//                isLast = false;
//                char c = entry.getKey();
//                int cnt = entry.getValue();
//                map.put(c, cnt - 2);
//                sb.append(c);
//                this.generatePalindromes(sb, map, oddChar, list);
//                sb.setLength(sb.length() - 1);
//                map.put(c, cnt );
//            }
//        }
//
//        if (isLast) {
//            StringBuilder s = new StringBuilder();
//            s.append(sb);
//            if (oddChar != ' ') {
//                s.append(oddChar);
//            }
//            s.append(sb.reverse());
//            sb.reverse();
//            list.add(s.toString());
//            return;
//        }
//    }

    public List<String> generatePalindromes(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() <= 1) {
            list.add(s);
            return list;
        }
        int[] cnts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i)]++;
        }
        boolean allowOddChar = s.length() % 2 == 0 ? false : true;
        char oddChar = ' ';
        for (int i = 0; i < 128; i++) {
            if (cnts[i] % 2 == 1) {
                if (allowOddChar) {
                    allowOddChar = false;
                } else {
                    return list;
                }
                oddChar = (char) i;
                cnts[i]--;
            }
        }
        this.generatePalindromes(new StringBuilder(), cnts, oddChar, list);
        return list;
    }

    public void generatePalindromes(StringBuilder sb, int[] cnts, char oddChar, List<String> list) {
        boolean isLast = true;
        for (int i = 0; i < 128; i++) {
            if (cnts[i] >= 2) {
                isLast = false;
                char c = (char) i;
                cnts[i] -= 2;
                sb.append(c);
                this.generatePalindromes(sb, cnts, oddChar, list);
                sb.setLength(sb.length() - 1);
                cnts[i] += 2;
            }
        }

        if (isLast) {
            StringBuilder s = new StringBuilder();
            s.append(sb);
            if (oddChar != ' ') {
                s.append(oddChar);
            }
            s.append(sb.reverse());
            sb.reverse();
            list.add(s.toString());
            return;
        }
    }

}
