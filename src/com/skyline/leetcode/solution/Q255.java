package com.skyline.leetcode.solution;

/**
 * Verify Preorder Sequence in Binary Search Tree
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q255 {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 0) {
            return true;
        }
        return this.verifyPreorder(preorder, 0, preorder.length - 1);
    }

    public boolean verifyPreorder(int[] preorder, int start, int end) {
        if (start == end) {
            return true;
        }
        int rootVal = preorder[start];
        int i = start + 1;
        for (; i <= end && preorder[i] < rootVal; i++) {
        }
        for (int j = i; j <= end; j++) {
            if (preorder[j] < rootVal) {
                return false;
            }
        }
        boolean isPreorder = true;
        if (i > start + 1) {
            isPreorder = this.verifyPreorder(preorder, start + 1, i - 1);
        }
        if (i <= end) {
            isPreorder &= this.verifyPreorder(preorder, i, end);
        }
        return isPreorder;
    }

}
