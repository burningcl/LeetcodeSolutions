
package com.skyline.leetcode.solution;

/**
 * String to Integer (atoi)
 * 
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * @author jairus
 *
 */
public class Q8 {
	public int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() <= 0) {
			return 0;
		}
		char[] cs = str.toCharArray();
		boolean positive = true;
		int i = 0;
		if (cs[0] == '-') {
			positive = false;
			i = 1;
		} else if (cs[0] == '+') {
			positive = true;
			i = 1;
		}
		int num = 0;
		for (; i < cs.length; i++) {
			if (cs[i] < '0' || cs[i] > '9') {
				return num;
			}
			int fNum = num;
			if (positive) {
				num = num * 10 + (cs[i] - '0');
				if (num / 10 != fNum) {
					return Integer.MAX_VALUE;
				}
			} else {
				num = num * 10 - (cs[i] - '0');
				if (num / 10 != fNum) {
					return Integer.MIN_VALUE;
				}
			}
		}
		return num;
	}

	public static void main(String... strings) {
	}
}
