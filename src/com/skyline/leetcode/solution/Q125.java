package com.skyline.leetcode.solution;

/**
 * Valid Palindrome
 * 
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * @author jairus
 *
 */
public class Q125 {

	private int getV(char c) {
		if (c >= 'a' && c <= 'z') {
			return c - 'a';
		} else if (c >= 'A' && c <= 'Z') {
			return c - 'A';
		} else if(c >= '0' && c <= '9'){
			return c;
		}else {
			return -1;
		}
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() <= 0) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			int ai = -1;
			while (i < j) {
				ai = getV(s.charAt(i));
				if (ai != -1) {
					break;
				} else {
					i++;
				}
			}
			if (i >= j) {
				break;
			}
			int aj = -1;
			while (i < j) {
				aj = getV(s.charAt(j));
				if (aj != -1) {
					break;
				} else {
					j--;
				}
			}
			if (i >= j) {
				break;
			}
			if (ai != aj) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Q125 q = new Q125();
		System.out.println(q.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(q.isPalindrome("race a car"));
	}

}
