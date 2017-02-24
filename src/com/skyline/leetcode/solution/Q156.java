package com.skyline.leetcode.solution;

/**
 * Binary Tree Upside Down
 * https://leetcode.com/problems/binary-tree-upside-down/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q156 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return this.upsideDownBinaryTree(root, null);
    }

    public TreeNode upsideDownBinaryTree(TreeNode curNode, TreeNode parent) {
        if (curNode == null) {
            return null;
        }
        TreeNode convertLeft = this.upsideDownBinaryTree(curNode.left, curNode);
        if (parent != null) {
            curNode.left = parent.right;
        }
        curNode.right = parent;
        return convertLeft == null ? curNode : convertLeft;
    }
}
