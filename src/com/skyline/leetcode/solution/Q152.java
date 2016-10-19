package com.skyline.leetcode.solution;

/**
 * Maximum Product Subarray
 * 
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * @author jairus
 * 
 */
public class Q152 {

	private int maxProduct(int[] nums, int start, int end, int nCnt) {
		// System.out.println("start: "+start + "\tend:" + end);
		if (start > end) {
			return Integer.MIN_VALUE;
		} else if (start == end) {
			return nums[start];
		}
		if (nCnt % 2 == 0) {
			int max = 1;
			for (int i = start; i <= end; i++) {
				max *= nums[i];
			}
			return max;
		} else {
			int left = 1;
			int right = 1;
			while (start <= end) {
				int num = nums[start];
				if (num < 0) {
					break;
				}
				left *= num;
				start++;
			}
			while (start <= end) {
				int num = nums[end];
				if (num < 0) {
					break;
				}
				right *= num;
				end--;
			}
			if (nCnt == 1) {
				return left > right ? left : right;
			}
			// System.out.println(start + "\t" + end);
			int mid = 1;
			for (int i = start + 1; i <= end - 1; i++) {
				mid *= nums[i];
			}
			return left * nums[start] * mid > mid * nums[end] * right ? left * nums[start] * mid : mid * nums[end] * right;
		}
	}

	public int maxProduct(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int start = 0;
		int nCnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (max < 0) {
					max = 0;
				}
				int cMax = this.maxProduct(nums, start, i - 1, nCnt);
				if (cMax > max) {
					max = cMax;
				}
				nCnt = 0;
				start = i + 1;
			} else if (nums[i] < 0) {
				nCnt++;
			}
		}
		int cMax = this.maxProduct(nums, start, nums.length - 1, nCnt);
		if (cMax > max) {
			max = cMax;
		}
		return max;
	}

	public static void main(String... strings) {
		Q152 q = new Q152();
		int[] nums1 = { 1, 2, 3 };
		System.out.println(q.maxProduct(nums1));
		int[] nums2 = { -1, -2, -3 };
		System.out.println(q.maxProduct(nums2));
		int[] nums3 = { 2, 3, -2, 4 };
		System.out.println(q.maxProduct(nums3));
		int[] nums4 = { 2, 3, -2, 4, 0, 1, 2, 3, -1, 3, -4, 0, 1 };
		System.out.println(q.maxProduct(nums4));
		int[] nums5 = { 2, 3, -2, 4, 0, 1, -1, 3, -4, 2, -5, 1, 0, 1 };
		System.out.println(q.maxProduct(nums5));
		int[] nums6 = { -2, -3, 0 };
		System.out.println(q.maxProduct(nums6));
		int[] nums7 = { -2, 0, -3 };
		System.out.println(q.maxProduct(nums7));
		int[] nums8 = { -2, 0, -3, 0, 1 };
		System.out.println(q.maxProduct(nums8));
		int[] nums9 = { -2};
		System.out.println(q.maxProduct(nums9));
	}
}
