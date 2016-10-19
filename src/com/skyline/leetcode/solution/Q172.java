package com.skyline.leetcode.solution;

/**
 * Factorial Trailing Zeroes
 * 
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * 
 * @author jairus
 *
 */
public class Q172 {

	public int trailingZeroes(int n) {
		int cnt = n / 5;
		if (cnt <= 0) {
			return 0;
		}
		return cnt + this.trailingZeroes(cnt);
	}

	public static void main(String...strings){
		Q172 q=new Q172();
		System.out.println(q.trailingZeroes(10));
		System.out.println(q.trailingZeroes(25));
		System.out.println(q.trailingZeroes(125));
	}
}
