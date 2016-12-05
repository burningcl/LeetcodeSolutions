package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Repeated Substring Pattern
 * 
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 
 * @author jairus
 *
 */
public class Q459 {

	// public boolean repeatedSubstringPattern(String str) {
	// if (str == null || str.length() <= 1) {
	// return false;
	// }
	// int rEnd = 0;
	// boolean r = false;
	// for (int i = 1; i < str.length() && str.length() >= 2 * rEnd;) {
	// int j = 0;
	// for (; j + i < str.length() && j <= rEnd; j++) {
	// if (str.charAt(j) != str.charAt(j + i)) {
	// rEnd = j + i;
	// break;
	// }
	// }
	// r = j > rEnd;
	// if (r) {
	// i += j;
	// } else {
	// i += j + 1;
	// }
	// // System.out.println(i + ", " + j + ", " + r + ", " + rEnd);
	// }
	// return r;
	// }

//	public boolean repeatedSubstringPattern(String str) {
//		if (str == null || str.length() <= 1) {
//			return false;
//		}
//		int array[] = new int[128];
//		for (int i = 0; i < str.length(); i++) {
//			array[str.charAt(i)]++;
//		}
//		int maxCnt = Integer.MAX_VALUE;
//		for (int i = 0; i < 128; i++) {
//			if (array[i] != 0 && array[i] < maxCnt) {
//				maxCnt = array[i];
//			}
//		}
//		for (int cnt = 2; cnt <= maxCnt; cnt++) {
//			if (str.length() % cnt != 0) {
//				continue;
//			}
//			int size = str.length() / cnt;
//			int i = size;
//			for (; i < str.length(); i++) {
//				if (str.charAt(i) != str.charAt(i % size)) {
//					break;
//				}
//			}
//			if (i >= str.length()) {
//				return true;
//			}
//		}
//		return false;
//	}

	// public boolean repeatedSubstringPattern(String str) {
	// if (str == null || str.length() <= 1) {
	// return false;
	// }
	// int maxSize = str.length() / 2;
	// Set<Integer> cache = new HashSet<>();
	// for (int size = 1; size <= maxSize; size++) {
	// if (str.length() % size != 0) {
	// continue;
	// }
	// if (repeatedSubstringPattern(str, size, cache)) {
	// return true;
	// }
	// }
	// System.out.println(cache);
	// return false;
	// }
	//
	// public boolean repeatedSubstringPattern(String str, int size,
	// Set<Integer> cache) {
	// if (str.length() % size != 0 || cache.contains(size)) {
	// return false;
	// }
	// int i = size;
	// for (; i < str.length(); i++) {
	// if (str.charAt(i) != str.charAt(i % size)) {
	// break;
	// }
	// }
	// if (i >= str.length()) {
	// return true;
	// }
	// cache.add(size);
	//
	// return (i - 1 > size && repeatedSubstringPattern(str, i - 1, cache))
	// || (i > size && repeatedSubstringPattern(str, i, cache));
	// }

	public boolean repeatedSubstringPattern(String str) {
		if (str == null || str.length() <= 1) {
			return false;
		}
		int maxSize = str.length() / 2;
		for (int size = 1; size <= maxSize; size++) {
			if (str.length() % size != 0) {
				continue;
			}
			int i = size;
			for (; i < str.length(); i++) {
				if (str.charAt(i) != str.charAt(i - size)) {
					if (size < i - 2) {
						size = i - 2;
					}
					break;
				}
			}
			if (i >= str.length()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Q459 q = new Q459();
		System.out.println(q.repeatedSubstringPattern("aa") == true);
		System.out.println(q.repeatedSubstringPattern("ab") == false);
		System.out.println(q.repeatedSubstringPattern("abcabc") == true);
		System.out.println(q.repeatedSubstringPattern("abcababcab") == true);
		System.out.println(q.repeatedSubstringPattern("abaabaa") == false);
		System.out.println(q.repeatedSubstringPattern("abaababaab") == true);
	}

}
