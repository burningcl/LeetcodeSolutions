package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * @author huasong.cl
 */
public class Q1026 {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        ArrayDeque<Integer> minStack = new ArrayDeque<>();
        maxStack.push(root.val);
        minStack.push(root.val);
        return this.maxAncestorDiff(root, maxStack, minStack, 0);
    }

    public int maxAncestorDiff(TreeNode root, ArrayDeque<Integer> maxStack, ArrayDeque<Integer> minStack, int max) {
        if (root == null) {
            return 0;
        }
        maxStack.push(Integer.max(maxStack.peek(), root.val));
        minStack.push(Integer.min(minStack.peek(), root.val));
        max = Integer.max(max, maxStack.peek() - minStack.peek());
        max = Integer.max(
                max,
                maxAncestorDiff(root.left, maxStack, minStack, max)
        );
        max = Integer.max(
                max,
                maxAncestorDiff(root.right, maxStack, minStack, max)
        );
        maxStack.pop();
        minStack.pop();
        return max;
    }

}
