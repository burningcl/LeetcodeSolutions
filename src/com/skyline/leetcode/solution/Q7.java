package com.skyline.leetcode.solution;

/**
 * Reverse Integer
 * 
 * https://leetcode.com/problems/reverse-integer/
 * 
 * @author jairus
 *
 */
public class Q7 {
	public int reverse(int x) {
		boolean positive = true;
		if (x < 0) {
			x = -x;
			positive = false;
		}
		long y = 0;
		while (x > 0) {
			y = y * 10 + x % 10;
			// System.out.println(y);
			x /= 10;
		}
		long val = positive ? y : -y;
		int iVal = (int) val;
		if (val == iVal) {
			return iVal;
		} else {
			return 0;
		}
	}

	public static void main(String... strings) {
		Q7 q = new Q7();
		System.out.println(q.reverse(0));
		System.out.println(q.reverse(123));
		System.out.println(q.reverse(-123));
		System.out.println(q.reverse(1534236469));
	}
}
