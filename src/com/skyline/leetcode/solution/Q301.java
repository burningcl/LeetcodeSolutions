package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Remove Invalid Parentheses
 * 
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * @author jairus
 *
 */
public class Q301 {
	// 第一种，打败9%
	// private int maxLen;
	//
	// private Set<String> set;
	//
	// public void removeInvalidParentheses(String s, boolean[] array, int
	// index, int len, int leftCnt) {
	// if (index >= s.length()) {
	// if (leftCnt == 0 && len >= maxLen) {
	// StringBuilder sb = new StringBuilder();
	// for (int i = 0; i < s.length(); i++) {
	// if (array[i]) {
	// sb.append(s.charAt(i));
	// }
	// }
	// String str = sb.toString();
	// if (len > maxLen) {
	// set.clear();
	// maxLen = len;
	// }
	// set.add(str);
	// }
	// return;
	// }
	// char c = s.charAt(index);
	// if (c != '(' && c != ')') {
	// array[index] = true;
	// this.removeInvalidParentheses(s, array, index + 1, len + 1, leftCnt);
	// } else if (c == '(') {
	// array[index] = true;
	// this.removeInvalidParentheses(s, array, index + 1, len + 1, leftCnt + 1);
	// } else if (leftCnt > 0) {
	// array[index] = true;
	// this.removeInvalidParentheses(s, array, index + 1, len + 1, leftCnt - 1);
	// }
	// array[index] = false;
	// this.removeInvalidParentheses(s, array, index + 1, len, leftCnt);
	// }

	// 第二种，打败52.24%
	private int maxLen;

	private Set<String> set;

	public void removeInvalidParentheses(String s, boolean[] array, int index, int len, int leftCnt) {
		if (index >= s.length()) {
			if (leftCnt == 0 && len >= maxLen) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < s.length(); i++) {
					if (array[i]) {
						sb.append(s.charAt(i));
					}
				}
				String str = sb.toString();
				if (len > maxLen) {
					set.clear();
					maxLen = len;
				}
				set.add(str);
			}
			return;
		}
		if (len + s.length() - index < maxLen) {
			return;
		}
		char c = s.charAt(index);
		if (c != '(' && c != ')') {
			array[index] = true;
			this.removeInvalidParentheses(s, array, index + 1, len + 1, leftCnt);
			return;
		} else if (c == '(') {
			array[index] = true;
			this.removeInvalidParentheses(s, array, index + 1, len + 1, leftCnt + 1);
		} else if (leftCnt > 0) {
			array[index] = true;
			this.removeInvalidParentheses(s, array, index + 1, len + 1, leftCnt - 1);
		}
		array[index] = false;
		this.removeInvalidParentheses(s, array, index + 1, len, leftCnt);
	}

	public List<String> removeInvalidParentheses(String s) {
		maxLen = Integer.MIN_VALUE;
		set = new HashSet<>();
		List<String> list = new ArrayList<>();
		this.removeInvalidParentheses(s, new boolean[s.length()], 0, 0, 0);
		if (set.size() <= 0) {
			list.add("");
		}
		list.addAll(set);
		return list;
	}

	public static void main(String[] args) {
		Q301 q = new Q301();
		System.out.println(q.removeInvalidParentheses(")(f"));

	}

}
