package com.skyline.leetcode.solution;

/**
 * Sum of Two Integers
 * 
 * https://leetcode.com/problems/sum-of-two-integers/
 * 
 * @author jairus
 *
 */
public class Q371 {

	public int getSum(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getSum(a^b, (a&b)<<1);
	}

	public static void main(String... strings) {

	}

}
