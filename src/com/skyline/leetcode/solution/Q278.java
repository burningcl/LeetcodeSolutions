package com.skyline.leetcode.solution;

/**
 * First Bad Version
 * 
 * https://leetcode.com/problems/first-bad-version/
 * 
 * @author jairus
 *
 */
public class Q278 {

	// boolean[] array = {};

	boolean isBadVersion(int version) {
		// return array[version - 1];
		if (version < 1702766719) {
			return false;
		} else {
			return true;
		}
	}

	public int firstBadVersion(int n) {
		long low = 1;
		long high = n;
		while (low < high) {
			long mid = (low + high) / 2;
			if (isBadVersion((int)mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return (int)low;
	}

	public static void main(String... strings) {
		Q278 q = new Q278();
		System.out.println(q.firstBadVersion(2126753390));
		// boolean[] array = { false, false, false, true };
		// q.array = array;
		// System.out.println(q.firstBadVersion(4));
		// boolean[] array2 = { false, false, true, true };
		// q.array = array2;
		// System.out.println(q.firstBadVersion(4));
		// boolean[] array3 = { false, true, true, true };
		// q.array = array3;
		// System.out.println(q.firstBadVersion(4));
		// boolean[] array4 = { true, true, true, true };
		// q.array = array4;
		// System.out.println(q.firstBadVersion(4));
		//
		// boolean[] array5 = { false, false, false, false, true };
		// q.array = array5;
		// System.out.println(q.firstBadVersion(5));
		// boolean[] array6 = { false, false, false, true, true };
		// q.array = array6;
		// System.out.println(q.firstBadVersion(5));
		// boolean[] array7 = { false, false, true, true, true };
		// q.array = array7;
		// System.out.println(q.firstBadVersion(5));
		// boolean[] array8 = { false, true, true, true, true };
		// q.array = array8;
		// System.out.println(q.firstBadVersion(5));
		// boolean[] array9 = { true, true, true, true, true };
		// q.array = array9;
		// System.out.println(q.firstBadVersion(5));
	}
}
