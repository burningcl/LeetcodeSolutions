package com.skyline.leetcode.solution;

/**
 * Climbing Stairs
 * 
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * @author jairus
 *
 */
public class Q70 {

	public int climbStairs(int n) {
		int n0 = 1;
		int n1 = 1;
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				n0 = n0 + n1;
			} else {
				n1 = n0 + n1;
			}
		}
		return n % 2 == 0 ? n0 : n1;
	}
}
