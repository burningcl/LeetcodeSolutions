package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Insert Delete GetRandom O(1)
 * 
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * 
 * @author jairus
 *
 */
public class Q380 {
	public class RandomizedSet {

		private Map<Integer, Integer> map;

		private List<Integer> list;

		private int size = 0;

		private Random rand = null;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
			rand = new Random();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already
		 * contain the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			}
			if (list.size() != size) {
				list.set(size, val);
			} else {
				list.add(val);
			}
			map.put(val, size);
			size++;
			return true;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the
		 * specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}
			int index = map.get(val);
			if (size > 1) {
				int lastValue = list.get(size - 1);
				list.set(index, lastValue);
				map.put(lastValue, index);
			}
			map.remove(val);
			size--;
			return true;
		}

		/** Get a random element from the set. */
		public int getRandom() {
			return list.get(rand.nextInt(size));
		}
	}

}
