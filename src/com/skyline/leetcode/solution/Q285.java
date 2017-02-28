package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * Inorder Successor in BST
 * https://leetcode.com/problems/inorder-successor-in-bst/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q285 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }
        if (p.right != null) {
            TreeNode cur = p.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            this.findP(root, p, stack);
            if (stack.isEmpty() || stack.size() <= 1) {
                return null;
            }
            TreeNode cur = stack.pop();
            TreeNode parent = stack.pop();
            while (!stack.isEmpty() && cur == parent.right) {
                cur = parent;
                parent = stack.pop();
            }
            if (cur == parent.right) {
                return null;
            } else {
                return parent;
            }
        }
    }

    public void findP(TreeNode root, TreeNode p, ArrayDeque<TreeNode> stack) {
        if (root == null) {
            return;
        }
        if (root.val > p.val) {
            stack.push(root);
            findP(root.left, p, stack);
        } else if (root.val < p.val) {
            stack.push(root);
            findP(root.right, p, stack);
        } else {
            stack.push(p);
        }
    }

}
