package com.skyline.leetcode.solution;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-ii/
 * Created by chenliang on 2017/2/10.
 */
public class Q496 {

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (nums == null || findNums == null || nums.length <= 0 || findNums.length <= 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums[i], -1);
            } else {
                map.put(nums[i], stack.peek());
            }
            stack.push(nums[i]);
        }
        for (int i = 0; i < findNums.length; i++) {
            findNums[i] = map.get(findNums[i]);
        }
        return findNums;
    }


}
