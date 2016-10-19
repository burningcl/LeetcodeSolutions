package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Expression Add Operators
 * 
 * https://leetcode.com/problems/expression-add-operators/
 * 
 * @author jairus
 *
 */
public class Q282 {

	Stack<Long> numStack = new Stack<>();
	List<Long> numList = new ArrayList<>();
	List<Character> opList = new ArrayList<>();

	private void addOperators(String numStr, int target, int index, List<String> list, char[] str, int strIndex) {
		if (index == numStr.length()) {
			numStack.clear();
			numList.clear();
			opList.clear();
			Long num = null;
			for (int i = 0; i < strIndex; i++) {
				char c = str[i];
				if (c >= '0' && c <= '9') {
					long val = c - '0';
					if (num == null) {
						num = val;
					} else if (num == 0) {
						return;
					} else {
						num = num * 10 + val;
					}
				} else {
					numList.add(num);
					opList.add(c);
					num = null;
				}
			}
			numList.add(num);
			if (numList.size() <= opList.size()) {
				return;
			}
			numStack.push(numList.get(0));
			for (int i = 1; i < numList.size(); i++) {
				char op = opList.get(i - 1);
				if (op == '*') {
					num = numStack.pop() * numList.get(i);
					numStack.push(num);
				} else {
					if (op == '-') {
						numStack.push(-numList.get(i));
					} else {
						numStack.push(numList.get(i));
					}
				}
			}
			num = 0l;
			while (!numStack.isEmpty()) {
				num += numStack.pop();
			}
			if (num == target) {
				list.add(String.copyValueOf(str, 0, strIndex));
			}
			return;
		}
		str[strIndex] = numStr.charAt(index);
		this.addOperators(numStr, target, index + 1, list, str, strIndex + 1);
		if (index >= numStr.length() - 1) {
			return;
		}
		strIndex++;
		str[strIndex] = '+';
		this.addOperators(numStr, target, index + 1, list, str, strIndex + 1);
		str[strIndex] = '-';
		this.addOperators(numStr, target, index + 1, list, str, strIndex + 1);
		str[strIndex] = '*';
		this.addOperators(numStr, target, index + 1, list, str, strIndex + 1);
	}

	public List<String> addOperators(String num, int target) {
		List<String> list = new ArrayList<String>();
		if (num == null || num.length() <= 1) {
			return list;
		}
		this.addOperators(num, target, 0, list, new char[num.length() * 2], 0);
		return list;
	}
}
