package com.skyline.leetcode.solution;

/**
 * 
 * @author jairus
 *
 */
public class Q397 {

	private int divCnt(long n) {
		int cnt = 0;
		while (n % 2 == 0) {
			n = n >> 1;
			cnt++;
		}
		return cnt;
	}

	public int integerReplacement(int n) {
		if (n <= 1) {
			return 0;
		}
		long nl = n;
		int cnt = 0;
		while (nl > 1) {
			cnt++;
			if (nl % 2 == 0) {
				nl = nl >> 1;
			} else {
				if (divCnt(nl + 1) > divCnt(nl - 1) && (nl + 1) / 2 != nl - 1) {
					nl = nl + 1;
				} else {
					nl = nl - 1;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Q397 q = new Q397();
		System.out.println(q.integerReplacement(8));
		System.out.println(q.integerReplacement(7));
		System.out.println(q.integerReplacement(3));
		System.out.println(q.integerReplacement(4));
		System.out.println(q.integerReplacement(Integer.MAX_VALUE));
	}

}
