package com.skyline.leetcode.solution;

public class Q461 {

	public int hammingDistance(int x, int y) {
		int d = x ^ y;
		int cnt = 0;
		while (d > 0) {
			if(d%2==1)
			cnt++;
			d = d >> 1;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Q461 q=new Q461();
		System.out.println(q.hammingDistance(1, 4));

	}

}
