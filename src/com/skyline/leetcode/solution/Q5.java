package com.skyline.leetcode.solution;

/**
 * Longest Palindromic Substring
 * <p>
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author jairus
 */
public class Q5 {

//    public String longestPalindrome(String s) {
//        if (s == null || s.length() <= 1) {
//            return s;
//        }
////		int start = 0;
////		int end = 0;
////		int max = Integer.MIN_VALUE;
////		for (int i = 0; i < s.length(); i++) {
////			boolean validOdd = true;
////			boolean validEven = true;
////			for (int j = 0; (validOdd || validEven) && j <= i && i + j < s.length(); j++) {
////				if (validOdd && i + j < s.length()) {
////					if (s.charAt(i - j) == s.charAt(i + j)) {
////						if (2 * j + 1 > max) {
////							max = 2 * j + 1;
////							start = i - j;
////							end = i + j;
////						}
////					} else {
////						validOdd = false;
////					}
////				}
////				if (validEven && i + j + 1 < s.length()) {
////					if (s.charAt(i - j) == s.charAt(i + j + 1)) {
////						if (2 * j + 2 > max) {
////							max = 2 * j + 2;
////							start = i - j;
////							end = i + j + 1;
////						}
////					} else {
////						validEven = false;
////					}
////				}
////			}
////		}
////		return s.substring(start, end + 1);
//        int maxLen = 0;
//        int maxStart = 0;
//        int sLen = s.length();
//        for (int i = 0; i < sLen; i++) {
//            int len = 1;
//            int start = i - 1;
//            int end = i + 1;
//            while (start >= 0 && end < sLen && s.charAt(start) == s.charAt(end)) {
//                len += 2;
//                start--;
//                end++;
//            }
//            if (len > maxLen) {
//                maxLen = len;
//                maxStart = start + 1;
//            }
//            len = 0;
//            start = i;
//            end = i + 1;
//            while (start >= 0 && end < sLen && s.charAt(start) == s.charAt(end)) {
//                len += 2;
//                start--;
//                end++;
//            }
//            if (len > maxLen) {
//                maxLen = len;
//                maxStart = start + 1;
//            }
//        }
//        return s.substring(maxStart, maxStart + maxLen);
//    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int maxLen = 1;
        int maxStart = 0;
        int sLen = s.length();
        for (int i = 1; i < sLen; i++) {
            int len = maxLen + 2;
            int start = i - len + 1;
            if (start >= 0 && isPalindrome(s, start, i)) {
                maxLen = len;
                maxStart = start;
                continue;
            }
            len = maxLen + 1;
            start = i - len + 1;
            if (start >= 0 && isPalindrome(s, start, i)) {
                maxLen = len;
                maxStart = start;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start > end;
    }

    public static void main(String... strings) {
        Q5 q = new Q5();
        System.out.println(q.longestPalindrome("kkabcball"));
        System.out.println(q.longestPalindrome("kkabball"));
        System.out.println(q.longestPalindrome("a"));
        System.out.println(q.longestPalindrome("ab"));
        System.out.println(q.longestPalindrome("aba"));
        System.out.println(q.longestPalindrome("aa"));
        System.out.println(q.longestPalindrome("aaabaaaa"));
    }
}
