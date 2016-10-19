package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * 
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * @author jairus
 *
 */
public class Q32 {

	public int longestValidParentheses(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int[] lens = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else if (stack.isEmpty()) {
				continue;
			} else {
				int start = stack.pop();
				int len = i - start + 1;
				if (start - 1 >= 0) {
					len += lens[start - 1];
				}
				lens[i] = len;
				if (len > max) {
					max = len;
				}
			}
		}
		return max;
	}

	// //
	// public int longestValidParentheses(String s) {
	// if (s == null || s.length() <= 1) {
	// return 0;
	// }
	// Stack<Integer> stack = new Stack<Integer>();
	// int max = 0;
	// int[] lens = new int[s.length()];
	// for (int i = 0; i < s.length(); i++) {
	// char c = s.charAt(i);
	// if (c == '(') {
	// stack.push(i);
	// } else if (!stack.isEmpty()) {
	// int start = stack.pop();
	// int len = i - start + 1;
	// if (start - 1 >= 0) {
	// len += lens[start - 1];
	// }
	// lens[i] = len;
	// if (len > max) {
	// max = len;
	// }
	// }
	// }
	// return max;
	// }

	public static void main(String[] args) {
		Q32 q = new Q32();
		System.out.println(q.longestValidParentheses("(()") == 2);
		System.out.println(q.longestValidParentheses("(())") == 4);
		System.out.println(q.longestValidParentheses("(()))") == 4);
		System.out.println(q.longestValidParentheses("(()()") == 4);
		System.out.println(q.longestValidParentheses("(()())()())") == 10);
		System.out.println(q.longestValidParentheses("))") == 0);
		System.out.println(q.longestValidParentheses("()") == 2);
		System.out.println(q.longestValidParentheses("()()()()()(())") == 14);
		System.out.println(q.longestValidParentheses("()(()") == 2);
		System.out.println(q.longestValidParentheses("())()") == 2);
		System.out.println(q.longestValidParentheses(")()())()()(") == 4);
		System.out.println(q.longestValidParentheses("(()(((()") == 2);
		System.out.println(q.longestValidParentheses(")(())(()()))(") == 10);
	}

}
