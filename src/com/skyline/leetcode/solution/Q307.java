package com.skyline.leetcode.solution;

/**
 * 
 * Range Sum Query - Mutable
 * 
 * https://leetcode.com/problems/range-sum-query-mutable/
 * 
 * @author jairus
 *
 */
public class Q307 {
	public static class NumArray {
		int[] nums;

		int numsLen = 0;

		TreeNode root;

		public TreeNode build(int[] nums, int low, int high) {
			if (low == high) {
				return new TreeNode(nums[low]);
			}
			int mid = (low + high) / 2;
			TreeNode left = this.build(nums, low, mid);
			TreeNode right = this.build(nums, mid + 1, high);
			TreeNode root = new TreeNode(left.val + right.val);
			root.left = left;
			root.right = right;
			return root;
		}

		public NumArray(int[] nums) {
			this.nums = nums;
			if (nums != null && nums.length > 0) {
				numsLen = nums.length;
				this.root = this.build(nums, 0, nums.length - 1);
			}
		}

		void upate(TreeNode root, int low, int high, int i, int div) {
			if (i < low || i > high) {
				return;
			}
			// System.out.println(low + ", " + high + ", " + i);
			root.val += div;
			int mid = (low + high) / 2;
			if (root.left != null)
				this.upate(root.left, low, mid, i, div);
			if (root.right != null)
				this.upate(root.right, mid + 1, high, i, div);
		}

		void update(int i, int val) {
			if (i < 0 || i >= numsLen) {
				return;
			}
			int div = val - nums[i];
			nums[i] = val;
			this.upate(root, 0, nums.length - 1, i, div);
		}

		public int sumRange(TreeNode root, int low, int high, int i, int j) {
			System.out.println(low + ", " + high + ", " + i + ", " + j);
			if (i == low && j == high) {
				return root.val;
			} else if (j < low || i > high) {
				return 0;
			}
			int mid = (low + high) / 2;
			if (mid >= j) {
				return this.sumRange(root.left, low, mid, i, j);
			} else if (mid + 1 < i) {
				return this.sumRange(root.right, mid + 1, high, i, j);
			} else {
				return this.sumRange(root.left, low, mid, i, mid)
						+ this.sumRange(root.right, mid + 1, high, mid + 1, j);
			}
		}

		public int sumRange(int i, int j) {
			if (i < 0) {
				i = 0;
			}
			if (j >= numsLen) {
				j = numsLen - 1;
			}
			return this.sumRange(root, 0, nums.length - 1, i, j);
		}
	}

	public static void main(String... strings) {
		int[] nums = { 1, 3, 5 };
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 1) == 4);
		System.out.println(numArray.sumRange(0, 2) == 9);
		System.out.println(numArray.sumRange(1, 2) == 8);
		System.out.println(numArray.sumRange(0, 0) == 1);
		System.out.println(numArray.sumRange(1, 1) == 3);
		System.out.println(numArray.sumRange(2, 2) == 5);
		numArray.update(1, 10);
		System.out.println(numArray.sumRange(0, 1) == 11);
		System.out.println(numArray.sumRange(0, 2) == 16);
		System.out.println(numArray.sumRange(1, 2) == 15);
		System.out.println(numArray.sumRange(0, 0) == 1);
		System.out.println(numArray.sumRange(1, 1) == 10);
		System.out.println(numArray.sumRange(2, 2) == 5);
	}

}
