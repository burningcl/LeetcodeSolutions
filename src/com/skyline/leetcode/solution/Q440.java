package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * K-th Smallest in Lexicographical Order
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/?tab=Description
 * Created by chenliang on 2017/2/18.
 */
public class Q440 {

    public int findKthNumber(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return -1;
        }
        return this.findKthNumberIn(0, 0, n, k);
    }

    private int findKthNumberIn(int root, int index, int n, int k) {
        if (index == k) {
            return root;
        }
        int i = root == 0 ? 1 : 0;
        root *= 10;
        for (; i < 10; i++) {
            int val = root + i;
            int numCnt = this.getNumCnt(val, n);
            if (numCnt + index < k) {
                index += numCnt;
            } else {
                return this.findKthNumberIn(val, index + 1, n, k);
            }
        }
        return -1;
    }

    private int getNumCnt(int root, final int n) {
        long min = root;
        int len = 1;
        int cnt = 0;
        while (min <= n) {
            long max = min + len - 1;
            if (n > max) {
                cnt += len;
            } else if (n <= max) {
                cnt += n - min + 1;
            }
            min *= 10;
            len *= 10;
        }
        // System.out.println(root + ": " + cnt);
        return cnt;
    }


}
