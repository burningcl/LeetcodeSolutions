package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate
 * 
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * @author jairus
 *
 */
public class Q217 {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return false;
		}
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			int num=nums[i];
			if(!set.add(num)){
				return true;
			}
		}
		return false;
	}
}
