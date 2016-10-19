package com.skyline.leetcode.solution;

/**
 * Pow(x, n)
 * 
 * https://leetcode.com/problems/powx-n/
 * 
 * @author jairus
 *
 */
public class Q50 {
	public double myPow(double x, int n) {
		double num = 1;
		boolean negative = false;
		if (n < 0) {
			negative = true;
			n = -n;
		}

		boolean overflow = false;
		if (n < 0) {
			n = Integer.MAX_VALUE;
			overflow = true;
		}

		int sum = 1;
		int cur = 1;
		int cacheSize = 1;
		while (sum < n) {
			cur *= 2;
			sum += cur;
			cacheSize++;
		}

		double[] cache = new double[cacheSize];
		cache[0] = x;
		int size = 1;
		for (; size < cacheSize; size++) {
			cache[size] = cache[size - 1] * cache[size - 1];
		}

		size--;
		while (n > 0) {
			int t = n - cur;
			if (t >= 0) {
				num *= cache[size];
				n = t;
				if (t == 0) {
					break;
				}
			}
			size--;
			cur /= 2;
		}
		if (overflow) {
			num *= x;
		}
		return !negative ? num : 1 / num;
	}

	public static void main(String... strings) {
		Q50 q = new Q50();
		System.out.println(q.myPow(2, 0) == Math.pow(2, 0));
		System.out.println(q.myPow(2, 1) == Math.pow(2, 1));
		System.out.println(q.myPow(-2, 2) == Math.pow(-2, 2));
		System.out.println(q.myPow(2, 20) == Math.pow(2, 20));
		System.out.println(q.myPow(1, 20) == Math.pow(1, 20));
		System.out.println(q.myPow(2.5, 30) == Math.pow(2.5, 30));
		System.out.println(q.myPow(1.1, 30));
		System.out.println(Math.pow(1.1, 30));
		System.out.println(q.myPow(1.1, 90));
		System.out.println(Math.pow(1.1, 90));
		System.out.println(q.myPow(7324, 3));
		System.out.println(Math.pow(7324, 3));
		System.out.println(q.myPow(7324, -3));
		System.out.println(Math.pow(7324, -3));
		System.out.println(q.myPow(0.00001, 2147483647));
		System.out.println(Math.pow(0.00001, 2147483647));
		System.out.println(q.myPow(2.00000, -2147483648));
		System.out.println(Math.pow(2.00000, -2147483648));
	}
}
