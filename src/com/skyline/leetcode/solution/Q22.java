package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * 
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * 卡特兰数<br>
 * 
 * f(0) = 1;<br>
 * f(1) = 1;<br>
 * f(n) = f(n-1)f(0) + f(n-2)f(1) .... +f(1)f(n-2) + f(0)f(n-1)<br>
 * 
 * @author jairus
 *
 */
public class Q22 {

	public void gen(List<String> list, char[] array, int leftCnt, final int maxLeftCnt, int pos) {
		if (pos >= array.length) {
			return;
		}
		if (leftCnt >= maxLeftCnt) {
			for (; pos < array.length; pos++) {
				array[pos] = ')';
			}
			list.add(String.valueOf(array));
			return;
		}
		array[pos] = '(';
		gen(list, array, leftCnt + 1, maxLeftCnt, pos + 1);
		if (leftCnt > pos - leftCnt) {
			array[pos] = ')';
			gen(list, array, leftCnt, maxLeftCnt, pos + 1);
		}
	}

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		if (n < 0) {
			return list;
		}
		gen(list, new char[2 * n], 0, n, 0);
		return list;
	}

	public static void main(String... strings) {
		long t1 = System.nanoTime();
		List<String> strs = new Q22().generateParenthesis(1);
		long t2 = System.nanoTime();
		System.out.println("cost:" + (t2 - t1) + ", " + strs.size());
		for (String str : strs) {
			System.out.println(str);
		}
	}
}
