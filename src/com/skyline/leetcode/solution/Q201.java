package com.skyline.leetcode.solution;

/**
 * Bitwise AND of Numbers Range
 * 
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * 
 * @author jairus
 *
 */
public class Q201 {

	public int rangeBitwiseAnd(int m, int n) {
		if (m == n) {
			return m;
		} else if (m == 0 || n == 0) {
			return 0;
		}
		int i = 31;
		int t = m > n ? m : n;
		for (; i >= 0; i--) {
			int mask = 1 << i;
			if ((t & mask) > 0) {
				break;
			}
		}
		if (i == 0) {
			return 0;
		}
		for (; i >= 0; i--) {
			int mask = 1 << i;
			if ((m & mask) != (n & mask)) {
				break;
			}
		}
		return (m >> (i + 1)) << (i + 1);
	}
	
//	public int rangeBitwiseAnd(int m, int n) {
//		int ret = 0;
//		for (int i = 31; i >= 0; i--) {
//			int mask = 1 << i;
//			int v = (m & mask);
//			if (v != (n & mask)) {
//				break;
//			} else {
//				ret = ret | v;
//			}
//		}
//		return ret;
//	}

	public static void main(String[] args) {
		Q201 q = new Q201();
		System.out.println(q.rangeBitwiseAnd(5, 7));
		System.out.println(q.rangeBitwiseAnd(0, 7));

		int n = 67655;
		int m = 67667;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(q.rangeBitwiseAnd(n, m)));
		for (int i = n; i <= m; i++) {
			n = n & i;
		}
		System.out.println(Integer.toBinaryString(n));

		System.out.println(q.rangeBitwiseAnd(3, 2));
		System.out.println(q.rangeBitwiseAnd(2, 6));
	}

}
