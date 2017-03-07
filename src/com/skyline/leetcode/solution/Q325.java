package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Maximum Size Subarray Sum Equals k
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q325 {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k == 0) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1);
        long sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            long target = sum - k;
            int index = map.getOrDefault(target, -2);
            if (index > -2 && index != i && i - index > max) {
                max = i - index;
            }
        }
        return max;
    }

}
