package com.skyline.leetcode.solution;

/**
 * Roman to Integer
 * 
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * @author jairus
 *
 */
public class Q13 {
	public int romanToInt(String s) {

		if (s == null || s.length() <= 0) {
			return 0;
		}
		int sum = 0;

		char[] cs = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] vs = { 1, 5, 10, 50, 100, 500, 1000 };
		int formerJ = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int j = 0;
			for (; j < cs.length; j++) {
				if (cs[j] == c) {
					break;
				}
			}
			if (j >= cs.length) {
				return 0;
			}
			if (formerJ < j) {
				sum += vs[j] - 2 * vs[formerJ];
			} else {
				sum += vs[j];
			}
			formerJ = j;
		}
		return sum;
	}

	public static void main(String... strings) {
		Q12 q = new Q12();
		Q13 q13 = new Q13();
		for (int i = 1; i <= 3999; i++) {
			if (i != q13.romanToInt(q.intToRoman(i)))
				System.out.println(i + "\t" + q13.romanToInt(q.intToRoman(i)));
		}
	}
}
