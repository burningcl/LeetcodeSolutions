package com.skyline.leetcode.solution;

/**
 * Number of 1 Bits
 * 
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * @author jairus
 *
 */
public class Q191 {

	public int hammingWeight(int n) {
		int cnt = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Q191 q = new Q191();
		System.out.println(q.hammingWeight(1));
		System.out.println(q.hammingWeight(5));
		System.out.println(q.hammingWeight(7));
		System.out.println(q.hammingWeight(-9));
		System.out.println(q.hammingWeight(-100));
		System.out.println(q.hammingWeight(Integer.MIN_VALUE));
	}

}
