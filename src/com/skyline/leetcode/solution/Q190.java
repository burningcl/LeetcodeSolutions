package com.skyline.leetcode.solution;

/**
 * Reverse Bits
 * 
 * https://leetcode.com/problems/reverse-bits/
 * 
 * @author jairus
 *
 */
public class Q190 {

	public int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			int j = 31 - i;
			int mask1 = 1 << i;
			int mask2 = 1 << j;
			boolean v1 = (n & mask1) == 0 ? false : true;
			boolean v2 = (n & mask2) == 0 ? false : true;
			if (v1 != v2) {
				if (v1) {
					n = n ^ mask1;
					n = n | mask2;
				} else {
					n = n | mask1;
					n = n ^ mask2;
				}
			}
		}
		return n;
	}

	public static void main(String[] args) {
		Q190 q = new Q190();
		System.out.println(q.reverseBits(Integer.MAX_VALUE));

	}

}
