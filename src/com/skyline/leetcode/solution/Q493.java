package com.skyline.leetcode.solution;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * Reverse Pairs
 * https://leetcode.com/contest/leetcode-weekly-contest-19/problems/reverse-pairs/
 * Created by chenliang on 2017/2/13.
 */
public class Q493 {

    long[] nums1;

    long[] nums2;

    int sum = 0;


    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        sum = 0;
        this.nums1 = new long[nums.length];
        this.nums2 = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i];
        }
        this.reversePairs(0, 0, nums.length - 1);
        return sum;
    }

    public void reversePairs(int level, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        int rightLow = mid + 1;
        this.reversePairs(level + 1, low, mid);
        this.reversePairs(level + 1, rightLow, high);
        long[] src;
        long[] dest;
        if (level % 2 == 0) {
            src = nums1;
            dest = nums2;
        } else {
            src = nums2;
            dest = nums1;
        }
        long num;
        int lt = rightLow;
        int ht;
        int mt;
        for (int i = low; i <= mid; i++) {
            num = src[i];
            lt = Integer.max(lt, rightLow);
            ht = high;
            while (lt <= ht) {
                mt = (lt + ht) / 2;
                if (src[mt] * 2 < num) {
                    lt = mt + 1;
                } else {
                    ht = mt - 1;
                }
            }
            if (lt > rightLow) {
                sum += lt - rightLow;
            }
        }
        int ii = low;
        int jj = rightLow;
        for (int i = low; i <= high; i++) {
            if (ii > mid) {
                dest[i] = src[jj++];
            } else if (jj > high) {
                dest[i] = src[ii++];
            } else {
                if (src[ii] < src[jj]) {
                    dest[i] = src[ii++];
                } else {
                    dest[i] = src[jj++];
                }
            }
        }
    }

//    public int reversePairs(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return 0;
//        }
//
//        int sum = 0;
//        Node root = new Node(nums[nums.length - 1] * 2l);
//
//        for (int i = nums.length - 2; i >= 0; i--) {
//            Node cur = root;
//            Node parent = null;
//            long target = nums[i];
//            while (cur != null) {
//                if (cur.val < target) {
//                    //System.out.println(cur.val +", "+target);
//                    sum += cur.leftCnt + cur.cnt;
//                    cur = cur.right;
//                } else if (cur.val == target) {
//                    sum += cur.leftCnt;
//                    break;
//                } else {
//                    cur = cur.left;
//                }
//            }
//            target = target * 2;
//            cur = root;
//            while (cur != null ) {
//                parent = cur;
//                if (cur.val < target) {
//                    cur = cur.right;
//                } else if (cur.val == target) {
//                    cur.cnt++;
//                    parent = null;
//                    break;
//                } else {
//                    cur.leftCnt++;
//                    cur = cur.left;
//                }
//            }
//            if (parent != null) {
//                if (parent.val < target) {
//                    parent.right = new Node(target);
//                } else {
//                    parent.left = new Node(target);
//                }
//            }
//        }
//        return sum;
//    }
//
//    class Node {
//        Node left;
//        Node right;
//        long val;
//        int cnt = 1;
//        int leftCnt=0;
//
//        public Node(long val) {
//            this.val = val;
//        }
//    }


    public static void main(String... strings) {
        Q493 q = new Q493();
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(q.reversePairs(nums));
        int[] nums1 = {-5, -5};
        System.out.println(q.reversePairs(nums1));
        int[] nums2 = {1, 3, 2, 3, 1};
        System.out.println(q.reversePairs(nums2));
//        System.out.println(-(long)Integer.MIN_VALUE);
    }
}
