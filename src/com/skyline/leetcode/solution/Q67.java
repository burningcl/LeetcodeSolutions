package com.skyline.leetcode.solution;

/**
 * Add Binary
 * 
 * https://leetcode.com/problems/add-binary/
 * 
 * @author jairus
 *
 */
public class Q67 {

	private int val(String s, int index) {
		index = s.length() - 1 - index;
		if (index < 0) {
			return 0;
		}
		return s.charAt(index) - '0';
	}

	public String addBinary(String a, String b) {
		if (a == null || a.length() <= 0) {
			return b;
		} else if (b == null || b.length() <= 0) {
			return a;
		}
		int len = a.length() > b.length() ? a.length() : b.length();
		boolean[] array = new boolean[len];
		int add = 0;
		for (int i = 0; i < len; i++) {
			int val = val(a, i) + val(b, i) + add;
			add = val / 2;
			val = val % 2;
			array[len - 1 - i] = val == 1;
		}
		StringBuilder sb = new StringBuilder();
		int total = 1;
		while (add / total > 0) {
			total = total << 1;
		}
		while (total > 1) {
			total = total >> 1;
			sb.append(add / total);
			add = add % total;
		}
		for (int i = 0; i < len; i++) {
			sb.append(array[i] ? 1 : 0);
		}
		return sb.toString();
	}

	public static void main(String... strings) {
		Q67 q = new Q67();
		System.out.println(q.addBinary("1", "0"));
		System.out.println(q.addBinary("1", "1"));
		System.out.println(q.addBinary("10", "1"));
		System.out.println(q.addBinary("11", "1"));
		System.out.println(q.addBinary("11", "10"));
		System.out.println(q.addBinary("11", "11"));
		System.out.println(q.addBinary("1111", "1111"));
	}
}
