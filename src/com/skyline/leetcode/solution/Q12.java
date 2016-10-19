package com.skyline.leetcode.solution;

/**
 * Integer to Roman
 * 
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * 
 * @author jairus
 *
 */
public class Q12 {
	
	char[][] c = { { 'I', 'V', 'X' }, { 'X', 'L', 'C' }, { 'C', 'D', 'M' }, { 'M', '-', '-' } };

	public String intToRoman(int num, int zeroCnt) {
		if (num == 0) {
			return null;
		}
		StringBuilder s = new StringBuilder();
		if (num >= 1 && num <= 3) {
			for (int i = 0; i < num; i++) {
				s.append(c[zeroCnt][0]);
			}
		} else if (num == 4) {
			s.append(c[zeroCnt][0]);
			s.append(c[zeroCnt][1]);
		} else if (num <= 8) {
			s.append(c[zeroCnt][1]);
			for (int i = 0; i < num - 5; i++) {
				s.append(c[zeroCnt][0]);
			}
		} else if (num == 9) {
			s.append(c[zeroCnt][0]);
			s.append(c[zeroCnt][2]);
		}
		return s.toString();
	}

	public String intToRoman(int num) {
		String s = "";
		int zeroCnt = 0;
		while (num > 0) {
			int n = num % 10;
			String ss = intToRoman(n, zeroCnt);
			if (ss != null)
				s = ss + s;
			zeroCnt++;
			num = num / 10;
		}
		return s;
	}

	public static void main(String... strings) {
		Q12 q = new Q12();
		for (int i = 1; i <= 3999; i++) {
			System.out.println(i + "\t" + q.intToRoman(i));
		}
	}
}
