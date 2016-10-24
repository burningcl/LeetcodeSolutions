package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Basic Calculator
 * 
 * https://leetcode.com/problems/basic-calculator/
 * 
 * @author jairus
 *
 */
public class Q224 {

	public int calculate(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		Stack<Boolean> opStack = new Stack<>();
		int num = 0;
		int ret = 0;
		boolean add = true;
		boolean acAdd = true;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');
			}
			if (c < '0' || c > '9' || i >= s.length() - 1) {
				if (num != 0) {
					if (add == acAdd) {
						ret += num;
					} else {
						ret -= num;
					}
				}
				num = 0;
				if (c == '(') {
					opStack.push(add);
					add = add == acAdd;
					acAdd = true;
				} else if (c == ')') {
					add = opStack.pop();
				} else if (c == '+') {
					acAdd = true;
				} else if (c == '-') {
					acAdd = false;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Q224 q = new Q224();
		System.out.println(q.calculate("1+(1)") == 2);
		System.out.println(q.calculate("1-1") == 0);
		System.out.println(q.calculate("1-1+(1-1)") == 0);
		System.out.println(q.calculate("1-1+(1-(1 + 2))") == -2);
		System.out.println(q.calculate("1-1+(1-(1 + 2 -(1+3)))") == 2);
		System.out.println(q.calculate("1-1+(1-(1 + 2 -(1+3) + 4))") == -2);
		System.out.println(q.calculate("1-1+(1-(1 + 2 -(1+3) + ( 4-5)))") == 3);
		System.out.println(q.calculate("1-1+(1-(1 + 2 -(1+3) + ( 4-5)-(5-6)))") == 2);
		System.out.println(q.calculate("(1+(4+5+2)-3)+(6+8)") == 23);
		System.out.println(q.calculate("(1+(4+5+2)-3)-(6+8)") == -5);
		System.out.println(q.calculate("(1+(4+5+2)-3)+(6-8)") == 7);
		System.out.println(q.calculate("(1+(4+5+2)-3)+(6-(8-9))")==16);
		System.out.println(q.calculate("5  "));
	}

}
