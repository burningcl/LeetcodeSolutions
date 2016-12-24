package com.skyline.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Best Time to Buy and Sell Stock IV
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 
 * 
 * @author jairus
 *
 */
public class Q188 {

	// public int maxProfit(int k, int[] prices) {
	// if (k <= 0 || prices == null || prices.length <= 0) {
	// return 0;
	// }
	// Queue<Integer> queue = new PriorityQueue<Integer>(k, new
	// Comparator<Integer>() {
	//
	// @Override
	// public int compare(Integer o1, Integer o2) {
	// return o2 - o1;
	// }
	//
	// });
	// int buyIndex = 0;
	// for (int i = 1; i <= prices.length; i++) {
	// if (i == prices.length || prices[i] < prices[i - 1]) {
	// queue.add(prices[i - 1] - prices[buyIndex]);
	// buyIndex = i;
	// }
	// }
	// int sum = 0;
	// int cnt = 0;
	// while (!queue.isEmpty() && cnt++ < k) {
	// sum += queue.poll();
	// }
	// return sum;
	// }

	// public int maxProfit(int k, int[] prices) {
	// if (k <= 0 || prices == null || prices.length <= 0) {
	// return 0;
	// }
	// int len = prices.length;
	// k = Math.min(k, len / 2);
	// int[][] dp0 = new int[len][len];
	// int[][] dp = new int[2][len];
	//
	// for (int i = 0; i < len; i++) {
	// int buyIndex = i;
	// int v = 0;
	// for (int j = i + 1; j < len; j++) {
	// if (prices[j] < prices[j - 1]) {
	// if (prices[j] < prices[buyIndex]) {
	// buyIndex = j;
	// }
	// } else {
	// v = Math.max(prices[j] - prices[buyIndex], v);
	// }
	// dp0[i][j] = v;
	// }
	// dp[0][i] = dp0[i][len - 1];
	// }
	//
	// if (k == 1) {
	// return dp[0][0];
	// }
	//
	// for (int i = 1; i < k; i++) {
	// for (int m = 0; m < len; m++) {
	// int v = 0;
	// for (int n = m + 1; n < len; n++) {
	// v = Math.max(v, dp0[m][n] + dp[0][n]);
	// }
	// dp[1][m] = v;
	// int[] dpt = dp[0];
	// dp[0] = dp[1];
	// dp[1] = dpt;
	// }
	// }
	//
	// return dp[0][0];
	// }

	public int maxProfit(int k, int[] prices) {
		if (k <= 0 || prices == null || prices.length <= 0) {
			return 0;
		}
		int len = prices.length;
		k = Math.min(k, len / 2);
		int[][] dp = new int[2][len];

		int v = 0;
		int sellIndex = len - 1;
		for (int i = len - 2; i >= 0; i--) {
			v = Math.max(v, prices[sellIndex] - prices[i]);
			dp[0][i] = v;
			if (prices[i] > prices[sellIndex]) {
				sellIndex = i;
			}
			System.out.print(v+" ");
		}
		System.out.println();

		for (int i = 1; i < k; i++) {
			sellIndex = len - 1;
			v = 0;
			for (int j = len - 2; j >= 0; j--) {
				v = Math.max(v, prices[sellIndex] - prices[j] + dp[0][sellIndex]);
				dp[1][j] = v;
				if (prices[j] > prices[j + 1]) {
					sellIndex = j;
				}
				System.out.print(v+" ");
			}
			System.out.println();
			int[] dpt = dp[0];
			dp[0] = dp[1];
			dp[1] = dpt;
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		Q188 q = new Q188();
		int[] prices = { 1, 2, 3, 1, 5, 1, 8 };
		System.out.println(q.maxProfit(2, prices));

		int[] p2 = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };
		System.out.println(q.maxProfit(2, p2));

		int[] p3 = { 1, 2 };
		System.out.println(q.maxProfit(2, p3));

	}

}
