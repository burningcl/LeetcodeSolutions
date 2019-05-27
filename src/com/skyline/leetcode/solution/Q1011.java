package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1011 {

    public int shipWithinDays(int[] weights, int D) {
        int low = 1;
        int high = 50000 * 500;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (canShip(weights, D, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    public boolean canShip(int[] weights, final int D, final int mid) {
        int sum = 0;
        int cnt = 1;
        for (int weight : weights) {
            if (weight > mid) {
                return false;
            }
            sum += weight;
            if (sum > mid) {
                cnt++;
                sum = weight;
            }
        }
        return cnt <= D;
    }

    public static void main(String... args) {
        int[] weights = {1, 2, 3, 1, 1};
        int D = 4;
        System.out.println(new Q1011().shipWithinDays(weights, D));
    }


}
