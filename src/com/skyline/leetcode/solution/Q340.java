package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most K Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() <= 0 || k <= 0) {
            return 0;
        } else if (s.length() <= k) {
            return s.length();
        }
        int start = 0;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt + 1);
            while (map.size() > k) {
                char sChar = s.charAt(start++);
                int sCnt = map.get(sChar);
                if (sCnt == 1) {
                    map.remove(sChar);
                } else {
                    map.put(sChar, sCnt - 1);
                }
            }
            max = Integer.max(max, i - start + 1);
        }
        return max;
    }

}
