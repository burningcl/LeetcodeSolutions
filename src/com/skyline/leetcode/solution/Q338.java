package com.skyline.leetcode.solution;

/**
 * Counting Bits
 * 
 * https://leetcode.com/problems/counting-bits/
 * 
 * @author jairus
 *
 */
public class Q338 {
	public int[] countBits(int num) {
		int[] ret = new int[num + 1];

		for (int i = 1; i <= num; i++) {
			if (i == 2) {
				ret[i] = 1;
			} else if (i % 2 == 0) {
				ret[i] = ret[i >> 1];
			} else {
				ret[i] = ret[i - 1] + 1;
			}
		}
		return ret;
	}
}
