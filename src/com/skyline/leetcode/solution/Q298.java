package com.skyline.leetcode.solution;

/**
 * Binary Tree Longest Consecutive Sequence
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q298 {


    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxLen = 1;
        this.longestConsecutive(root.left, root, 1);
        this.longestConsecutive(root.right, root, 1);
        return maxLen;
    }

    private int maxLen = 0;

    public void longestConsecutive(TreeNode root, TreeNode parent, int curLen) {
        if (root == null) {
            return;
        }
        if (root.val == parent.val + 1) {
            curLen++;
        } else {
            curLen = 1;
        }
        if (curLen > maxLen) {
            maxLen = curLen;
        }
        this.longestConsecutive(root.left, root, curLen);
        this.longestConsecutive(root.right, root, curLen);
    }

}
