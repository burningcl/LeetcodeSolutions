package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author jairus
 *
 */
public class Q17 {

	public List<String> letterCombinations(String digits) {
		char[][] cmap = { {}, // 0
				{}, // 1
				{ 'a', 'b', 'c' }, // 2
				{ 'd', 'e', 'f' }, // 3
				{ 'g', 'h', 'i' }, // 4
				{ 'j', 'k', 'l' }, // 5
				{ 'm', 'n', 'o' }, // 6
				{ 'p', 'q', 'r', 's' }, // 7
				{ 't', 'u', 'v' }, // 8
				{ 'w', 'x', 'y', 'z' }// 9
		};
		List<String> list = new ArrayList<>();
		if (digits == null || digits.length() <= 0) {
			return list;
		}
		int total = 1;
		for (int i = 0; i < digits.length(); i++) {
			char c = digits.charAt(i);
			if (c <= '1' || c > '9') {
				return list;
			}
			total = total * cmap[c - '0'].length;
		}
		char[] cs = new char[digits.length()];
		for (int i = 0; i < total; i++) {
			int oi = i;
			for (int j = digits.length() - 1; j >= 0; j--) {
				char c = digits.charAt(j);
				char[] ccs = cmap[c - '0'];
				int index = oi % ccs.length;
				cs[j] = ccs[index];
				oi /= ccs.length;
			}
			list.add(String.valueOf(cs));
		}
		return list;
	}

	public static void main(String[] args) {
		String s = "234";
		Q17 q = new Q17();
		List<String> ss = q.letterCombinations(s);
		System.out.println(ss.size());
		for (String s1 : ss) {
			System.out.print("\"" + s1 + "\",");
		}
	}

}
