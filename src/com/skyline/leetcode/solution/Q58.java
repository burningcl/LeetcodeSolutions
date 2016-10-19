package com.skyline.leetcode.solution;

/**
 * Length of Last Word
 * 
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * @author jairus
 *
 */
public class Q58 {

	public int lengthOfLastWord(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		int len = 0;
		int last = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				len = 0;
				continue;
			}
			len++;
			last=len;
		}
		return last;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
