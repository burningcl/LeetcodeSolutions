package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        long sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;
        long curSum = 0;
        int partCnt = 0;
        for (int a : A) {
            curSum += a;
            if (curSum == sum) {
                partCnt++;
                curSum = 0;
            }
        }
        return partCnt >= 3;
    }


}
