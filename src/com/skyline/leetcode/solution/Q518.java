package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Coin Change 2
 * https://leetcode.com/problems/coin-change-2/?tab=Description
 * Created by chenliang on 2017/2/18.
 */
public class Q518 {
//    public int change(int amount, int[] coins) {
//        if (amount <= 0) {
//            return 1;
//        } else if (coins == null || coins.length <= 0) {
//            return 0;
//        }
//        Arrays.sort(coins);
//        int[][] cache = new int[amount + 1][coins.length];
//        for (int i = 0; i <= amount; i++) {
//            Arrays.fill(cache[i], -1);
//        }
//        return this.change(amount, coins, coins.length - 1, cache);
//    }
//
//    public int change(int amount, int[] coins, int maxIndex, int[][] cache) {
//        if (amount == 0) {
//            return 1;
//        } else if (maxIndex == 0) {
//            return amount % coins[0] == 0 ? 1 : 0;
//        } else if (cache[amount][maxIndex] >= 0) {
//            return cache[amount][maxIndex];
//        }
//        int coin = coins[maxIndex];
//        int len = amount / coin;
//        int total = 0;
//        for (int i = 0; i <= len; i++) {
//            total += this.change(amount - i * coin, coins, maxIndex - 1, cache);
//        }
//        return cache[amount][maxIndex] = total;
//    }

    public int change(int amount, int[] coins) {
        if (amount <= 0) {
            return 1;
        } else if (coins == null || coins.length <= 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0, len = coins.length; j < len; j++) {
            int coin = coins[j];
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];

    }
}
