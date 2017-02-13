package com.skyline.leetcode.solution;


import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 * Created by chenliang on 2017/2/7.
 */
public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        } else if (k == 1) {
            return nums;
        }
        int[] maxs = new int[nums.length - k + 1];
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                maxs[i - k] = list.getFirst();
                if (list.getFirst() == nums[i - k]) {
                    list.removeFirst();
                }
            }
            while (!list.isEmpty() && list.getLast() < nums[i]) {
                list.removeLast();
            }
            list.addLast(nums[i]);
        }
        maxs[nums.length - k] = list.getFirst();
        return maxs;
    }
}
