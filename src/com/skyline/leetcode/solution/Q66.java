package com.skyline.leetcode.solution;

/**
 * Plus One
 * 
 * https://leetcode.com/problems/plus-one/
 * 
 * @author jairus
 *
 */
public class Q66 {
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length <= 0) {
			throw new AssertionError();
		}
		boolean add = true;
		for (int i = digits.length - 1; i >= 0 && add; i--) {
			if (digits[i] < 0 || digits[i] > 9) {
				throw new AssertionError();
			} else if (digits[i] < 9) {
				digits[i] += 1;
				add = false;
			} else {
				digits[i] = 0;
				add = true;
			}
		}
		if (!add) {
			return digits;
		}
		int[] ret = new int[digits.length + 1];
		ret[0] = 1;
		return ret;
	}
}
