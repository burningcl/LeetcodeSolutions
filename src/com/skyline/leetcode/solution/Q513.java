package com.skyline.leetcode.solution;

/**
 * Find Bottom Left Tree Value
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * Created by chenliang on 2017/2/13.
 */
public class Q513 {

    private int bottomLevel = -1;

    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        this.findBottomLeftValue(root, 0);
        return value;
    }

    public void findBottomLeftValue(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (bottomLevel < level) {
            bottomLevel = level;
            value = root.val;
        }
        this.findBottomLeftValue(root.left, level + 1);
        this.findBottomLeftValue(root.right, level + 1);
    }

}
