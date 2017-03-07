package com.skyline.leetcode.solution;

/**
 * Sort Transformed Array
 * https://leetcode.com/problems/sort-transformed-array/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q360 {

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length <= 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = a * num * num + b * num + c;
        }
        if (nums.length <= 1) {
            return nums;
        }
        Boolean up = null;
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] > nums[i - 1]) {
                if (up == null) {
                    up = true;
                } else if (up == false) {
                    break;
                }
            } else {
                if (up == null) {
                    up = false;
                } else if (up == true) {
                    break;
                }
            }
        }
        // 所有的数字都是相等的
        if (up == null) {
            return nums;
        }
        if (!up) {
            reverse(nums, 0, i - 1);
        }
        // 变形后的数组，依然是有序的
        if (i >= nums.length) {
            return nums;
        }
        up = null;
        int j = i;
        i++;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] > nums[i - 1]) {
                up = true;
                break;
            } else {
                up = false;
                break;
            }
        }
        if (up != null && !up) {
            reverse(nums, j, nums.length - 1);
        }
        i = 0;
        int endi = j - 1;
        int endj = nums.length - 1;
        System.out.println("i: "+i+", endi: "+endi+", j: "+j+", endj: "+endj);
        for(int k=i;k<endi;k++){
            System.out.print(nums[k]+"\t");
        }
        System.out.println();
        for(int k=j;k<endj;k++){
            System.out.print(nums[k]+"\t");
        }
        System.out.println();
        int[] ret = new int[nums.length];
        int index = 0;
        while (i <= endi || j <= endj) {
            if (i > endi) {
                ret[index] = nums[j++];
            } else if (j > endj) {
                ret[index] = nums[i++];
            } else {
                if (nums[i] < nums[j]) {
                    ret[index] = nums[i++];
                } else {
                    ret[index] = nums[j++];
                }
            }
            index++;
        }
        return ret;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }

}
