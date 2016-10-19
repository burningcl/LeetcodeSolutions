package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Coin Change
 * 
 * https://leetcode.com/problems/coin-change/
 * 
 * @author jairus
 *
 */
public class Q322 {

	int min = 0;

	int cm = 0;

	int INVALID = -1;

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length <= 0 || amount < 0) {
			return -1;
		}

		Arrays.sort(coins);

		min = INVALID;
		cm = 0;
		coinChange(coins, amount, coins.length - 1);
		return min;
	}

	private void coinChange(int[] coins, int amount, int pos) {
		//System.out.println(amount + ", " + cm);
		if (pos < 0) {
			return;
		}
		int cnt = amount / coins[pos];
		cm += cnt;
		if (cm >= min && min > 0) {
			cm -= cnt;
			return;
		}
		amount = amount % coins[pos];
		if (amount == 0) {
			if (min > cm || min < 0)
				min = cm;
			cm -= cnt;
			//System.out.println("dd");
		} else {
			int curCm = cm;
			for (int i = 0; i <= cnt; i++) {
				cm = curCm - i;
				coinChange(coins, amount + (i * coins[pos]), pos - 1);
			}
		}

	}

	public static void main(String[] args) {
		int[][][] testCases = { { { 2 }, { 5 }, { -1 } }, { { 2 }, { 0 }, { 0 } }, { { 2 }, { 2 }, { 1 } },
				{ { 1, 2, 5 }, { 11 }, { 3 } }, };
		Q322 q = new Q322();
		for (int[][] c : testCases) {
			System.out.println();
			System.out.println(q.coinChange(c[0], c[1][0]));
		}
	}

}
