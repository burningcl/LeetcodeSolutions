package com.skyline.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 * <p>
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * <p>
 * Created by chenliang on 2017/1/26.
 */
public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length || k < 1) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

}
