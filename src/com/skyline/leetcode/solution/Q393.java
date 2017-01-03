package com.skyline.leetcode.solution;

/**
 * UTF-8 Validation
 * 
 * @author jairus
 *
 */
public class Q393 {

	final static int[] masks = { 0x80, 0xE0, 0xF0, 0xF8 };
	final static int[] tests = { 0x00, 0xC0, 0xE0, 0xF0 };
	final static int maskfollowed = 0xC0;
	final static int testfollowed = 0x80;

	public boolean validUtf8(int[] data) {
		if (data == null || data.length <= 0) {
			return false;
		}
		int d;
		for (int i = 0; i < data.length;) {
			int len = 0;
			d = data[i];
			for (; len < 4; len++) {
				if ((masks[len] & d) == tests[len]) {
					break;
				}
			}
			if (len >= 4 || i + len >= data.length) {
				return false;
			}
			for (int k = 1; k <= len; k++) {
				if ((maskfollowed & data[i + k]) != testfollowed)
					return false;
			}
			i += len + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		for (int mask : masks)
			System.out.println(Integer.toBinaryString(mask));
		for (int test : tests)
			System.out.println(Integer.toBinaryString(test));

		Q393 q = new Q393();
		int[] data = { 237 };
		System.out.println(q.validUtf8(data));
	}

}
