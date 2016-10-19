package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Shuffle an Array
 * 
 * https://leetcode.com/problems/shuffle-an-array/
 * 
 * @author jairus
 *
 */
public class Q384 {

	public static class Solution {

		Random rand;

		Map<Integer, Integer> indexMap;

		List<Integer> list;

		public Solution(int[] nums) {
			list = new ArrayList<>();
			indexMap = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
				indexMap.put(nums[i], i);
			}
			rand = new Random();
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			int[] array = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				int num = list.get(i);
				int pos = indexMap.get(num);
				array[pos] = num;
			}
			return array;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int[] array = new int[list.size()];
			for (int i = list.size() - 1; i >= 0; i--) {
				int pos = rand.nextInt(i + 1);
				if (list.get(i) == list.get(pos)) {
					array[i] = list.get(i);
					continue;
				}
				list.set(i, list.get(i) ^ list.get(pos));
				list.set(pos, list.get(i) ^ list.get(pos));
				list.set(i, list.get(i) ^ list.get(pos));
				array[i] = list.get(i);
			}
			return array;
		}
	}

	public static void printArray(int[] array) {
		if (array == null) {
			System.out.println(array);
			return;
		}
		System.out.print("{");
		for (int t : array) {
			System.out.print(t + ",");
		}
		System.out.println("}");
	}

	public static void main(String... strings) {
		int[] array = { 1, 2, 3, 4 };
		Solution q = new Solution(array);
		printArray(q.shuffle());
		printArray(q.reset());
		printArray(q.shuffle());
	}
}
