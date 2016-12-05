package com.skyline.leetcode.solution;

/**
 * 
 * @author jairus
 *
 */
public class Q299 {

	public String getHint(String secret, String guess) {
		if (secret == null || guess == null || secret.length() != guess.length() || secret.length() <= 0) {
			return "0A0B";
		}
		int A = 0;
		int B = 0;
		int[] s1 = new int[10];
		int[] s2 = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int c1 = secret.charAt(i) - '0';
			int c2 = guess.charAt(i) - '0';
			if (c1 == c2) {
				A++;
			}
			s1[c1]++;
			s2[c2]++;
		}
		for (int i = 0; i < 10; i++) {
			B += s1[i] < s2[i] ? s1[i] : s2[i];
		}
		B -= A;
		return A + "A" + B + "B";
	}

	public static void main(String[] args) {
		Q299 q = new Q299();
		System.out.println(q.getHint("1807", "7810"));
		System.out.println(q.getHint("1123", "0111"));
	}

}
