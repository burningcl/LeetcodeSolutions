package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Palindrome Partitioning II
 * <p>
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * <p>
 * <p>
 * Created by chenliang on 2017/1/6.
 */
public class Q132 {

//    public int minCut(String s) {
//
//        if (s == null || s.length() <= 1) {
//            return 0;
//        }
//
//        char[] cs = s.toCharArray();
//        int[] dp = new int[cs.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//
//        for (int i = 1; i < cs.length; i++) {
//            if (isPalindrome(cs, 0, i)) {
//                dp[i] = 0;
//            } else {
//                for (int j = i - 1; j >= 0; j--) {
//                    if (dp[j] + 1 < dp[i] && isPalindrome(cs, j + 1, i)) {
//                        dp[i] = dp[j] + 1;
//                        if (dp[i] == 1) {
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return dp[dp.length - 1];
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

    public int minCut(String s) {

        if (s == null || s.length() <= 1) {
            return 0;
        }

        char[] cs = s.toCharArray();
        int[] dp = new int[cs.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        boolean[][] map = new boolean[cs.length][cs.length];
        for (int i = 0; i < cs.length; i++) {
            int low = i;
            int high = i;
            while (low >= 0 && high < cs.length && cs[low] == cs[high]) {
                map[low--][high++] = true;
            }
            low = i;
            high = i + 1;
            while (low >= 0 && high < cs.length && cs[low] == cs[high]) {
                map[low--][high++] = true;
            }
        }

        for (int i = 1; i < cs.length; i++) {
            if (map[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (map[j + 1][i] && dp[j] + 1 < dp[i]) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] == 1) {
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String... strings) {
        Q132 q = new Q132();
        long t1 = System.currentTimeMillis();
        System.out.println(q.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
