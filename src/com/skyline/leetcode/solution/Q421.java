package com.skyline.leetcode.solution;

/**
 * Maximum XOR of Two Numbers in an Array
 * 
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 
 * @author jairus
 *
 */
public class Q421 {

	class TrieNode {
		// 0
		TrieNode left;
		// 1
		TrieNode right;
	}

	public int findMaximumXOR(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		TrieNode root = new TrieNode();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			TrieNode cur = root;
			for (int j = 30; j >= 0; j--) {
				int val = (1 << j) & num;
				if (val == 0) {
					if (cur.left == null) {
						cur.left = new TrieNode();
					}
					cur = cur.left;
				} else {
					if (cur.right == null) {
						cur.right = new TrieNode();
					}
					cur = cur.right;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			TrieNode cur = root;
			int curMax = 0;
			int target = 0;
			for (int j = 30; j >= 0; j--) {
				int mask = 1 << j;
				int val = mask & num;
				if (val == 0) {
					if (cur.right != null) {
						cur = cur.right;
						target = target | mask;
					} else {
						cur = cur.left;
					}
				} else {
					if (cur.left != null) {
						cur = cur.left;
					} else {
						cur = cur.right;
						target = target | mask;
					}
				}
			}
			curMax = target ^ num;
			if (curMax > max) {
				max = curMax;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Q421 q = new Q421();
		int[] nums = { 3, 10, 5, 25, 2, 8 };
		System.out.println(q.findMaximumXOR(nums));
	}

}
