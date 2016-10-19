package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Watch
 * 
 * https://leetcode.com/problems/binary-watch/
 * 
 * @author jairus
 *
 */
public class Q401 {

	private static final int MASK = (1 << 4) - 1;

	private int hour(int val) {
		return val & MASK;
	}

	private int miniter(int val) {
		return val >> 4;
	}

	public void readBinaryWatch(int num, int start, int value, List<String> list) {
		if (num <= 0) {
			int hour = hour(value);
			int miniter = miniter(value);
			String str = String.format("%d:%02d", hour, miniter);
			list.add(str);
			return;
		}

		for (int i = start; i <= 9; i++) {
			int t = 1 << i;
			value = value ^ t;
			int hour = hour(value);
			int miniter = miniter(value);
			if (hour < 12 && miniter < 60) {
				readBinaryWatch(num - 1, i + 1, value, list);
			}
			value = value ^ t;
		}
	}

	public List<String> readBinaryWatch(int num) {
		List<String> list = new ArrayList<String>();
		readBinaryWatch(num, 0, 0, list);
		return list;
	}

	public static void main(String[] args) {
		Q401 q = new Q401();
		System.out.println(q.readBinaryWatch(0));
		System.out.println(q.readBinaryWatch(1));
	}

}
