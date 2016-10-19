package com.skyline.leetcode.solution;

/**
 * Best Time to Buy and Sell Stock III
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 
 * @author jairus
 *
 */
public class Q123 {

	// private int maxProfit(int[] prices, int low, int high) {
	// int maxV = Integer.MIN_VALUE;
	// int max = 0;
	// for (int i = high; i >= low; i--) {
	// int p = prices[i];
	// if (p < maxV) {
	// int v = maxV - p;
	// if (max < v) {
	// max = v;
	// }
	// } else if (p > maxV) {
	// maxV = p;
	// }
	// }
	// return max;
	// }
	//
	// public int maxProfit(int[] prices) {
	// if (prices == null || prices.length <= 1) {
	// return 0;
	// }
	// long t1=System.currentTimeMillis();
	// int n = prices.length;
	// int max = 0;
	// for (int i = 0; i < n; i++) {
	// int curMax = maxProfit(prices, 0, i) + maxProfit(prices, i, n - 1);
	// if(curMax>max){
	// max=curMax;
	// }
	// }
	// long t2=System.currentTimeMillis();
	// System.out.println(t2-t1);
	// return max;
	// }

	private int[] maxProfit(int[] prices, int low, int high) {
		int maxV = Integer.MIN_VALUE;
		int max = 0;
		int l = 0;
		int hh = 0;
		int h = 0;
		for (int i = high; i >= low; i--) {
			int p = prices[i];
			if (p < maxV) {
				int v = maxV - p;
				if (max < v) {
					max = v;
					l = i;
					h = hh;
				}
			} else if (p > maxV) {
				maxV = p;
				hh = i;
			}
		}
		int[] ret = new int[3];
		ret[2] = max;
		ret[0] = l;
		ret[1] = h;
		return ret;
	}

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
//		long t1 = System.currentTimeMillis();
		int n = prices.length;
		int max = 0;
		int low = 0;
		int high = n - 1;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				break;
			}
			low = i;
		}
		for (int i = n - 1; i > 0; i--) {
			if (prices[i - 1] < prices[i]) {
				break;
			}
			high = i;
		}
		if (low >= high) {
			return 0;
		}

//		System.out.println(prices[low] + ", " + prices[high]);
		int[] retL = null;
		int[] retR = null;
		for (int i = low; i <= high; i++) {

			if (i > 0 && prices[i] == prices[i - 1]) {
				continue;
			}
			retL = maxProfit(prices, low, i);

			if (retR == null || i > retR[0]) {
				retR = maxProfit(prices, i, high);
			}

			int curMax = retL[2] + retR[2];
			if (curMax > max) {
				max = curMax;
			}
		}
//		long t2 = System.currentTimeMillis();
//		System.out.println(t2 - t1);
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
