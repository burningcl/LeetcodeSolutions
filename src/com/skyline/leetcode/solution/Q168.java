package com.skyline.leetcode.solution;

/**
 * Excel Sheet Column Title
 * 
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * 
 * @author jairus
 * 
 */
public class Q168 {

	public String convertToTitle(int n) {
		if (n <= 0) {
			return "";
		}
		n--;
		String str = "";
		while (n >= 0) {
			int v = n % 26;
			str = (char) (v + 'A') + str;
			n = n / 26;
			n--;
		}
		return str;
	}

	/*
	 * 1 A 26 Z 27 AA 28 AB 52 AZ 1000 NTP 100 CV
	 */

	public static void main(String... strings) {
		Q168 q = new Q168();
		System.out.println(q.convertToTitle(1));
		System.out.println(q.convertToTitle(26));
		System.out.println(q.convertToTitle(27));
		System.out.println(q.convertToTitle(28));
		System.out.println(q.convertToTitle(100));
		System.out.println(q.convertToTitle(10000));
	}

}
