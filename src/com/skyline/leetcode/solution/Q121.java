package com.skyline.leetcode.solution;

/**
 * Best Time to Buy and Sell Stock
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author jairus
 *
 */
public class Q121 {

	public int maxProfit(int[] prices) {
		int maxV = Integer.MIN_VALUE;
		int max = 0;
		if (prices == null || prices.length <= 1) {
			return max;
		}
		for (int i = prices.length - 1; i >= 0; i--) {
			int p = prices[i];
			if (p < maxV) {
				int v = maxV - p;
				if (max < v) {
					max = v;
				}
			} else if (p > maxV) {
				maxV = p;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
