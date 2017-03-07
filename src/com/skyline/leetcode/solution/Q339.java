package com.skyline.leetcode.solution;

import java.util.List;

/**
 * Nested List Weight Sum
 * https://leetcode.com/problems/nested-list-weight-sum/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q339 {



    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    public int depthSum(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger nestedInteger = nestedList.get(i);
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            } else {
                sum += depthSum(nestedInteger.getList(), depth + 1);
            }
        }
        return sum;
    }

}
