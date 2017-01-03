package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Minimum Moves to Equal Array Elements II
 * 
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * 
 * @author jairus
 *
 */
public class Q462 {
	public int minMoves2(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		Arrays.sort(nums);

		long gtSum = 0;
		long ltSum = 0;
		int gtCnt = 0;
		int curCnt = 0;
		int ltCnt = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != nums[0]) {
				gtCnt++;
				gtSum += (nums[i] - nums[0]);
			} else {
				curCnt++;
			}
		}

		long minSum = Math.min(Long.MAX_VALUE, gtSum);

		for (int i = curCnt; i < nums.length;) {
			int num = nums[i];
			ltCnt += curCnt;
			curCnt = 0;
			int fNum = nums[i - 1];
			gtSum = gtSum - gtCnt * (num - fNum);
			for (; i < nums.length && nums[i] == num; i++) {
				curCnt++;
				gtCnt--;
			}
			ltSum = ltSum + ltCnt * (num - fNum);
			minSum = Math.min(minSum, gtSum + ltSum);
		}

		return (int) minSum;
	}

	public static void main(String... strings) {
		Q462 q = new Q462();
		int[] n1 = { 1, 2, 3, 100 };
		System.out.println(q.minMoves2(n1));
	}
}
