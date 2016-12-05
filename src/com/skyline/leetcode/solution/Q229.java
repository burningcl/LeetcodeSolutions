package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority Element II
 * 
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * @author jairus
 *
 */
public class Q229 {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length <= 0) {
			return list;
		}
		int num1 = 0;
		int cnt1 = 0;
		int num2 = 0;
		int cnt2 = 0;
		for (int num : nums) {
			if (num == num1) {
				cnt1++;
			} else if (num == num2) {
				cnt2++;
			} else if (cnt1 <= 0) {
				num1 = num;
				cnt1 = 1;
			} else if (cnt2 <= 0) {
				num2 = num;
				cnt2 = 1;
			} else {
				cnt1--;
				cnt2--;
			}
		}
		cnt1 = 0;
		cnt2 = 0;
		for (int num : nums) {
			if (num == num1) {
				cnt1++;
			} else if (num == num2) {
				cnt2++;
			}
		}
		if (cnt1 > nums.length / 3) {
			list.add(num1);
		}
		if (cnt2 > nums.length / 3) {
			list.add(num2);
		}
		return list;
	}

	public static void main(String... strings) {
		Q229 q=new Q229();
		
		int[] nums1={1,1,2};
		System.out.println(q.majorityElement(nums1));
		
		int[] nums2={1,1,2,2,3};
		System.out.println(q.majorityElement(nums2));
		
		int[] nums3={1,2,3,1,2};
		System.out.println(q.majorityElement(nums3));
		
		int[] nums4={1,2,3,2,3,4,3,4,5};
		System.out.println(q.majorityElement(nums4));
		
		int[] nums5={2,2,2,1,1,3,3,1};
		System.out.println(q.majorityElement(nums5));
	}
}
