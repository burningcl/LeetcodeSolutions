package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Find Mode in Binary Search Tree
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * Created by chenliang on 2017/2/5.
 */
public class Q501 {

    List<Integer> list = new ArrayList<>();

    int maxCnt = 0;

    int curNum = 0;

    int curCnt = 0;

    public int[] findMode(TreeNode root) {
        this.findModeIn(root);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public void findModeIn(TreeNode root) {
        if (root == null) {
            return;
        }
        this.findModeIn(root.left);
        if (curNum == root.val) {
            curCnt++;
        } else {
            curNum = root.val;
            curCnt = 1;
        }
        if (curCnt == maxCnt) {
            list.add(curNum);
        } else if (curCnt > maxCnt) {
            list.clear();
            list.add(curNum);
            maxCnt = curCnt;
        }
        this.findModeIn(root.right);
    }

}
