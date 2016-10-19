package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

/**
 * Insert Delete GetRandom O(1) - Duplicates allowed
 * 
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * 
 * @author jairus
 *
 */
public class Q381 {
	public class RandomizedCollection {

		private Map<Integer, Stack<Integer>> map;

		private List<Integer> list;

		private Random rand = null;

		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<>();
			list = new ArrayList<>();
			rand = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did
		 * not already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean contains = true;
			list.add(val);
			Stack<Integer> stack = map.get(val);
			if (stack == null) {
				stack = new Stack<>();
				map.put(val, stack);
			}
			contains = !stack.isEmpty();
			stack.push(list.size() - 1);
			return !contains;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection
		 * contained the specified element.
		 */
		public boolean remove(int val) {
			boolean contains = true;
			Stack<Integer> stack = map.get(val);
			if (stack == null || stack.isEmpty()) {
				contains = false;
			} else {
				int index = stack.pop();
				int lastIndex = list.size() - 1;
				if (index < lastIndex) {
					int lastVal = list.get(lastIndex);
					list.set(index, lastVal);
					Stack<Integer> lastValStack = map.get(lastVal);
					lastValStack.pop();
					lastValStack.push(index);
				}
				list.remove(lastIndex);
			}
			return contains;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			return list.get(rand.nextInt(list.size()));
		}
	}

}
