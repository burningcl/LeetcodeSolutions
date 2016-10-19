package com.skyline.leetcode.solution;

/**
 * Remove Duplicates from Sorted Array II
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * 
 * @author jairus
 *
 */
public class Q80 {

	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		} else if (nums.length <= 2) {
			return nums.length;
		}

		int sIndex = 0;
		int curNum = 0;
		int curCnt = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == curNum) {
				curCnt++;
				if (curCnt <= 2) {
					nums[sIndex++] = num;
				}
			} else {
				curCnt = 1;
				curNum = num;
				nums[sIndex++] = num;
			}
		}
		System.out.println(sIndex);
		return sIndex;
	}

	public static void main(String... strings) {

	}
}
