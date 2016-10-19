package com.skyline.leetcode.solution;

import java.util.List;

/**
 * Triangle
 * 
 * https://leetcode.com/problems/triangle/
 * 
 * @author jairus
 *
 */
public class Q120 {

	private int get(List<Integer> list, int index, int size) {
		if (index >= 0 && index < size) {
			return list.get(index);
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() <= 0) {
			return 0;
		}
		for (int i = 1; i < triangle.size(); i++) {
			List<Integer> fList = triangle.get(i - 1);
			List<Integer> cList = triangle.get(i);
			int size = i + 1;
			for (int j = 0; j < size; j++) {
				int minF = Math.min(get(fList, j - 1, size - 1), get(fList, j, size - 1));
				cList.set(j, cList.get(j) + minF);
			}
		}
		int min = Integer.MAX_VALUE;
		List<Integer> cList = triangle.get(triangle.size() - 1);
		for (int i = 0; i < triangle.size(); i++) {
			if (cList.get(i) < min) {
				min = cList.get(i);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
