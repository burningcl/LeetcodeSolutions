package com.skyline.leetcode.solution;

/**
 * Ransom Note
 * 
 * https://leetcode.com/problems/ransom-note/
 * 
 * @author jairus
 *
 */
public class Q383 {

	public boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote == null || magazine == null) {
			return false;
		}

		int[] r = new int[128];
		char[] rcs = ransomNote.toCharArray();
		char[] mcs = magazine.toCharArray();

		for (char rc : rcs) {
			r[(int) rc]++;
		}

		for (char mc : mcs) {
			r[(int) mc]--;
		}

		return true;
	}

}
