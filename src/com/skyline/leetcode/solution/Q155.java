package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Min Stack
 * 
 * https://leetcode.com/problems/min-stack/
 * 
 * @author jairus
 * 
 */
public class Q155 {
	public class MinStack {

		Stack<Integer> valStack = null;
		Stack<Integer> minStack = null;

		/** initialize your data structure here. */
		public MinStack() {
			valStack = new Stack<Integer>();
			minStack = new Stack<Integer>();
		}

		public void push(int x) {
			valStack.push(x);
			if (minStack.isEmpty()) {
				minStack.push(x);
			} else {
				int min = minStack.peek();
				minStack.push(min < x ? min : x);
			}
		}

		public void pop() {
			valStack.pop();
			minStack.pop();
		}

		public int top() {
			return valStack.peek();
		}

		public int getMin() {
			return minStack.peek();
		}
	}
}
