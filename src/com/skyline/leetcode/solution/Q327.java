package com.skyline.leetcode.solution;

/**
 * Count of Range Sum
 * https://leetcode.com/problems/count-of-range-sum/?tab=Description
 * Created by chenliang on 2017/2/16.
 */
public class Q327 {

    class TreeNode {

        long val;
        int cnt;
        int leftCnt;
        TreeNode left;
        TreeNode right;

        TreeNode(long val) {
            this.val = val;
            this.cnt = 1;

        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        long sum = nums[0];
        int totalCnt = 0;

        TreeNode root = new TreeNode(sum);
        if (sum >= lower && sum <= upper) {
            totalCnt = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            long lowerTarget = sum - upper;
            int lowerCnt = this.search(root, lowerTarget, 0, false);
            long upperTarget = sum - lower;
            int upperCnt = this.search(root, upperTarget, 0, true);
            totalCnt += (upperCnt - lowerCnt);
            if (sum >= lower && sum <= upper) {
                totalCnt++;
            }
            this.add(root, null, sum);
        }
        return totalCnt;
    }

    public int search(TreeNode root, long target, int total, boolean inclusive) {
        if (root == null) {
            return total;
        }
        if (root.val < target) {
            total += root.cnt + root.leftCnt;
            return this.search(root.right, target, total, inclusive);
        } else if (root.val > target) {
            return this.search(root.left, target, total, inclusive);
        } else {
            return inclusive ? total + root.cnt + root.leftCnt : total + root.leftCnt;
        }
    }

    public void add(TreeNode root, TreeNode parent, long val) {
        if (root == null) {
            if (val < parent.val) {
                parent.left = new TreeNode(val);
            } else {
                parent.right = new TreeNode(val);
            }
            return;
        }
        if (root.val < val) {
            this.add(root.right, root, val);
        } else if (root.val > val) {
            root.leftCnt++;
            this.add(root.left, root, val);
        } else {
            root.cnt++;
        }
    }
}
