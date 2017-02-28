package com.skyline.leetcode.solution.contest21;

import com.skyline.leetcode.solution.TreeNode;

/**
 * Minimum Absolute Difference in BST
 * https://leetcode.com/contest/leetcode-weekly-contest-21/problems/minimum-absolute-difference-in-bst/
 * Created by chenliang on 2017/2/26.
 */
public class Q530 {

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        this.traversal(null, root);
        return min;
    }

    int min;

    public TreeNode traversal(TreeNode pre, TreeNode root) {
        if (root.left != null) {
            pre = this.traversal(pre, root.left);
        }
        if (pre != null && root != null) {
            min = Integer.min(min, root.val - pre.val);
        }
        if (root.right != null) {
            return this.traversal(root, root.right);
        }
        return root;
    }
}
