package com.skyline.leetcode.solution;

/**
 * Count Primes
 * 
 * https://leetcode.com/problems/count-primes/
 * 
 * @author jairus
 *
 */
public class Q204 {

	public int countPrimes(int n) {
		boolean[] flags = new boolean[n];
		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (!flags[i]) {
				for (int j = 2; j * i < n; j++) {
					flags[j * i] = true;
				}
				cnt++;
			}
		}
		return cnt;
	}

	// public int countPrimes(int n) {
	// if (n <= 2) {
	// return 0;
	// }
	// List<Integer> primes = new ArrayList<>();
	// primes.add(2);
	// for (int i = 3; i < n; i++) {
	// int sqrt = (int) Math.sqrt(i);
	// boolean isPrime = true;
	// for (int j = 0; j < primes.size(); j++) {
	// int prime = primes.get(j);
	// if (prime > sqrt) {
	// break;
	// } else if (i % prime == 0) {
	// isPrime = false;
	// break;
	// }
	// }
	// if (isPrime) {
	// primes.add(i);
	// }
	// }
	// return primes.size();
	// }

	public static void main(String[] args) {
		Q204 q = new Q204();
		// System.out.println(q.countPrimes(0));
		// System.out.println(q.countPrimes(1));
		// System.out.println(q.countPrimes(2));
		// System.out.println(q.countPrimes(3));
		// System.out.println(q.countPrimes(4));
		// System.out.println(q.countPrimes(100));
		long t1 = System.currentTimeMillis();
		System.out.println(q.countPrimes(10000000));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

}
