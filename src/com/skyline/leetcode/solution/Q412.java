package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * 
 * https://leetcode.com/problems/fizz-buzz/
 * 
 * @author jairus
 * 
 */
public class Q412 {

	static final String fizz = "Fizz";

	static final String buzz = "Buzz";

	static final String fizzBuzz = "FizzBuzz";

	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			boolean mod3 = i % 3 == 0;
			boolean mod5 = i % 5 == 0;
			if (mod3 & mod5) {
				list.add(fizzBuzz);
			} else if (mod3) {
				list.add(fizz);
			} else if (mod5) {
				list.add(buzz);
			} else {
				list.add(String.valueOf(i));
			}
		}
		return list;
	}
}
