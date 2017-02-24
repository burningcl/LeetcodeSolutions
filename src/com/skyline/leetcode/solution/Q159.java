package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most Two Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int[] dp1 = new int[s.length()];
        dp1[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp1[i] = dp1[i - 1] + 1;
            } else {
                dp1[i] = 1;
            }
        }
        int[] dp2 = new int[s.length()];
        char c1 = ' ';
        char c2 = ' ';
        dp2[0] = 1;
        c1 = s.charAt(0);
        int start = 1;
        int max = 0;

        for (; start < s.length(); start++) {
            dp2[start] = dp2[start - 1] + 1;
            if (max < dp2[start]) {
                max = dp2[start];
            }
            if (s.charAt(start) != c1) {
                c2 = s.charAt(start);
                break;
            }
        }
        if (start >= s.length() - 1) {
            return max;
        }
        for (int i = start + 1; i < s.length(); i++) {
            if (s.charAt(i) != c1 && s.charAt(i) != c2) {
                dp2[i] = dp1[i - 1] + 1;
                c1 = s.charAt(i);
                c2 = s.charAt(i - 1);
            } else {
                dp2[i] = dp2[i - 1] + 1;
            }
            if (max < dp2[i]) {
                max = dp2[i];
            }
        }
        return max;
    }

//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        if (s == null || s.length() <= 0) {
//            return 0;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        int start = 0;
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            int cnt = map.getOrDefault(c, 0);
//            map.put(c, cnt + 1);
//            while (map.size() > 2) {
//                char cT = s.charAt(start++);
//                int cntT = map.getOrDefault(cT, 0);
//                if (cntT == 1) {
//                    map.remove(cT);
//                } else {
//                    map.put(cT, cntT - 1);
//                }
//            }
//            if (i - start + 1 > max) {
//                max = i - start + 1;
//            }
//        }
//        return max;
//    }

}
