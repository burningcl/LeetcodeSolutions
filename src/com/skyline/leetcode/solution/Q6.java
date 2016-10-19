package com.skyline.leetcode.solution;

/**
 * ZigZag Conversion
 * 
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * @author jairus
 *
 */
public class Q6 {

	public String convert(String s, int numRows) {
		if (s == null || numRows <= 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int column = 0;
		int row = 0;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {

			System.out.println(index);
			sb.append(s.charAt(index));
			if (row == 0 || row == numRows - 1) {
				index += (numRows - 1) * 2;
			} else if (column % 2 == 0) {
				index += (numRows - 1 - row) * 2;
			} else {
				index += row * 2;
			}
			column++;
			if (index >= s.length()) {
				column = 0;
				index = ++row;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Q6 q = new Q6();
		System.out.println(q.convert("ABCDEFGHIJK", 4));
	}

}
