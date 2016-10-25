package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum III
 * 
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * @author jairus
 *
 */
public class Q437 {

	public int pathSum(final TreeNode root, final int sum, final List<Integer> vals) {
		if (root == null) {
			return 0;
		}
		int cnt = 0;
		if (root.val == sum) {
			cnt++;
		}
		int sSum = root.val;
		for (int i = vals.size() - 1; i >= 0; i--) {
			sSum += vals.get(i);
			if (sSum == sum) {
				cnt++;
			}
		}
		vals.add(root.val);
		cnt = cnt + pathSum(root.left, sSum, vals) + pathSum(root.right, sSum, vals);
		vals.remove(vals.size() - 1);
		return cnt;
	}

	public int pathSum(TreeNode root, int sum) {
		return this.pathSum(root, sum, new ArrayList<>());
	}
}
