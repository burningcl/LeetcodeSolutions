package com.skyline.leetcode.solution;

/**
 * Container With Most Water
 * 
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * @author jairus
 *
 */
public class Q11 {

	public int maxArea(int[] height) {
		if (height == null || height.length <= 1) {
			return 0;
		}
		int i = 0;
		int j = height.length - 1;
		int max = 0;
		int h;
		while (i < j) {
			max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j]) {
				h = height[i];
				i++;
				while (i < j && height[i] <= h) {
					i++;
				}
			} else {
				h = height[j];
				j--;
				while (i < j && height[j] <= h) {
					j--;
				}
			}
		}
		return max;
	}

}
