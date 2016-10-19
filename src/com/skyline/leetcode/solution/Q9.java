package com.skyline.leetcode.solution;

/**
 * Palindrome Number
 * 
 * https://leetcode.com/problems/palindrome-number/
 * 
 * @author jairus
 * 
 *
 */
public class Q9 {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int y = 0;
		int z = x;
		while (z > 0) {
			y = y * 10 + z % 10;
			z /= 10;
		}
		return x == y;
	}

	public static void main(String... strings) {
		System.out.println(new Q9().isPalindrome(121));
	}
}
