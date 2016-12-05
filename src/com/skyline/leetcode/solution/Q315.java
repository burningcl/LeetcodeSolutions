package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Count of Smaller Numbers After Self
 * 
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * @author jairus
 *
 */
public class Q315 {

	class Node {
		int low = 0;
		int high = 0;
		int val;
		Node left;
		Node right;

		public String toString() {
			return "{low: " + low + ", high: " + high + ", val: " + val + "}";
		}
	}

	public int countSmaller(Node root, int target) {
		//System.out.println(root + ", " + target);
		if (root == null) {
			return 0;
		} else if (root.high <= target) {
			return root.val;
		} else if (root.low > target) {
			return 0;
		}
		root.val++;
		return this.countSmaller(root.left, target) + this.countSmaller(root.right, target);
	}

	protected Node build(int[] nums) {
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		for (int i = 0; i < nums.length;) {
			Node cur = new Node();
			cur.low = nums[i];
			int j = i + 1;
			for (; j < nums.length && nums[j] == nums[i]; j++) {
			}
			if (j >= nums.length) {
				break;
			}
			cur.high = nums[j];
			q1.add(cur);
			i = j;
		}
		while (!q1.isEmpty()) {
			Node left = q1.poll();
			if (!q1.isEmpty()) {
				Node right = q1.poll();
				Node cur = new Node();
				cur.low = left.low;
				cur.high = right.high;
				cur.left = left;
				cur.right = right;
				q2.add(cur);
			} else {
				q2.add(left);
			}
			if (q1.isEmpty()) {
				if (q2.size() == 1) {
					return q2.poll();
				} else {
					q1 = q2;
					q2 = new LinkedList<>();
				}
			}
		}
		return null;
	}

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new LinkedList<>();
		if (nums == null || nums.length <= 0) {
			return list;
		}

		long t1 = System.currentTimeMillis();
		int[] nums1 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums1);
		long t2 = System.currentTimeMillis();
		Node root = this.build(nums1);
		long t3 = System.currentTimeMillis();

		for (int i = nums.length - 1; i >= 0; i--) {
			list.add(0, countSmaller(root, nums[i]));
		}
		long t4 = System.currentTimeMillis();
		System.out.println((t2 - t1) + ", " + (t3 - t2) + ", " + (t4 - t3));
		return list;
	}

	public static void main(String[] args) {
		Q315 q = new Q315();
		int[] nums = { 5, 2, 6, 1 };
		System.out.println(q.countSmaller(nums));
	}

}
