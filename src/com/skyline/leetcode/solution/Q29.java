package com.skyline.leetcode.solution;

/**
 * Divide Two Integers
 * 
 * https://leetcode.com/problems/divide-two-integers/
 * 
 * @author jairus
 *
 */
public class Q29 {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		boolean positive = (dividend < 0 && divisor < 0) || (dividend >= 0 && divisor >= 0) ? true : false;
		dividend = dividend < 0 ? -dividend : dividend;
		divisor = divisor < 0 ? -divisor : divisor;

		int ret = 0;
		int add = 1;

		if (dividend < 0) {
			dividend = -(dividend + divisor);
			ret = 1;
		}

		while (dividend >= divisor && divisor > 0) {
			ret += add;
			dividend -= divisor;
			divisor = divisor << 1;
			add = add << 1;
		}

		while (dividend > 0 && divisor > 0) {
			if (dividend >= divisor) {
				ret += add;
				dividend -= divisor;
			}
			divisor = divisor >> 1;
			add = add >> 1;
		}

		if (ret >= 0) {
			return positive ? ret : -ret;
		} else {
			return positive? Integer.MAX_VALUE:ret;
		}
	}

	public static void main(String... strings) {
		Q29 q = new Q29();
		System.out.println(q.divide(Integer.MIN_VALUE, -1) == Integer.MAX_VALUE);
		System.out.println(q.divide(Integer.MIN_VALUE, 2) == (Integer.MIN_VALUE / 2));
		System.out.println(q.divide(Integer.MIN_VALUE, 1) == (Integer.MIN_VALUE));
		System.out.println(q.divide(0, 1) == 0);
		System.out.println(q.divide(6, 2) == 3);
		System.out.println(q.divide(7, 2) == 3);
		System.out.println(q.divide(-7, -2) == 3);
		System.out.println(q.divide(7, -2) == -3);
		System.out.println(q.divide(8, -2) == -4);
		System.out.println(q.divide(9, 3) == 3);
		System.out.println(q.divide(Integer.MAX_VALUE, 2) == (Integer.MAX_VALUE / 2));
		System.out.println(q.divide(Integer.MAX_VALUE, -2) == (Integer.MAX_VALUE / -2));
		System.out.println(q.divide(Integer.MAX_VALUE, 1) == (Integer.MAX_VALUE));
	}
}
