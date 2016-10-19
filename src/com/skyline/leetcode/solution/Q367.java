package com.skyline.leetcode.solution;

/**
 * Valid Perfect Square
 * 
 * https://leetcode.com/problems/valid-perfect-square/
 * 
 * @author jairus
 *
 */
public class Q367 {
	
	public boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1) {
			return true;
		}
		for (int i = num / 2; i > 1; i--) {
			if (i * i == num) {
				return true;
			}
		}
		return false;
	}

	public static void main(String... strings) {
		System.out.println(new Q367().isPerfectSquare(Integer.MAX_VALUE));
	}
}
