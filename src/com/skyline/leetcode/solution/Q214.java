package com.skyline.leetcode.solution;

/**
 * Shortest Palindrome
 * https://leetcode.com/problems/shortest-palindrome/
 * <p>
 * Created by chenliang on 2017/1/11.
 */
public class Q214 {

//    public String shortestPalindrome(String s) {
//        if (s == null || s.length() <= 1) {
//            return s;
//        }
//        char[] cs = s.toCharArray();
//        int high = cs.length - 1;
//        while (!isPalindrome(cs, 0, high)) {
//            high--;
//        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = cs.length - 1; i > high; i--) {
//            sb.append(cs[i]);
//        }
//        sb.append(cs);
//        return sb.toString();
//    }
//
//    public boolean isPalindrome(char[] cs, int low, int high) {
//        while (low < high) {
//            if (cs[low++] != cs[high--]) {
//                return false;
//            }
//        }
//        return true;
//    }


    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] cs = s.toCharArray();
        char[] target = s.toCharArray();
        int low = 0;
        int high = cs.length - 1;
        while (low < high) {
            char t = cs[low];
            cs[low] = cs[high];
            cs[high] = t;
            low++;
            high--;
        }

        int[] next = new int[target.length];
        int curLen = 0;
        for (int i = 1; i < target.length; i++) {
            while (curLen > 0 && target[i] != target[curLen]) {
                curLen = next[curLen - 1];
            }
            if (target[i] == target[curLen]) {
                curLen++;
            }
            next[i] = curLen;
        }

        /**
         *  for (int i = 1; i < cs.length; i++) {
         if (cs[i] == cs[next[i - 1]]) {
         next[i] = next[i - 1] + 1;
         }
         }
         */

        int maxLen = 0;
        for (int i = 0, j = 0; i < cs.length; i++) {
            while (j > 0 && target[j] != cs[i]) {
                j = next[j - 1];
            }
            if (cs[i] == target[j]) {
                j++;
                if (j > maxLen) {
                    maxLen = j;
                }
            }
        }

       // System.out.println(maxLen);

        StringBuilder sb = new StringBuilder();
        for (int i = target.length - 1; i >= maxLen; i--) {
            sb.append(target[i]);
        }
        sb.append(target);
        return sb.toString();
    }

    public static void main(String... strings) {
        Q214 q = new Q214();
        System.out.println(q.shortestPalindrome("babbbabbaba").equals("ababbabbbabbaba"));
        System.out.println(q.shortestPalindrome("ababbbabbaba"));
    }
}
