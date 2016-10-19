package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Decode String
 * 
 * https://leetcode.com/problems/decode-string/
 * 
 * @author jairus
 *
 */
public class Q394 {

	public String decodeString(String s) {
		if (s == null) {
			return null;
		}

		Stack<StringBuilder> sStack = new Stack<>();
		Stack<Integer> iStack = new Stack<>();
		int cnt = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				int num = c - '0';
				cnt = cnt * 10 + num;
			} else if (c == '[') {
				iStack.push(cnt);
				sStack.push(sb);
				sb = new StringBuilder();
				cnt = 0;
			} else if (c == ']') {
				int n = iStack.pop();
				StringBuilder ssb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					ssb.append(sb);
				}
				StringBuilder csb = sStack.pop();
				csb.append(ssb);
				sb = csb;
			} else {
				sb.append(c);
			}
		}
		if (sStack.isEmpty()) {
			return sb.toString();
		} else {
			String ret = "";
			while (!sStack.isEmpty()) {
				ret = sStack.pop() + ret;
			}
			ret += sb.toString();
			return ret;
		}
	}

	public static void main(String[] args) {
		Q394 q = new Q394();
		System.out.println(q.decodeString("abc"));
		System.out.println(q.decodeString("3[]b"));
		System.out.println(q.decodeString("3[a]"));
		System.out.println(q.decodeString("3[a]2[bc]"));
		System.out.println(q.decodeString("3[a2[c]]"));
		System.out.println(q.decodeString("2[abc]3[cd]ef"));
		System.out.println(q.decodeString("ab2[cd3[ef]3[gh]ij]kl"));
	}

}
