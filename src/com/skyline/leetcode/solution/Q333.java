package com.skyline.leetcode.solution;

/**
 * Largest BST Subtree
 * https://leetcode.com/problems/largest-bst-subtree/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q333 {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.largestBSTSubtreeImpl(root);
        return largestSubTree;
    }

    private int largestSubTree = 0;

    class Result {
        boolean isBST;
        int nodeCnt;
        int min;
        int max;
    }

    public Result largestBSTSubtreeImpl(TreeNode root) {
        Result result = new Result();
        result.nodeCnt = 1;
        result.isBST = true;
        result.min = root.val;
        result.max = root.val;
        if (root.left != null) {
            Result left = this.largestBSTSubtreeImpl(root.left);
            if (left.isBST && left.max < root.val) {
                result.nodeCnt += left.nodeCnt;
                result.min = left.min;
            } else {
                result.isBST = false;
            }
        }
        if (root.right != null) {
            Result right = this.largestBSTSubtreeImpl(root.right);
            if (result.isBST && right.isBST && right.min > root.val) {
                result.nodeCnt += right.nodeCnt;
                result.max = right.max;
            } else {
                result.isBST = false;
            }
        }
        if (result.isBST && result.nodeCnt > largestSubTree) {
            largestSubTree = result.nodeCnt;
        }
        return result;
    }
}
