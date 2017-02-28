package com.skyline.leetcode.solution;

/**
 * Count Univalue Subtrees
 * https://leetcode.com/problems/count-univalue-subtrees/?tab=Description
 * Created by chenliang on 2017/2/25.
 */
public class Q250 {

    int cnt = 0;

    public int countUnivalSubtrees(TreeNode root) {
        cnt = 0;
        this.countUnivalSubtreesInternal(root);
        return cnt;
    }

    protected long countUnivalSubtreesInternal(TreeNode root) {
        if (root == null) {
            return Long.MIN_VALUE;
        }
        long left = this.countUnivalSubtrees(root.left);
        long right = this.countUnivalSubtrees(root.right);
        long ret = Long.MAX_VALUE;
        if ((left == root.val || left == Long.MIN_VALUE) && (right == root.val || right == Long.MIN_VALUE)) {
            ret = root.val;
            cnt++;
        }
        return ret;
    }

}
