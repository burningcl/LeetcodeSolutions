package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Most Frequent Subtree Sum
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * Created by chenliang on 2017/2/10.
 */
public class Q508 {

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        this.findFrequentTreeSum(root, map);
        System.out.println(map);
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max > entry.getValue()) {
                continue;
            } else if (max < entry.getValue()) {
                list.clear();
                max = entry.getValue();
            }
            list.add(entry.getKey());
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = this.findFrequentTreeSum(root.left, map)
                + root.val
                + this.findFrequentTreeSum(root.right, map);
        int cnt = map.getOrDefault(sum, 0);
        map.put(sum, cnt + 1);
        return sum;
    }
}
