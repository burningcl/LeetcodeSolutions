package com.skyline.leetcode.solution;

/**
 * Best Time to Buy and Sell Stock II
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author jairus
 *
 */
public class Q122 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int sum = 0;
		int curMax = 0;
		int curMin = 0;
		int curSum = 0;
		for (int i = prices.length - 1; i >= 0; i--) {
			int p = prices[i];
			if (p < curMin) {
				curMin = p;
				curSum = curMax - p;
			} else if (p > curMin) {
				sum+=curSum;
				curMin = p;
				curSum = 0;
				curMax = p;
			}
		}
		sum+=curSum;
		return sum;
	}
}
