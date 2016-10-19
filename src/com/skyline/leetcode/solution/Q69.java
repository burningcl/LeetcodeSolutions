package com.skyline.leetcode.solution;

/**
 * Sqrt(x)
 * 
 * https://leetcode.com/problems/sqrtx/
 * 
 * @author jairus
 *
 */
public class Q69 {

	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int half = x >> 1;
		long sq = 0;
		while (half >= sq && sq * sq <= x) {
			sq++;
		}
		return (int) (sq - 1);
	}

	public static void main(String[] args) {
		Q69 q = new Q69();
		System.out.println(q.mySqrt(100));
		System.out.println(q.mySqrt(2147395600));

	}

}
