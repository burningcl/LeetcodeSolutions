package com.skyline.leetcode.solution;

import java.util.Random;

/**
 * Jump Game
 * 
 * https://leetcode.com/problems/jump-game/
 * 
 * @author jairus
 *
 */
public class Q55 {

	Boolean[] cache = null;

	// public boolean canJump(int[] nums, int pos) {
	// if (cache[pos] != null) {
	// return cache[pos];
	// }
	//
	// boolean ret = false;
	// if (pos >= nums.length) {
	// ret = false;
	// } else if (pos == nums.length - 1 || pos + nums[pos] >= nums.length - 1)
	// {
	// ret = true;
	// } else {
	// for (int i = nums[pos]; i >= 1; i--) {
	// if (canJump(nums, pos + i)) {
	// ret = true;
	// }
	// }
	// }
	// cache[pos] = ret;
	// return ret;
	// }

	// public boolean canJump(int[] nums) {
	// if (nums == null || nums.length <= 0) {
	// return false;
	// }
	// boolean[] trieds = new boolean[nums.length];
	// boolean[] tryings = new boolean[nums.length];
	// Stack<Integer> stack = new Stack<Integer>();
	// stack.push(0);
	// int cnt=0;
	// while (!stack.isEmpty()) {
	// int pos = stack.pop();
	// if (pos >= nums.length || pos + nums[pos] >= nums.length - 1) {
	// return true;
	// }
	// cnt++;
	// //System.out.println(pos);
	// if (trieds[pos]) {
	// continue;
	// }
	// for (int i = nums[pos]; i >= 1; i--) {
	// if (!trieds[i + pos] && !tryings[i + pos]) {
	// stack.push(i + pos);
	// tryings[i + pos] = true;
	// }
	// }
	// trieds[pos] = true;
	// }
	// System.out.println(cnt);
	// return false;
	// }

	public boolean canJump(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return false;
		} else if (nums.length == 1) {
			return true;
		}
		int low = 0;
		int high = 0;
		int max = -1;
		while (max < nums.length - 1) {
			for (int i = low; i <= high; i++) {
				if (i + nums[i] > max) {
					max = i + nums[i];
				}
			}
			if (max == high) {
				break;
			}
			low = high;
			high = max;
		}
		return max < nums.length - 1 ? false : true;
	}

	public static void main(String... strings) {
		Q55 q = new Q55();
		int[] nums = { 3, 2, 1, 0, 4 };
		int[] nums1 = { 2, 3, 1, 1, 4 };
		int[] nums2 = new int[1024];
		Random ran = new Random();
		for (int i = 0; i < 1024; i++) {
			nums2[i] = ran.nextInt(10);
		}
		int[] nums3 = { 1, 2, 1 };
		int[] nums4 = { 1 };
		int[] nums5 = new int[25003];
		for (int i = 0; i <= 25000; i++) {
			nums5[i] = 25000 - i;
			// System.out.println(nums5[i]);
		}
		int[] nums6 = { 3, 2, 1, 0, 1, 2, 3 };
		long t1 = System.nanoTime();
		System.out.println(q.canJump(nums));
		System.out.println(q.canJump(nums1));
		System.out.println(q.canJump(nums2));
		System.out.println(q.canJump(nums3));
		System.out.println(q.canJump(nums4));
		System.out.println(q.canJump(nums5));
		System.out.println(q.canJump(nums6));
		// Stack<Integer> stack = new Stack<Integer>();
		// for(int i=0;i<25000;i++){
		// stack.push(i);
		// }
		// while(!stack.isEmpty()){
		// stack.pop();
		// }
		long t2 = System.nanoTime();

		System.out.println((double) (t2 - t1) / 1000000);
	}
}
