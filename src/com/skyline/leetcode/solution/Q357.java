package com.skyline.leetcode.solution;

/**
 * Count Numbers with Unique Digits
 * 
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * 
 * @author jairus
 *
 */
public class Q357 {

	public int countNumbersWithUniqueDigits(int n) {
		if (n < 0 || n >= 100) {
			return 0;
		}
		int sum = 1;
		int cSum = 1;
		for (int i = 0; i < n; i++) {
			int val = 10 - i;
			val = val > 9 ? 9 : val;
			cSum *= val;
			sum += cSum;
		}
		return sum;
	}

	public static void main(String... strings) {
		System.out.println(new Q357().countNumbersWithUniqueDigits(99));
	}

}
