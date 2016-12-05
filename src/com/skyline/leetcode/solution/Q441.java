package com.skyline.leetcode.solution;

/**
 * Arranging Coins
 * 
 * https://leetcode.com/problems/arranging-coins/
 * 
 * @author jairus
 *
 */
public class Q441 {

	public int arrangeCoins(int n) {
		if (n <= 0) {
			return 0;
		}
		long nl = n;
		return (int) (Math.sqrt(nl * 8 + 1) - 1) / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
