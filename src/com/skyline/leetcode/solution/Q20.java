package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses
 * 
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author jairus
 *
 */
public class Q20 {
	public boolean isValid(String s) {
		if (s == null || s.length() % 2 == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(']', '[');
		map.put(')', '(');
		map.put('}', '{');
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || stack.pop() != map.get(c)) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String...strings ){
		Q20 q=new Q20();
		System.out.println(q.isValid(""));
		System.out.println(q.isValid("{"));
		System.out.println(q.isValid("["));
		System.out.println(q.isValid("("));
		System.out.println(q.isValid("}"));
		System.out.println(q.isValid("]"));
		System.out.println(q.isValid(")"));
		System.out.println(q.isValid("{}"));
		System.out.println(q.isValid("[]"));
		System.out.println(q.isValid("()"));
		System.out.println(q.isValid("{[()]}"));
		System.out.println(q.isValid("[]{}()"));
		System.out.println(q.isValid("(){[]}"));
	}
}
