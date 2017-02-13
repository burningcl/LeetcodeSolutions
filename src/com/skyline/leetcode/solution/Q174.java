package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * Dungeon Game
 * https://leetcode.com/problems/dungeon-game/
 * Created by chenliang on 2017/2/10.
 */
public class Q174 {

    // 第一种方式，超时
//    public int calculateMinimumHP(int[][] dungeon) {
//        n = dungeon.length - 1;
//        m = dungeon[0].length - 1;
//        this.calculateMinimumHP(dungeon, 0, 0);
//        return Integer.max(1, 1 - min);
//    }
//
//    int min = Integer.MIN_VALUE;
//
//    ArrayDeque<Integer> curMin = new ArrayDeque<>();
//
//    int curSum = 0;
//
//    int n = 0;
//
//    int m = 0;
//
//    public void calculateMinimumHP(int[][] dungeon, int i, int j) {
//        if (curSum <= min) {
//            return;
//        }
//        curSum += dungeon[i][j];
//        if (curMin.isEmpty())
//            curMin.push(curSum);
//        else
//            curMin.push(Integer.min(curSum, curMin.peek()));
//        if (i == n && j == m) {
//            if (curMin.peek() > min) {
//                min = curMin.peek();
//            }
//        } else {
//            if (i < n) {
//                this.calculateMinimumHP(dungeon, i + 1, j);
//            }
//            if (j < m) {
//                this.calculateMinimumHP(dungeon, i, j + 1);
//            }
//        }
//        curMin.pop();
//        curSum -= dungeon[i][j];
//    }


    //第二种，不够优秀
//    public int calculateMinimumHP(int[][] dungeon) {
//        int n = dungeon.length - 1;
//        int m = dungeon[0].length - 1;
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = n; i >= 0; i--) {
//            for (int j = m; j >= 0; j--) {
//                Integer right = j < m ? dp[i][j + 1] : null;
//                Integer bottom = i < n ? dp[i + 1][j] : null;
//                dp[i][j] = max(right, bottom) + dungeon[i][j];
//                dp[i][j] = dp[i][j] > 0 ? 0 : dp[i][j];
//            }
//        }
//        System.out.println(dp[0][0]);
//        return Integer.max(1, 1 - dp[0][0]);
//    }
//
//    public int max(Integer a, Integer b) {
//        if (a == null) {
//            return b == null ? 0 : b;
//        } else if (b == null) {
//            return a;
//        } else {
//            return Integer.max(a, b);
//        }
//    }

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length - 1;
        int m = dungeon[0].length - 1;
        int[][] dp = new int[n + 1][m + 1];
        dp[n][m] = dungeon[n][m] > 0 ? 0 : dungeon[n][m];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = Integer.min(dp[i + 1][m] + dungeon[i][m], 0);
        }
        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = Integer.min(dp[n][j + 1] + dungeon[n][j], 0);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = Integer.min(Integer.max(dp[i][j + 1], dp[i + 1][j]) + dungeon[i][j], 0);
            }
        }
      //  System.out.println(dp[0][0]);
        return Integer.max(1, 1 - dp[0][0]);
    }


}
