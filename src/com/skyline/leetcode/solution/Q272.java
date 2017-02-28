package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Closest Binary Search Tree Value II
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q272 {

    LinkedList<Integer> list;

    double target;

    int k;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.target = target;
        this.k = k;
        this.list = new LinkedList<>();
        this.closestKValuesImpl(root);
        return list;
    }

    public void closestKValuesImpl(TreeNode root) {
        if (root == null) {
            return;
        }
        this.closestKValuesImpl(root.left);
        int val = root.val;
        if (list.size() < k) {
            list.add(val);
        } else {
            if (Math.abs(list.get(0) - target) > Math.abs(val - target)) {
                list.removeFirst();
                list.add(val);
            } else {
                return;
            }
        }
        this.closestKValuesImpl(root.right);
    }

}
