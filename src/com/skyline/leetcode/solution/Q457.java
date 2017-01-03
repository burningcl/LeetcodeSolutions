package com.skyline.leetcode.solution;

/**
 * Circular Array Loop
 * 
 * https://leetcode.com/problems/circular-array-loop/
 * 
 * @author jairus
 *
 */
public class Q457 {

	public boolean circularArrayLoop(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return false;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				continue;
			}
			int j = i;
			boolean forward = nums[i] > 0;
			boolean jumped = false;
			while (nums[j] != 0) {
				if (forward != nums[j] > 0) {
					break;
				}
				int tj = forward ? (nums[j] + j) % nums.length
						: (nums[j] + j + (1 - nums[j] / nums.length) * nums.length) % nums.length;
				nums[j] = 0;
				j = tj;
				if (j == i) {
					if (jumped) {
						return true;
					} else {
						break;
					}
				}
				jumped = true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Q457 q = new Q457();
		int[] n1 = { 2, -1, 1, 2, 2 };
		System.out.println(q.circularArrayLoop(n1));
		int[] n2 = { -1, 2 };
		System.out.println(q.circularArrayLoop(n2));
		int[] n3 = { 2, -1, 1, -2, -2 };
		System.out.println(q.circularArrayLoop(n3));
	}

}
