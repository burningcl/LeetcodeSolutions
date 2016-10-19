package com.skyline.leetcode.solution;

/**
 * Compare Version Numbers
 * 
 * https://leetcode.com/problems/compare-version-numbers/
 * 
 * @author jairus
 * 
 */
public class Q165 {

	private int compare(String s1, String s2) {
		long v1 = Long.valueOf(s1);
		long v2 = Long.valueOf(s2);
		if (v1 > v2) {
			return 1;
		} else if (v1 < v2) {
			return -1;
		} else {
			return 0;
		}
	}

	private boolean allZero(String[] sp, int start) {
		for (int i = start; i < sp.length; i++) {
			if (Long.valueOf(sp[i]) != 0) {
				return false;
			}
		}
		return true;
	}

	public int compareVersion(String version1, String version2) {
		if (version1 == null || version1.length() <= 0) {
			return -1;
		} else if (version2 == null || version2.length() <= 0) {
			return 1;
		}
		String[] sp1 = version1.split("\\.");
		String[] sp2 = version2.split("\\.");
		int len = sp1.length < sp2.length ? sp1.length : sp2.length;
		if (len <= 0) {
			return compare(version1, version2);

		}
		int i = 0;
		for (; i < len; i++) {
			int c = compare(sp1[i], sp2[i]);
			if (c != 0) {
				return c;
			}
		}

		if (sp1.length > sp2.length && !this.allZero(sp1, i)) {
			return 1;
		} else if (sp1.length < sp2.length && !this.allZero(sp2, i)) {
			return -1;
		} else {
			return 0;
		}
	}
}
