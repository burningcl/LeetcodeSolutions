package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Gray Code
 * 
 * https://leetcode.com/problems/gray-code/
 * 
 * @author jairus
 *
 */
public class Q89 {

	public void grayCode(List<Integer> list, int level) {
		int val = 1 << level;
		int end = list.size() - 1;
		for (int i = end; i >= 0; i--) {
			list.add(val + list.get(i));
		}
	}

	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		if (n <= 0) {
			return list;
		}
		for (int i = 0; i < n; i++) {
			grayCode(list, i);
		}
		return list;
	}

	// [0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8]
	public static void main(String... strings) {
		Q89 q = new Q89();
		System.out.println(q.grayCode(1));
		System.out.println(q.grayCode(2));
		System.out.println(q.grayCode(3));
		System.out.println(q.grayCode(4));
	}
}
