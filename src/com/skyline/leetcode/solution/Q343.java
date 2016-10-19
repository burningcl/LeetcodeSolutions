package com.skyline.leetcode.solution;

/**
 * Integer Break
 * 
 * https://leetcode.com/problems/integer-break/
 * 
 * @author jairus
 *
 */
public class Q343 {

	int[] cache = new int[59];

	public int integerBreak(int n) {
		if (n <= 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		}
		if (cache[n] > 0) {
			return cache[n];
		}
		int mid = n / 2;
		int max = 0;
		for (int i = 2; i <= mid; i++) {
			int b1 = integerBreak(i);
			if (b1 < i) {
				b1 = i;
			}
			int b2 = integerBreak(n - i);
			if (b2 < n - i) {
				b2 = n - i;
			}
			int cm = b1 * b2;
			if (cm > max) {
				max = cm;
			}
		}
		cache[n] = max;
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Q343().integerBreak(40));
	}

}
