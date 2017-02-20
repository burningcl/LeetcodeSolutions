package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Sliding Window Median
 * https://leetcode.com/problems/sliding-window-median/
 * Created by chenliang on 2017/2/15.
 */
public class Q480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return new double[0];
        }
        int mediansLen = nums.length - k + 1;
        double[] medians = new double[mediansLen];
        long median = 0;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            treeSet.add(key(nums, i));
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < (k - 1) / 2; i++) {
            list.add(treeSet.pollFirst());
        }
        median = treeSet.first();
        if (k % 2 == 1) {
            medians[0] = value(median);
        } else {
            medians[0] = (value(median) + value(treeSet.higher(median))) / 2;
        }
        treeSet.addAll(list);


        for (int i = k; i < nums.length; i++) {
            long key = key(nums, i);
            long keyPop = key(nums, i - k);
            treeSet.add(key);
            if ((key > median && keyPop < median)) {
                median = treeSet.higher(median);
            } else if (key < median && keyPop > median) {
                median = treeSet.lower(median);
            } else if (keyPop == median) {
                if (key < median) {
                    median = treeSet.lower(median);
                } else {
                    median = treeSet.higher(median);
                }
            }
            treeSet.remove(keyPop);
            if (k % 2 == 1) {
                medians[i - k + 1] = value(median);
            } else {
                medians[i - k + 1] = (value(median) + value(treeSet.higher(median))) / 2;
            }
        }
        return medians;
    }

    long key(int[] nums, int index) {
        if (nums[index] >= 0) {
            return (((long) nums[index]) << 31) + index;
        } else {
            return -(((-(long) nums[index]) << 31) + nums.length - index);
        }
    }

    double value(long key) {
        if (key > 0) {
            return key >> 31;
        } else {
            return -((-key) >> 31);
        }
    }
}
