package com.skyline.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues
 * 
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * @author jairus
 *
 */
public class Q225 {

	static class MyStack {
		Queue<Integer> queue = new LinkedList<>();
		boolean rotated = false;

		// Push element x onto stack.
		public void push(int x) {
			if (rotated) {
				int top = queue.poll();
				queue.add(top);
				rotated = false;
			}
			queue.add(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			if (empty()) {
				return;
			}
			if (!rotated) {
				top();
			}
			queue.poll();
			rotated = false;
		}

		// Get the top element.
		public int top() {
			if (empty()) {
				return 0;
			}
			if (!rotated)
				for (int i = 0; i < queue.size() - 1; i++) {
					int x = queue.poll();
					queue.add(x);
					rotated = true;
				}
			return queue.peek();
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue.isEmpty();
		}
	}

	public static void main(String... strings) {
		Q225.MyStack s = new Q225.MyStack();
		s.push(1);
		System.out.println(s.top());
		s.push(2);
		System.out.println(s.top());
		s.push(3);
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		s.push(4);
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		System.out.println(s.top());
	}
}
