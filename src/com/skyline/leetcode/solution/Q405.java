package com.skyline.leetcode.solution;

/**
 * Convert a Number to Hexadecimal
 * 
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * 
 * @author jairus
 *
 */
public class Q405 {

	public String toHex(int num) {
		long n = num;
		if (num < 0) {
			n = ((long) Integer.MAX_VALUE + 1) * 2 + num;
		} else if (num == 0) {
			return "0";
		}
		String s = "";
		while (n > 0) {
			int val = (int) (n % 16);
			n /= 16;
			if (val < 10) {
				s = val + s;
			} else {
				s = (char) ('a' + val - 10) + s;
			}
		}
		return s;
	}

	public static void main(String[] args) {
		Q405 q = new Q405();
		System.out.println(q.toHex(2147483647).equals("7fffffff"));
		System.out.println(q.toHex(2147483646).equals("7ffffffe"));
		System.out.println(q.toHex(-2147483648).equals("80000000"));
		System.out.println(q.toHex(-2147483647).equals("80000001"));
		System.out.println(q.toHex(0).equals("0"));
		System.out.println(q.toHex(1).equals("1"));
		System.out.println(q.toHex(-1).equals("ffffffff"));
		System.out.println(q.toHex(15).equals("f"));
	}

}
