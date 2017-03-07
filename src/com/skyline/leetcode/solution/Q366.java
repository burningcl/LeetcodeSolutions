package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Leaves of Binary Tree
 * https://leetcode.com/problems/find-leaves-of-binary-tree/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q366 {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        this.findLeaves(root, list);
        return list;
    }

    public int findLeaves(TreeNode root, List<List<Integer>> list) {
        if (root == null) {
            return -1;
        }
        int leftDepth = this.findLeaves(root.left, list);
        int rightDepth = this.findLeaves(root.right, list);
        int depth = Integer.max(leftDepth, rightDepth) + 1;
        List<Integer> subList = null;
        if (list.size() <= depth) {
            subList = new ArrayList<>();
            list.add(depth, subList);
        } else {
            subList = list.get(depth);
        }
        subList.add(root.val);
        return depth;
    }

}
