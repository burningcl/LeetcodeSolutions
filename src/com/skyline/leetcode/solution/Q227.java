package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Basic Calculator II
 * 
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * @author jairus
 *
 */
public class Q227 {

	public int calculate(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		int num = 0;
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		List<Character> opList = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				continue;
			} else if (c >= '0' && c <= '9') {
				num = num * 10 + c - '0';
			} else {
				list.add(num);
				num = 0;
				opList.add(c);
			}
		}
		list.add(num);
		if (list.size() != opList.size() + 1) {
			return 0;
		}
		stack.push(list.get(0));
		for (int i = 0; i < list.size() - 1; i++) {
			char c = opList.get(i);
			int num2 = list.get(i + 1);
			int num1 = stack.pop();
			if (c == '+') {
				stack.push(num1);
				stack.push(num2);
			} else if (c == '-') {
				stack.push(num1);
				stack.push(-num2);
			} else if (c == '*') {
				stack.push(num1 * num2);
			} else {
				stack.push(num1 / num2);
			}
		}
		num = 0;
		while (!stack.isEmpty()) {
			num += stack.pop();
		}
		return num;
	}

	public static void main(String[] args) {
		Q227 q=new Q227();
		System.out.println(q.calculate("3+2*2"));
		System.out.println(q.calculate(" 3/2 "));
		System.out.println(q.calculate(" 3+5 / 2 "));
		System.out.println(q.calculate(" 2 3 3+5 321 43 / 2 777 *4 324-2"));
	}

}
