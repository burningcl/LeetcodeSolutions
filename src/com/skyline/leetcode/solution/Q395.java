package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Least K Repeating Characters
 * <p>
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-
 * characters/
 *
 * @author jairus
 */
public class Q395 {

//	public int longestSubstring(final String s, final int k, final int start, final int end) {
//		if (end - start + 1 < k) {
//			return 0;
//		}
//		Map<Character, Integer> map = new HashMap<>();
//		for (int i = start; i <= end; i++) {
//			char c = s.charAt(i);
//			Integer cnt = map.get(c);
//			if (cnt == null) {
//				map.put(c, 1);
//			} else {
//				map.put(c, cnt + 1);
//			}
//		}
//		boolean started = false;
//		int startI = 0;
//		int max = 0;
//		boolean match = true;
//		for (int i = start; i <= end; i++) {
//			char c = s.charAt(i);
//			if (map.get(c) < k || i == end) {
//				if (started) {
//					started = false;
//					int endI = map.get(c) < k ? i - 1 : i;
//					int len = startI != start || endI != end ? longestSubstring(s, k, startI, endI) : end - start + 1;
//					if (len > max) {
//						max = len;
//					}
//				}
//				match = false;
//			} else {
//				if (!started) {
//					startI = i;
//					started = true;
//				}
//			}
//		}
//		return match ? end - start + 1 : max;
//	}
//
//	public int longestSubstring(String s, int k) {
//		if (s == null || s.length() < k || k <= 0) {
//			return 0;
//		} else if (k == 1) {
//			return s.length();
//		}
//
//		return longestSubstring(s, k, 0, s.length() - 1);
//	}

    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k || k <= 0) {
            return 0;
        } else if (k == 1) {
            return s.length();
        }
        return this.longestSubstring(s, k, 0, s.length() - 1);
    }

    public int longestSubstring(String s, int k, int start, int end) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] charCnts = new int[26];
        for (int i = start; i <= end; i++) {
            charCnts[s.charAt(i) - 'a']++;
        }
        boolean match = true;
        for (int i = 0; i < 26; i++) {
            if (charCnts[i] != 0 && charCnts[i] < k) {
                match = false;
                break;
            }
        }
        if (match) {
            return end - start + 1;
        }

        int curStart = start;
        int max = 0;
        for (int i = start; i <= end + 1; i++) {
            if (i > end || charCnts[s.charAt(i) - 'a'] < k) {
                int curMax = this.longestSubstring(s, k, curStart, i - 1);
                if (curMax > max) {
                    max = curMax;
                }
                curStart = i + 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q395 q = new Q395();
        System.out.println(q.longestSubstring("bbaaa", 3));
        System.out.println(q.longestSubstring("aaabbb", 1) == 6);
        System.out.println(q.longestSubstring("aaabbb", 2) == 6);
        System.out.println(q.longestSubstring("aaabbb", 3) == 6);
        System.out.println(q.longestSubstring("aababb", 3) == 6);
        System.out.println(q.longestSubstring("aababba", 3) == 7);
        System.out.println(q.longestSubstring("aabcabb", 3) == 0);
        System.out.println(q.longestSubstring("aabacbb", 3) == 0);
        System.out.println(q.longestSubstring("baaabcb", 3) == 3);
    }

}
