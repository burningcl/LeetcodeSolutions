package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Increasing Subsequences
 * https://leetcode.com/problems/increasing-subsequences/
 * Created by chenliang on 2017/1/23.
 */
public class Q491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                List<Integer> curListj = ret.get(j);
                if (curListj.get(curListj.size() - 1) <= cur) {
                    List<Integer> curList = new ArrayList<>();
                    curList.addAll(curListj);
                    curList.add(cur);
                    if (!set.contains(curList)) {
                        ret.add(curList);
                        set.add(curList);
                    }
                }
            }
            List<Integer> curList = new ArrayList<>();
            curList.add(cur);
            ret.add(curList);
        }
        ret.clear();
        ret.addAll(set);
        return ret;
    }

}
