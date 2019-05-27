package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * @author huasong.cl
 */
public class Q1022 {

    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    public int sumRootToLeaf(TreeNode root, int cur) {
        cur = (cur << 1) + root.val;
        int sum = 0;
        if (root.left == null && root.right == null) {
            sum = cur;
        } else {
            if (root.left != null) {
                sum += sumRootToLeaf(root.left, cur);
            }
            if (root.right != null) {
                sum += sumRootToLeaf(root.right, cur);
            }
        }
        return sum;
    }

}
