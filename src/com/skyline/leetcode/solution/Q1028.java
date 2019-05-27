package com.skyline.leetcode.solution;

import java.util.*;

/**
 * @author huasong.cl
 */
public class Q1028 {

    public TreeNode recoverFromPreorder(String S) {
        TreeNode root = null;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); ) {
            int depth = 0;
            int value = 0;
            for (; i < S.length() && S.charAt(i) == '-'; i++) {
                depth++;
            }
            for (; i < S.length() && S.charAt(i) != '-'; i++) {
                value = value * 10 + S.charAt(i) - '0';
            }
            while (stack.size() > depth) {
                stack.pop();
            }
            TreeNode node = new TreeNode(value);
            if (stack.isEmpty()) {
                root = node;
            } else {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            stack.push(node);
        }
        return root;
    }


}
