package com.skyline.leetcode.solution.contest20;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenliang on 2017/2/19.
 */
public class Q525 {

//    public int findMaxLength(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return 0;
//        }
//        int maxLen = 0;
//        int[][][] map = new int[nums.length][nums.length][2];
//        map[0][0][0] = nums[0] == 0 ? 1 : 0;
//        map[0][0][1] = nums[0] == 1 ? 1 : 0;
//        for (int i = 1; i < nums.length; i++) {
//            int n0 = nums[i] == 0 ? 1 : 0;
//            int n1 = nums[i] == 1 ? 1 : 0;
//            for (int j = 0; j < i; j++) {
//                map[j][i][0] = map[j][i - 1][0] + n0;
//                map[j][i][1] = map[j][i - 1][1] + n1;
//                if (map[j][i][0] == map[j][i][1] && map[j][i][1] > maxLen) {
//                    maxLen = map[j][i][1];
//                }
//            }
//        }
//        return maxLen*2;
//    }

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? 1 : -1);
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                if (len > maxLen) {
                    maxLen = len;
                }
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String... strings) {
        Q525 q = new Q525();
        int[] n1 = {0, 1};
        System.out.println(q.findMaxLength(n1));
        int[] n2 = {0, 1, 0};
        System.out.println(q.findMaxLength(n2));
        int[] n3 = {1, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(q.findMaxLength(n3));
        int[] n4 = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1};
        System.out.println(q.findMaxLength(n4));
        int[] n5 = {1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0};
        System.out.println(q.findMaxLength(n5));
    }
}
