package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Created by chenliang on 2017/1/26.
 */
public class Q124 {


//    public int maxPathSum(TreeNode root) {
//        if (root == null) {
//            return Integer.MIN_VALUE;
//        }
//        return Math.max(
//                Math.max(
//                        maxPathSum(root.left),
//                        maxPathSum(root.right)
//                ),
//                maxPathLength(root.left) + root.val + maxPathLength(root.right)
//        );
//    }
//
//    Map<TreeNode, Integer> cache = new HashMap<>();
//
//    public int maxPathLength(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else if (cache.containsKey(root)) {
//            return cache.get(root);
//        }
//        int ret = Math.max(0,
//                Math.max(
//                        this.maxPathLength(root.left),
//                        this.maxPathLength(root.right)
//                ) + root.val
//        );
//        cache.put(root, ret);
//        return ret;
//    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }


    public int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = this.dfs(root.left);
        left = left > 0 ? left : 0;
        int right = this.dfs(root.right);
        right = right > 0 ? right : 0;
        int len = left + right + root.val;
        if (max < len) {
            max = len;
        }

        return Math.max(left, right) + root.val;
    }
}
