package com.skyline.leetcode.solution;

/**
 * Rotate Array
 * 
 * https://leetcode.com/problems/rotate-array/
 * 
 * @author jairus
 *
 */
public class Q189 {

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || k % nums.length == 0) {
			return;
		}
		int cnt = 0;
		for (int i = 0; cnt < nums.length; i++) {
			int i1 = i;
			int v = nums[i1];
			while (true) {
				int i2 = (i1 + k + nums.length) % nums.length;
				int t = nums[i2];
				nums[i2] = v;
				i1 = i2;
				v = t;
				cnt++;
				if (i1 == i) {
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Q189 q = new Q189();
		for (int i = 0; i < 8; i++) {
			int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7 };
			q.rotate(nums, i);
			ArrayUtil.print(nums);
		}

		for (int i = 0; i < 2; i++) {
			int[] nums = { 0, 1 };
			q.rotate(nums, i);
			ArrayUtil.print(nums);
		}

		for (int i = 0; i < 1; i++) {
			int[] nums = { 0 };
			q.rotate(nums, i);
			ArrayUtil.print(nums);
		}

		for (int i = 0; i < 20; i++) {
			int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
			q.rotate(nums, i);
			ArrayUtil.print(nums);
		}
	}

}
