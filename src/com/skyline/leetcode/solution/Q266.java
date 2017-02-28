package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Palindrome Permutation
 * https://leetcode.com/problems/palindrome-permutation/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q266 {

    public boolean canPermutePalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
        }
        boolean allowOddChar = s.length() % 2 == 0 ? false : true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (allowOddChar) {
                    allowOddChar = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
