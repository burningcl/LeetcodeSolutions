package com.skyline.leetcode.solution;

public class Q477 {

	// public int totalHammingDistance(int[] nums) {
	// if (nums == null || nums.length <= 1) {
	// return 0;
	// }
	// int cnt = 0;
	// int d =0;
	// for (int i = 0; i < nums.length; i++) {
	// for (int j = i + 1; j < nums.length; j++) {
	// d = nums[i]^ nums[j];
	// while (d != 0) {
	// cnt++;
	// d &= d - 1;
	// }
	// }
	// }
	// return cnt;
	// }

	public int totalHammingDistance(int[] nums) {
		int n = 32;
		int[] cnts = new int[n];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < n; j++) {
				cnts[j] += (nums[i] >> j) & 1;
			}
		}
		int sum = 0;
		for (int cnt : cnts) {
			sum += cnt * (nums.length - cnt);
		}
		return sum;
	}

	public static void main(String[] args) {
		 Q477 q=new Q477();
		 int[]
		 nums={4,14,2};
		 System.out.println(nums.length);
		 System.out.println(q.totalHammingDistance(nums));
	}

}
