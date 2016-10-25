package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * 
 * 
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 
 * @author jairus
 *
 */
public class Q232 {

	static class MyQueue {

		Stack<Integer> stack1 = new Stack<>();

		Stack<Integer> stack2 = new Stack<>();

		// Push element x to the back of queue.
		public void push(int x) {
			stack1.push(x);
		}

		// Removes the element from in front of queue.
		public void pop() {
			this.peek();
			if (!stack2.isEmpty())
				stack2.pop();
		}

		// Get the front element.
		public int peek() {
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			if (!stack2.isEmpty())
				return stack2.peek();
			else
				return 0;
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return stack1.empty() && stack2.empty();
		}
	}

	public static void main(String... strings) {
		MyQueue q = new MyQueue();
		q.push(1);
		System.out.println(q.peek());
		System.out.println(q.empty());
		q.pop();
		System.out.println(q.peek());
		System.out.println(q.empty());
		System.out.println();
		q.push(2);
		System.out.println(q.peek());
		q.push(3);
		System.out.println(q.peek());
		q.push(4);
		q.pop();
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
		q.pop();
		System.out.println(q.peek());
	}
}
