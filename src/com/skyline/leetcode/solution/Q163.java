package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Missing Ranges
 * https://leetcode.com/problems/missing-ranges/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            addRange(lower, upper, res);
            return res;
        }

        long low = Integer.min(lower, nums[0]);
        long up = Integer.max(upper, nums[nums.length - 1]);

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            if (num < low) {

            } else if (num == low) {
                low = num + 1;
            } else if (num > low && num < up) {
                addRange(low, num - 1, res);
                low = num + 1;
            } else if (num == up) {
                addRange(low, num - 1, res);
                return res;
            } else if (num > up) {
                addRange(low, up, res);
                return res;
            }
        }
        addRange(low, up, res);
        return res;
    }

    public void addRange(long lower, long upper, List<String> res) {
        String str = null;
        if (lower == upper) {
            str = String.valueOf(lower);
        } else if (lower < upper) {
            str = lower + "->" + upper;
        }
        if (str != null) {
            res.add(str);
        }
    }

}
