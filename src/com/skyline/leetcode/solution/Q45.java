package com.skyline.leetcode.solution;

/**
 * Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 * Created by chenliang on 2017/2/8.
 */
public class Q45 {
//    public int jump(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return 0;
//        }
//        int lastIndex = nums.length - 1;
//        nums[lastIndex] = 0;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (nums[i] == 0) {
//                nums[i] = Integer.MAX_VALUE;
//            } else if (i + nums[i] >= lastIndex) {
//                nums[i] = 1;
//            } else {
//                int min = Integer.MAX_VALUE;
//                for (int j = i + nums[i]; j > i && min > 1; j--) {
//                    if (min > nums[j]) {
//                        min = nums[j];
//                    }
//                }
//                nums[i] = min == Integer.MAX_VALUE ? min : min + 1;
//            }
//        }
//        return nums[0];
//    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int lastIndex = nums.length - 1;
        int maxIndex = nums[0];
        int curIndex = 0;
        int jump = 1;
        while (maxIndex < lastIndex) {
            int max = 0;
            for (int i = curIndex + 1; i <= maxIndex; i++) {
                if (i + nums[i] > max) {
                    max = i + nums[i];
                }
            }
            if (max <= 0) {
                return -1;
            }
            curIndex = maxIndex;
            maxIndex = max;
            jump++;
        }
        return jump;
    }

}
