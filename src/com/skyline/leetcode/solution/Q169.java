package com.skyline.leetcode.solution;

/**
 * Majority Element
 * 
 * https://leetcode.com/problems/majority-element/
 * 
 * @author jairus
 * 
 */
public class Q169 {

	public int majorityElement(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int num = 0;
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			int cn = nums[i];
			if (cnt == 0) {
				cnt = 1;
				num = cn;
			} else if (cn == num) {
				cnt++;
			} else {
				cnt--;
			}
		}
		return num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums={1,2,3,1,1,2,1,1};
		Q169 q=new Q169();
		System.out.println(q.majorityElement(nums));
	}

}
