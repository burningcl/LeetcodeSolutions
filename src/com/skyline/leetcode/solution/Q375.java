package com.skyline.leetcode.solution;

/**
 * Guess Number Higher or Lower II
 * 
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 * 
 * @author jairus
 *
 */
public class Q375 {

	private int[][] cache = new int[1024][1024];

	private int getMoneyAmount(int left, int right) {
		if (left >= right) {
			return 0;
		}

		if (cache[left][right] > 0) {
			return cache[left][right];
		}

		int min = Integer.MAX_VALUE;
		for (int i = right; i >= left; i--) {
			int leftT = getMoneyAmount(left, i - 1);
			int rightT = getMoneyAmount(i + 1, right);
			int t = i + (leftT > rightT ? leftT : rightT);
			if (t < min) {
				min = t;
			}
		}
		cache[left][right] = min;
		return min;
	}

	public int getMoneyAmount(int n) {
		return getMoneyAmount(1, n);
	}

	public static void main(String... strings) {
		Q375 q = new Q375();
		System.out.println(q.getMoneyAmount(1023));
	}
}
