package com.skyline.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huasong.cl
 */
public class Q872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = this.getLeafQueue(root1, new LinkedList<>());
        return this.checkLeafQueue(root2, queue) && queue.isEmpty();
    }

    private Queue<TreeNode> getLeafQueue(TreeNode root, Queue<TreeNode> queue) {
        if (root.left == null && root.right == null) {
            queue.offer(root);
            return queue;
        }
        if (root.left != null) {
            this.getLeafQueue(root.left, queue);
        }
        if (root.right != null) {
            this.getLeafQueue(root.right, queue);
        }
        return queue;
    }

    private boolean checkLeafQueue(TreeNode root, Queue<TreeNode> queue) {
        if (root.left == null && root.right == null) {
            if (queue.isEmpty()) {
                return false;
            } else {
                return queue.poll().val == root.val;
            }
        }
        if (root.left != null && !checkLeafQueue(root.left, queue)) {
            return false;
        }
        if (root.right != null && !checkLeafQueue(root.right, queue)) {
            return false;
        }
        return true;
    }

}
