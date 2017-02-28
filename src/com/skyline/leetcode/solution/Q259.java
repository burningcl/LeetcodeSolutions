package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * 3Sum Smaller
 * https://leetcode.com/problems/3sum-smaller/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q259 {

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int len = nums.length;

        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    }

}
