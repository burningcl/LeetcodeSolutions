package com.skyline.leetcode.solution;

/**
 * Split Array Largest Sum
 * 
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * @author jairus
 *
 */
public class Q410 {

	public int sum(final int[] nums, final int start, final int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += nums[i];
		}
		return sum;
	}

	public int splitArray(final int[] nums, final int start, final int end, int m) {
		int minMax = Integer.MAX_VALUE;
		if (m == 1) {
			minMax = this.sum(nums, start, end);
		} else if (m % 2 == 0) {
			int hm = m / 2;
			int sum = this.sum(nums, start, end);
			int left = this.sum(nums, start, start + hm - 2);
			int i = start + hm - 1;
			for (; i <= end - hm; i++) {
				left += nums[i];
				int right = sum - left;
				int max = Integer.max(left, right);
				if (minMax >= max) {
					minMax = max;
				} else {
					break;
				}
			}
			left = this.splitArray(nums, start, i - 1, hm);
			int right = this.splitArray(nums, i, end, hm);
			minMax = Integer.max(left, right);
		} else {
			int sum = 0;
			int hm = m - 1;
			for (int i = start; i <= end - hm; i++) {
				sum += nums[i];
				int right = this.splitArray(nums, i + 1, end, hm);
				int max = Integer.max(sum, right);
				if (minMax >= max) {
					minMax = max;
				} else {
					break;
				}
			}
		}
		return minMax;
	}

	public int splitArray(int[] nums, int m) {
		if (nums == null || nums.length < m) {
			return 0;
		}
		return this.splitArray(nums, 0, nums.length - 1, m);
	}

	// public int splitArray(int[] nums, int[][] cache, int start, final int
	// end, int m) {
	// if (m <= 0 || end - start + 1 < m) {
	// return 0;
	// } else if (cache[start][m] > 0) {
	// return cache[start][m];
	// }
	// int minMax = Integer.MAX_VALUE;
	// int sum = 0;
	// for (int i = start; i < end; i++) {
	// sum += nums[i];
	// int left = sum;
	// int right = splitArray(nums, cache, i + 1, end, m - 1);
	// int max = left > right ? left : right;
	// if (minMax >= max) {
	// minMax = max;
	// } else {
	// cache[start][m] = minMax;
	// break;
	// }
	// }
	// return minMax;
	// }
	//
	// public int splitArray(int[] nums, int m) {
	// if (nums == null || nums.length < m) {
	// return 0;
	// }
	// int len = nums.length;
	// int[][] cache = new int[len][m + 1];
	// int sum = 0;
	// for (int i = len - 1; i >= 0; i--) {
	// sum += nums[i];
	// cache[i][1] = sum;
	// }
	// return this.splitArray(nums, cache, 0, nums.length - 1, m);
	// }

	// public int splitArray(int[] nums, Map<Long, Integer> cache, long start,
	// long end, int m) {
	// long key = (start << 40) + (end << 20) + m;
	// if (cache.containsKey(key)) {
	// return cache.get(key);
	// }
	// int minMax = Integer.MAX_VALUE;
	// for (long i = start; i < end; i++) {
	// int left = splitArray(nums, cache, start, i, 1);
	// int right = splitArray(nums, cache, i + 1, end, m - 1);
	// int max = left > right ? left : right;
	// if (minMax >= max) {
	// minMax = max;
	// } else {
	// cache.put(key, minMax);
	// break;
	// }
	// }
	// return minMax;
	// }
	//
	// public int splitArray(int[] nums, int m) {
	// if (nums == null || nums.length < m) {
	// return 0;
	// }
	// int len = nums.length;
	// Map<Long, Integer> cache = new HashMap<>();
	// for (long start = 0; start < len; start++) {
	// int sum = 0;
	// for (long end = start; end < len; end++) {
	// long key = (start << 40) + (end << 20) + 1;
	// sum += nums[(int) end];
	// cache.put(key, sum);
	// }
	// }
	// return this.splitArray(nums, cache, 0, nums.length - 1, m);
	// }

	public static void main(String[] args) {
		Q410 q = new Q410();
		int[] nums = { 7, 2, 5, 10, 8 };
		System.out.println(q.splitArray(nums, 2));
		System.out.println(q.splitArray(nums, 3));

		int size = 1000;
		// Random rand = new Random();
		int[] nums1 = new int[size];
		for (int i = 0; i < size; i++) {
			nums1[i] = i;// rand.nextInt(size);
		}
		long t1 = System.currentTimeMillis();
		System.out.println(q.splitArray(nums1, 15));
		long t2 = System.currentTimeMillis();
		System.out.println("cost: " + (t2 - t1));

	}

}
