package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Pascal's Triangle II https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * @author jairus
 *
 */
public class Q119 {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		int size = rowIndex / 2 + 1;
		int[] array = new int[size];
		array[size - 1] = 1;
		for (int i = 2; i <= rowIndex; i++) {
			int half = i / 2;
			if (i % 2 == 0) {
				array[size - 1 - half] = 1;
				for (int j = half; j > 1; j--) {
					//System.out.println(array[size - j]+", "+array[size - j+1]);
					array[size - j] += array[size - j + 1];
				}
				array[size - 1] = array[size - 1] * 2;
			} else {
				for (int j = 1; j <= half; j++) {
					array[size - j] += array[size - j - 1];
				}
			}
		}
		for (int num : array) {
			list.add(num);
		}
		int end = rowIndex / 2 - (rowIndex % 2 == 0 ? 1 : 0);
		for (int i = end; i >= 0; i--) {
			list.add(array[i]);
		}
		return list;
	}

	public static void main(String... strings) {
		Q119 q = new Q119();
		System.out.println(q.getRow(0));
		System.out.println(q.getRow(1));
		System.out.println(q.getRow(2));
		System.out.println(q.getRow(3));
		System.out.println(q.getRow(4));
		System.out.println(q.getRow(5));
		System.out.println(q.getRow(6));
		System.out.println(q.getRow(9));
		System.out.println(q.getRow(20));
	}
}
