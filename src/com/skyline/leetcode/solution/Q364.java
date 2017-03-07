package com.skyline.leetcode.solution;

import java.util.List;

/**
 * Nested List Weight Sum II
 * https://leetcode.com/problems/nested-list-weight-sum-ii/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q364 {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() <= 0) {
            return 0;
        }
        int maxDepth = this.findMaxDepth(nestedList);
        return this.depthSumInverse(nestedList, maxDepth);
    }

    public int depthSumInverse(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger integer = nestedList.get(i);
            if (integer.isInteger()) {
                sum += integer.getInteger() * depth;
            } else {
                sum += depthSumInverse(integer.getList(), depth - 1);
            }
        }
        return sum;
    }

    public int findMaxDepth(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger integer = nestedList.get(i);
            if (!integer.isInteger()) {
                max = Integer.max(max, findMaxDepth(integer.getList()));
            }
        }
        return max + 1;
    }

}
