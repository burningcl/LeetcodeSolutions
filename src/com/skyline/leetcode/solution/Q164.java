package com.skyline.leetcode.solution;

import java.util.PriorityQueue;

/**
 * Maximum Gap
 * https://leetcode.com/problems/maximum-gap/
 * Created by chenliang on 2017/2/14.
 */
public class Q164 {

//    public int maximumGap(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return 0;
//        }
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < min) {
//                min = nums[i];
//            }
//            if (nums[i] > max) {
//                max = nums[i];
//            }
//        }
//        int arraySize = max - min + 1;
//        boolean[] array = new boolean[arraySize];
//        for (int i = 0; i < nums.length; i++) {
//            array[nums[i] - min] = true;
//        }
//        int preIndex = 0;
//        int maxGap = 0;
//        for (int i = 0; i < arraySize; i++) {
//            if (array[i]) {
//                int gap = i - preIndex;
//                if (gap > maxGap) {
//                    maxGap = gap;
//                }
//                preIndex = i;
//            }
//        }
//        return maxGap;
//    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int preVal = queue.poll();
        int maxGap = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int curVal = queue.poll();
            if (curVal - preVal > maxGap) {
                maxGap = curVal - preVal;
            }
            preVal = curVal;
        }
        return maxGap;
    }

}
