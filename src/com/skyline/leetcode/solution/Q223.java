package com.skyline.leetcode.solution;

/**
 * Rectangle Area
 * 
 * https://leetcode.com/problems/rectangle-area/
 * 
 * @author jairus
 *
 */
public class Q223 {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		long v1 = (C - A) * (D - B);
		long v2 = (G - E) * (H - F);
		long A1 = A > E ? A : E;
		long B1 = B > F ? B : F;
		long C1 = C < G ? C : G;
		long D1 = D < H ? D : H;
		long width = C1 - A1;
		long height = D1 - B1;
		long v3 = width < 0 || height < 0 ? 0 : width * height;
		return (int) (v1 + v2 - v3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
