package com.skyline.leetcode.solution;

/**
 * Closest Binary Search Tree Value
 * https://leetcode.com/problems/closest-binary-search-tree-value/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q270 {
    int closest;

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        closest = root.val;
        this.closestValueImpl(root, target);
        return closest;
    }

    public void closestValueImpl(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }
        if (root.val > target) {
            this.closestValueImpl(root.left, target);
        } else {
            this.closestValueImpl(root.right, target);
        }
    }
}
