package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Duplicates in an Array
 * <p>
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * <p>
 * Created by jairus on 2016/12/29.
 */
public class Q442 {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return list;
        }

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != nums[nums[i] - 1]) {
                int t = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[t - 1] = t;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }

        return list;
    }

}
