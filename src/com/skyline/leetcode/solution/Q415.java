package com.skyline.leetcode.solution;

/**
 * Add Strings
 * 
 * https://leetcode.com/problems/add-strings/
 * 
 * @author jairus
 *
 */
public class Q415 {

	private int num(String s, int index) {
		return index < 0 ? 0 : s.charAt(index) - '0';
	}

	public String addStrings(String num1, String num2) {
		if (num1 == null) {
			return num2;
		} else if (num2 == null) {
			return num1;
		}

		int add = 0;
		int i1 = num1.length();
		int i2 = num2.length();
		int i3 = i1 > i2 ? i1 : i2;
		char[] num3 = new char[i3];
		while (i3-- > 0) {
			int val = num(num1, --i1) + num(num2, --i2) + add;
			add = val / 10;
			num3[i3] = (char) (val % 10 + '0');
		}
		String num3Str = String.valueOf(num3);
		if (add == 0) {
			return num3Str;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		sb.append(num3Str);
		return sb.toString();
	}

	public static void main(String[] args) {
		Q415 q = new Q415();
		System.out.println(q.addStrings("1", "2"));
		System.out.println(q.addStrings("1", "9"));
		System.out.println(q.addStrings("1", "10"));
		System.out.println(q.addStrings("99", "11"));
		System.out.println(q.addStrings("47848456561561156561516156165516", "461655151156516565465656"));
		System.out.println(q.addStrings("999999999999999999999999999", "1"));

	}

}
