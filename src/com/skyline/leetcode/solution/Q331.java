package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Verify Preorder Serialization of a Binary Tree
 * 
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 
 * @author jairus
 *
 */
public class Q331 {
	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.equals("#")) {
			return true;
		}
		int sharpCnt = 0;

		List<Character> cs = new ArrayList<>();
		String[] strs = preorder.split(",");
		for (String str : strs) {
			if (str.equals("#")) {
				cs.add('#');
				sharpCnt++;
			} else {
				cs.add('0');
			}
		}

		if (sharpCnt != cs.size() / 2 + 1) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		if (cs.get(0) == '#') {
			return false;
		} else {
			stack.push(1);
		}

		for (int i = 1; i < cs.size(); i++) {
			char c = cs.get(i);
			if (!stack.empty()) {
				Integer cnt = stack.pop();
				if (cnt != null && cnt > 0) {
					cnt--;
					stack.push(cnt);
				}
			} else {
				return false;
			}
			if (c != '#') {
				stack.push(1);
			}
		}
		return true;
	}

	public static void main(String... strings) {
		// System.out.println(new
		// Q331().isValidSerialization("4,3,#,1,#,#,2,#,#"));
		// System.out.println(new
		// Q331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		// System.out.println(new Q331().isValidSerialization("1,#"));
		System.out.println(new Q331().isValidSerialization("7,2,#,2,#,#,#,6,#"));
	}

}
