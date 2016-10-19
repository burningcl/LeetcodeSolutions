package com.skyline.leetcode.solution;

import java.util.List;

/**
 * Mini Parser
 * 
 * https://leetcode.com/problems/mini-parser/
 * 
 * @author jairus
 *
 */
public class Q385 {

	public class NestedInteger {
		// Constructor initializes an empty nested list.
		public NestedInteger() {

		}

		// Constructor initializes a single integer.
		public NestedInteger(int value) {

		}

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger() {
			return false;
		}

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger() {
			return 0;
		}

		// Set this NestedInteger to hold a single integer.
		public void setInteger(int value) {

		}

		// Set this NestedInteger to hold a nested list and adds a nested
		// integer to it.
		public void add(NestedInteger ni) {

		}

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList() {
			return null;
		}
	}

	public NestedInteger deserialize(String s) {
		if (s == null || s.length() <= 0) {
			return null;
		}
		NestedInteger header = new NestedInteger();
		if (!s.startsWith("[")) {
			int num = 0;
			boolean negative = false;
			int i = 0;
			if (s.startsWith("-")) {
				negative = true;
				i++;
			}
			for (; i < s.length(); i++) {
				char c = s.charAt(i);
				num = num * 10 + c - '0';
			}
			if (negative) {
				num = -num;
			}
			header.setInteger(num);
		} else {
			int leftCnt = 1;
			int startIndex = 1;
			for (int i = 1; i < s.length(); i++) {
				char c = s.charAt(i);
				String subStr = null;
				if (c == ',' && leftCnt == 1) {
					subStr = s.substring(startIndex, i);
					startIndex = i + 1;
				} else if (c == '[') {
					leftCnt++;
				} else if (c == ']') {
					leftCnt--;
					if (leftCnt == 0) {
						subStr = s.substring(startIndex, i);
						startIndex = i + 1;
					}
				}
				if (subStr != null) {
					NestedInteger cur = deserialize(subStr);
					if (cur != null) {
						header.add(cur);
					}
				}
				subStr = null;
			}
		}
		return header;
	}
}
