package com.skyline.leetcode.solution;

/**
 * Create Maximum Number
 * 
 * https://leetcode.com/problems/create-maximum-number/
 * 
 * @author jairus
 *
 */
public class Q321 {

	public int add(int[] nums, int k, boolean[] ava) {
		int i = 0;
		for (; i < k; i++) {
			int[] add = add(nums, ava);
			if (add == null) {
				break;
			}
			ava[add[1]] = true;
		}
		return i;
	}

	public int[] add(int[] nums, boolean[] dels) {
		int i = nums.length - 1;
		for (; i >= 0 && dels[i]; i--) {
		}
		if (i < 0) {
			return null;
		}
		int max = 0;
		int maxIndex = i;
		for (; i >= 0 && !dels[i]; i--) {
			if (nums[i] >= max) {
				max = nums[i];
				maxIndex = i;
			}
		}

		int[] ret = new int[2];
		ret[0] = max;
		ret[1] = maxIndex;
		return ret;
	}

	public int[] del(int[] nums, boolean[] ava) {
		int low = -1;
		int high = 0;
		for (; high < nums.length; high++) {
			if (!ava[high]) {
				continue;
			} else if (low == -1) {
				low = high;
				continue;
			} else {
				int valL = nums[low];
				int valH = nums[high];
				if (valL < valH) {
					int[] ret = new int[2];
					ret[0] = valL;
					ret[1] = low;
					return ret;
				} else {
					low = high;
				}
			}
		}
		if (low == -1) {
			return null;
		} else {
			int[] ret = new int[2];
			ret[0] = nums[low];
			ret[1] = low;
			return ret;
		}
	}

	int[] merger(int[] nums1, boolean[] ava1, int[] nums2, boolean[] ava2, int k) {
		int[] ret = new int[k];
		int i = 0;
		int j = 0;
		int h = 0;
		for (; i < nums1.length && j < nums2.length;) {
			if (!ava1[i]) {
				i++;
			} else if (!ava2[j]) {
				j++;
			} else if (nums1[i] > nums2[j]) {
				ret[h++] = nums1[i++];
			} else if (nums1[i] < nums2[j]) {
				ret[h++] = nums2[j++];
			} else {
				Boolean bigger = null;
				int ii = i;
				int jj = j;
				while (ii < nums1.length && jj < nums2.length) {
					if (!ava1[ii]) {
						ii++;
					} else if (!ava2[jj]) {
						jj++;
					} else if (nums1[ii] > nums2[jj]) {
						bigger = true;
						break;
					} else if (nums1[ii] < nums2[jj]) {
						bigger = false;
						break;
					} else {
						ii++;
						jj++;
					}
				}
				if (ii >= nums1.length && jj < nums2.length && bigger == null) {
					bigger = false;
				} else if (ii < nums1.length && jj > nums2.length && bigger == null) {
					bigger = true;
				} else if(bigger==null){
					bigger = true;
				}
//				for(int iii=i;iii<nums1.length;iii++){
//					if (ava1[iii])
//						System.out.print(nums1[iii]);
//				}
//				System.out.println();
//				for(int jjj=j;jjj<nums2.length;jjj++){
//					if (ava2[jjj])
//						System.out.print(nums2[jjj]);
//				}
//				System.out.println();
//				System.out.println(bigger);
				if (bigger) {
					ret[h++] = nums1[i++];
				} else {
					ret[h++] = nums2[j++];
				}
			}

		}
		if (i < nums1.length) {
			for (; i < nums1.length;) {
				if (!ava1[i]) {
					i++;
					continue;
				} else {
					ret[h++] = nums1[i++];
				}
			}
		}
		if (j < nums2.length) {
			for (; j < nums2.length;) {
				if (!ava2[j]) {
					j++;
					continue;
				} else {
					ret[h++] = nums2[j++];
				}
			}
		}
		// System.out.println();
		// System.out.println("nums1:");
		// print(nums1, ava1);
		// System.out.println("nums2:");
		// print(nums2, ava2);
		// print(ret);
		return ret;
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		if (k <= 0)
			return new int[0];
		if (nums1 == null)
			nums1 = new int[0];
		if (nums2 == null)
			nums2 = new int[0];

		boolean[] ava1 = new boolean[nums1.length];
		boolean[] ava2 = new boolean[nums2.length];

		int len1 = add(nums1, k, ava1);
		add(nums2, k - len1, ava2);

		int[] max = new int[k];
		while (len1 >= 0) {
			int[] cur = merger(nums1, ava1, nums2, ava2, k);

			// System.out.println();
			// print(cur);
			// print(max);
			int i = 0;
			for (; i < k && cur[i] == max[i]; i++) {
			}
			if (i < k && cur[i] > max[i]) {
				max = cur;
			}

			int[] del = del(nums1, ava1);
			int[] add = add(nums2, ava2);

			if (del == null || add == null) {
				break;
			}
			ava1[del[1]] = false;
			ava2[add[1]] = true;
			len1--;
		}
		return max;
	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
	}

	private static String toString(int[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
		return sb.toString();
	}

	private static void print(int[] array, boolean[] ava) {
		for (int i = 0; i < array.length; i++) {
			if (ava[i])
				System.out.print(array[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Q321 q = new Q321();
		int[] nums1 = { 3, 4, 6, 5 };
		int[] nums2 = { 9, 1, 2, 5, 8, 3 };
		System.out.println(toString(q.maxNumber(nums1, nums2, 5)).equals("98653"));

		int[] nums3 = { 6, 7 };
		int[] nums4 = { 6, 0, 4 };
		System.out.println(toString(q.maxNumber(nums3, nums4, 5)).equals("67604"));

		int[] nums5 = { 3, 9 };
		int[] nums6 = { 8, 9 };
		System.out.println(toString(q.maxNumber(nums5, nums6, 3)).equals("989"));

		int[] nums7 = { 2, 5, 6, 4, 4, 0 };
		int[] nums8 = { 7, 3, 8, 0, 6, 5, 7, 6, 2 };
		System.out.println(toString(q.maxNumber(nums7, nums8, 15)).equals("738256440657620"));
		
		int[] nums9 = {1,6,5,4,7,3,9,5,3,7,8,4,1,1,4 };
		int[] nums10 = {4,3,1,3,5,9};
		System.out.println(toString(q.maxNumber(nums9, nums10, 21)).equals("431654739537841359114"));
	}

}
