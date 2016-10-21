package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * 
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * @author jairus
 *
 */
public class Q150 {

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length <= 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			try {
				Integer val = Integer.valueOf(token);
				stack.push(val);
			} catch (Exception ignore) {
				if (stack.size() < 2) {
					return 0;
				}
				int v2 = stack.pop();
				int v1 = stack.pop();
				if (token.equals("+")) {
					v1 += v2;
				} else if (token.equals("-")) {
					v1 -= v2;
				} else if (token.equals("*")) {
					v1 *= v2;
				} else if (token.equals("/")) {
					v1 /= v2;
				} else {
					return 0;
				}
				stack.push(v1);
			}
		}
		return stack.size() == 1 ? stack.pop() : 0;
	}

	public static void main(String[] args) {
		Q150 q = new Q150();
		String[] tokens1 = { "2", "1", "+", "3", "*" };
		System.out.println(q.evalRPN(tokens1));

		String[] tokens2 = { "4", "13", "5", "/", "+" };
		System.out.println(q.evalRPN(tokens2));

		String[] tokens3 = { "18" };
		System.out.println(q.evalRPN(tokens3));

		String[] tokens4 = { "18", "+" };
		System.out.println(q.evalRPN(tokens4));

		System.out.println(Integer.MAX_VALUE);
	}

}
