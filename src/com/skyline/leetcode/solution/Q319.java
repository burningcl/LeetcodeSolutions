package com.skyline.leetcode.solution;

/**
 * Bulb Switcher
 * 
 * https://leetcode.com/problems/bulb-switcher/
 * 
 * @author jairus
 *
 */
public class Q319 {
	// Map<Integer, Integer> cache = null;

	public int bulbSwitch(int n) {
		 return (int) (n >= 0 ? Math.sqrt(n) : 0);
	}

	public static void main(String... strings) {
		Q319 q = new Q319();
		System.out.println(Integer.MAX_VALUE);
		long t1 = System.currentTimeMillis();
		System.out.println(q.bulbSwitch(Integer.MAX_VALUE));
		// System.out.println(q.bulbSwitch(2));
		// System.out.println(q.bulbSwitch(3));
		// System.out.println(q.bulbSwitch(4));
		// System.out.println(q.bulbSwitch(5));
		// System.out.println(q.bulbSwitch(6));
		// System.out.println(q.bulbSwitch(0));
		long t2 = System.currentTimeMillis();
		System.out.println("cost: " + (t2 - t1));
		// for (int i = 0; i < 1000000; i++) {
		// System.out.println(i + ":\t" + q.bulbSwitch(i));
		// }
	}

}
