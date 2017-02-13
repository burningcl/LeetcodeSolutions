package com.skyline.leetcode.solution;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/
 * Created by chenliang on 2017/2/10.
 */
public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new int[0];
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[nums.length - 1]) {
                stack.push(nums[i]);
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            int val = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
            nums[i] = val;
        }
        return nums;
    }
}
