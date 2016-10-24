package com.skyline.leetcode.solution;

/**
 * Burst Balloons
 * 
 * https://leetcode.com/problems/burst-balloons/
 * 
 * @author jairus
 *
 */
public class Q312 {

	public int maxCoins(int[] nums, int[][] map, int start, int end) {
		if (end < start) {
			return 0;
		}
		if (map[start][end] > 0) {
			return map[start][end];
		}
		int left = start > 0 ? nums[start - 1] : 1;
		int right = end < nums.length - 1 ? nums[end + 1] : 1;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			int val = nums[i] * left * right + maxCoins(nums, map, start, i - 1) + maxCoins(nums, map, i + 1, end);
			if (val > max) {
				max = val;
			}
		}
		map[start][end] = max;
		return max;
	}

	public int maxCoins(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int len = nums.length;
		int[][] map = new int[len][len];
		return this.maxCoins(nums, map, 0, len - 1);
	}

	// class Item {
	// int val = 0;
	// boolean[] array = null;
	// }
	//
	// public int maxCoins(int[] nums) {
	// if (nums == null || nums.length <= 0) {
	// return 0;
	// }
	// Item[][] f = new Item[nums.length][nums.length];
	// for (int i = 0; i < nums.length; i++) {
	// f[0][i] = new Item();
	// f[0][i].val = nums[i];
	// f[0][i].array[i] = true;
	// }
	// for (int i = 1; i <= nums.length; i++) {
	// for (int j = 0; j < nums.length; j++) {
	// Item item = f[i - 1][j];
	// if (item == null) {
	// continue;
	// }
	// int left = -1;
	// int right = -1;
	// int mindex = 0;
	// int mval = 0;
	// while (left < nums.length) {
	// for (; left < nums.length - 1; left++) {
	// if (item.array[left + 1] == false) {
	// break;
	// }
	// }
	// right = left + 1;
	// for (; right < nums.length; right++) {
	// if (item.array[right]) {
	// break;
	// }
	// }
	// for (int k = left + 1; k < right; k++) {
	// int lval = left == -1 ? 1 : nums[left];
	// int rval = right >= nums.length ? 1 : nums[right];
	// int val = lval * nums[k] * rval;
	// if (val > mval) {
	// mval = val;
	// mindex = k;
	// }
	// }
	// }
	// item.val+=mval;
	// item.array[mindex]=true;
	// if (f[i][mindex] == null) {
	// f[i][mindex] = item;
	// }else if(f[i][]){
	//
	// }
	// }
	// }
	// }

	public static void t(int i) {
		System.out.println(i);
		t(i + 1);
	}

	public static void main(String[] args) {
		// int[] a = { 1 };
		// System.out.println(a.hashCode());
		//
		// int[] a1 = { 1 };
		// System.out.println(a1.hashCode());
		//
		// List<Integer> list = new ArrayList<>();
		// list.add(1);
		// System.out.println(list.hashCode());
		//
		// List<Integer> list2 = new ArrayList<>();
		// list2.add(1);
		// list2.add(2);
		// System.out.println(list2.hashCode());
		//
		// t(0);

		Q312 q = new Q312();
		int[] nums = { 3, 1, 5, 8 };
		System.out.println(q.maxCoins(nums));
	}

}
