package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * 
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author jairus
 * 
 */
public class Q128 {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}
		int max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			for (int i = 0;; i++) {
				int n = num + i;
				if (!set.contains(n) || map.containsKey(n)) {
					int c = !set.contains(n) ? 0 : map.get(n);
					for (int j = 0; j < i; j++) {
						map.put(num + j, i - j + c);
					}
					if (i + c > max) {
						max = i + c;
					}
					break;
				}
			}
		}
		return max;
	}
	
	public static void main(String...strings){
		long t1=System.currentTimeMillis();
		Q128 q=new Q128();
		int[] nums={0,1,2,3,4};
		System.out.println(q.longestConsecutive(nums));
		int[] nums1={7,5,0,1,2,3,4,9,10};
		System.out.println(q.longestConsecutive(nums1));
		int[] nums2={8,7,6,5,4,3,2,1};
		System.out.println(q.longestConsecutive(nums2));
		int[] nums3={100, 4, 200, 1, 3, 2};
		System.out.println(q.longestConsecutive(nums3));
		long t2=System.currentTimeMillis();
System.out.println("cost: "+(t2-t1));		
	}
}
