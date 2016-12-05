package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Different Ways to Add Parentheses
 * 
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * 
 * @author jairus
 *
 */
public class Q241 {

	private List<Integer> diffWaysToCompute(List<Integer> nums, List<Character> ops, int start, int end, Object[][] map) {
		@SuppressWarnings("unchecked")
		List<Integer> list = (List<Integer>) (map[start][end]);
		if (list != null) {
			return list;
		}
		list = new ArrayList<>();
		map[start][end] = list;

		if (start == end) {
			list.add(nums.get(start));
			return list;
		}

		for (int i = start; i < end; i++) {
			List<Integer> list1 = this.diffWaysToCompute(nums, ops, start, i, map);
			List<Integer> list2 = this.diffWaysToCompute(nums, ops, i + 1, end, map);

			char op = ops.get(i);
			for (int i1 : list1) {
				for (int i2 : list2) {
					// System.out.println(""+i1+op+i2);
					switch (op) {
					case '+':
						list.add(i1 + i2);
						break;
					case '-':
						list.add(i1 - i2);
						break;
					case '*':
						list.add(i1 * i2);
						break;
					case '/':
						list.add(i1 / i2);
						break;
					}
				}
			}
		}

		return list;
	}

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> list = new ArrayList<>();
		if (input == null || input.length() <= 0) {
			return list;
		}
		List<Integer> nums = new ArrayList<>();
		List<Character> ops = new ArrayList<>();
		int num = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= '0' && c <= '9') {
				num = num * 10 + c - '0';
			} else {
				nums.add(num);
				num = 0;
				ops.add(c);
			}
		}
		nums.add(num);
		// System.out.println(nums);
		Object[][] map = new Object[nums.size()][nums.size()];
		list = this.diffWaysToCompute(nums, ops, 0, nums.size() - 1, map);
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		Q241 q = new Q241();
		System.out.println(q.diffWaysToCompute("2*3-4*5"));
		System.out.println(q.diffWaysToCompute("2*3-4*5-6/7"));
	}

}
