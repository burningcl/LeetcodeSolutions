package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Created by chenliang on 2017/2/13.
 */
public class Q515 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        this.largestValues(root, 0);
        return list;
    }

    public void largestValues(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (list.size() <= level) {
            list.add(root.val);
        } else if (list.get(level) < root.val) {
            list.set(level, root.val);
        }
        level++;
        this.largestValues(root.left, level);
        this.largestValues(root.right, level);
    }

}
