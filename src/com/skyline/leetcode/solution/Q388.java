package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Longest Absolute File Path
 * 
 * https://leetcode.com/problems/longest-absolute-file-path/
 * 
 * 
 * @author jairus
 *
 */
public class Q388 {
	public int lengthLongestPath(String input) {
		int max = 0;
		if (input == null || input.length() <= 0) {
			return max;
		}
		int curLen = -1;
		Stack<Integer> stack = new Stack<>();
		String[] strs = input.split("\n");
		for (String str : strs) {
			int level = 0;
			while (str.startsWith("\t")) {
				str = str.substring(1);
				level++;
			}
			while (stack.size() > level) {
				int len = stack.pop();
				curLen -= len;
			}
			int len = str.length() + 1;
			stack.push(len);
			curLen += len;
			if (str.contains(".") && curLen > max) {
				max = curLen;
			}
		}
		return max;
	}

	public static void main(String... strings) {
		Q388 q = new Q388();
		System.out.println(q.lengthLongestPath(
				"dir\n\tsubdir1\n\t\tfile1ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2ext"));
	}
}
