package com.skyline.leetcode.solution;

/**
 * Excel Sheet Column Number
 * 
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * 
 * @author jairus
 * 
 */
public class Q171 {

	public int titleToNumber(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		int ret = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			ret = ret * 26 + (c - 'A');
			ret++;
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Q171 q = new Q171();
		System.out.println(q.titleToNumber("A"));
		System.out.println(q.titleToNumber("Z"));
		System.out.println(q.titleToNumber("AA"));
		System.out.println(q.titleToNumber("AB"));
		System.out.println(q.titleToNumber("NTP"));
	}

}
