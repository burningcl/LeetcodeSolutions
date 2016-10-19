package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Addresses
 * 
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 * @author jairus
 *
 */
public class Q93 {

	public void restoreIpAddresses(final int[] s, final int sIndex, final int[] nums, final int nIndex,
			final List<String> list) {
		int sRestLen = s.length - sIndex;
		int nRestLen = 4 - nIndex;
		if (sRestLen < nRestLen || sRestLen > nRestLen * 3) {
			return;
		}
		// 最后一个数字
		if (nIndex >= 3) {
			//00或者01这种情况
			if (s[sIndex] == 0 && sRestLen > 1) {
				return;
			}
			int num = 0;
			for (int i = sIndex; i < s.length; i++) {
				num = num * 10 + s[i];
			}
			// 不合法
			if (num > 255) {
				return;
			}
			
			String ip = "";
			for (int i = 0; i < nums.length; i++) {
				ip += nums[i] + ".";
			}
			ip += num;
			list.add(ip);
			return;
		}
		int num = 0;
		for (int i = 0; sIndex + i < s.length; i++) {
			num = num * 10 + s[sIndex + i];
			if (num > 255) {
				return;
			}
			nums[nIndex] = num;
			this.restoreIpAddresses(s, sIndex + i + 1, nums, nIndex + 1, list);
			if (s[sIndex] == 0) {
				return;
			}
		}
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		if (s == null || s.length() <= 0) {
			return list;
		}
		int[] ss = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ss[i] = s.charAt(i) - '0';
		}
		this.restoreIpAddresses(ss, 0, new int[3], 0, list);
		return list;
	}

	public static void main(String[] args) {
		Q93 q = new Q93();
		System.out.println(q.restoreIpAddresses("255255255255"));
		System.out.println(q.restoreIpAddresses("111111"));
		System.out.println(q.restoreIpAddresses("00000"));
		System.out.println(q.restoreIpAddresses("010010"));
	}

}
