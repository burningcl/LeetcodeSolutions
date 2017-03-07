package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Optimal Account Balancing
 * https://leetcode.com/problems/optimal-account-balancing/?tab=Description
 * Created by chenliang on 2017/3/2.
 */
public class Q465 {


    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length <= 0) {
            return 0;
        } else if (transactions.length <= 1) {
            return 1;
        }
        int maxIndex = 0;
        for (int i = 0; i < transactions.length; i++) {
            int[] trans = transactions[i];
            maxIndex = Integer.max(Integer.max(trans[0], trans[1]), maxIndex);
        }
        int[] accounts = new int[maxIndex + 1];
        for (int i = 0; i < transactions.length; i++) {
            int[] trans = transactions[i];
            accounts[trans[0]] -= trans[2];
            accounts[trans[1]] += trans[2];
        }
        Map<String, Integer> cache = new HashMap<>();
        return this.minTransfers(accounts, cache);
    }

    public int minTransfers(int[] accounts, Map<String, Integer> cache) {
        int negativeCnt = 0;
        int positiveCnt = 0;
        int lastPositiveIndex = -1;
        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] < 0) {
                negativeCnt++;
                keyBuilder.append(accounts[i] + ";");
            } else if (accounts[i] > 0) {
                positiveCnt++;
                lastPositiveIndex = i;
                keyBuilder.append(accounts[i] + ";");
            }
        }
        String key = keyBuilder.toString();
        if (lastPositiveIndex == -1) {
            return 0;
        } else if (positiveCnt == 1 || negativeCnt == 1) {
            return Integer.max(positiveCnt, negativeCnt);
        }
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int val = accounts[lastPositiveIndex];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int curVal = accounts[i];
            if (curVal >= 0) {
                continue;
            }
            if (-curVal > val) {
                accounts[i] += val;
                accounts[lastPositiveIndex] = 0;
                min = Integer.min(min, this.minTransfers(accounts, cache));
                accounts[i] -= val;
                accounts[lastPositiveIndex] = val;
            } else {
                accounts[i] = 0;
                accounts[lastPositiveIndex] += curVal;
                min = Integer.min(min, this.minTransfers(accounts, cache));
                accounts[i] = curVal;
                accounts[lastPositiveIndex] -= curVal;
            }
        }
        cache.put(key, min + 1);
        return min + 1;
    }

}
