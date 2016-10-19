package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Reverse Words in a String
 * 
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * @author jairus
 *
 */
public class Q151 {

	public String reverseWords(String s) {
		if (s == null) {
			return s;
		}
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (flag) {
				if (c == ' ') {
					flag = false;
				}
				sb.append(c);
			} else {
				if (c != ' ') {
					flag = true;
					sb.append(c);
				}
			}
		}
		s=sb.toString();

		Stack<String> stack = new Stack<>();
		String[] ss = s.split(" ");
		for (String s1 : ss) {
			stack.push(s1);
		}
		sb = new StringBuilder();
		while (!stack.isEmpty()) {
			String s1 = stack.pop();
			sb.append(s1);
			if (!stack.isEmpty()) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String... strings) {
		Q151 q = new Q151();
		System.out.println(q.reverseWords("the sky is blue"));
		System.out.println(q.reverseWords("the sky is blue "));
		System.out.println(q.reverseWords(" the sky is    blue"));
	}
}