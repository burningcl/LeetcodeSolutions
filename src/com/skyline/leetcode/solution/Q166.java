package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Fraction to Recurring Decimal
 * 
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 * 
 * @author jairus
 * 
 */
public class Q166 {
	
	private String fractionToDecimalLong(long numerator, long denominator) {
		if (denominator == 0) {
			return numerator > 0 ? String.valueOf(Integer.MAX_VALUE) : String.valueOf(Integer.MIN_VALUE);
		} else if (numerator == 0) {
			return "0";
		}
		boolean positive = true;
		if (numerator < 0) {
			positive = !positive;
			numerator = -numerator;
		}
		if (denominator < 0) {
			positive = !positive;
			denominator = -denominator;
		}

		String type = positive ? "" : "-";

		long valInt = numerator / denominator;
		numerator = numerator % denominator;

		if (numerator == 0) {
			return type + String.valueOf(valInt);
		}

		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		Map<Long, Integer> map = new HashMap<Long, Integer>();
		numerator = numerator * 10;
		int index = 0;
		while (!map.containsKey(numerator)) {
			long v = numerator / denominator;
			sb.append(v);
			map.put(numerator, index++);
			numerator = (numerator % denominator) * 10;
			if (numerator == 0) {
				flag = true;
				break;
			}
		}
		if (flag)
			return type + valInt + "." + sb.toString();
		else {
			String str = sb.toString();
			return type + valInt + "."+str.substring(0, map.get(numerator)) +"(" + str.substring(map.get(numerator), str.length()) + ")";
		}
	}

	public String fractionToDecimal(int numerator, int denominator) {
		return this.fractionToDecimalLong(numerator, denominator);
	}

	public static void main(String... strings) {
		Q166 q = new Q166();
		System.out.println(q.fractionToDecimal(1, 2));
		System.out.println(q.fractionToDecimal(4, 2));
		System.out.println(q.fractionToDecimal(1, 3));
		System.out.println(q.fractionToDecimal(2, 125));
		System.out.println(q.fractionToDecimal(23, 13));
		System.out.println(q.fractionToDecimal(-1, 2));
		System.out.println(q.fractionToDecimal(-1, -2));
		System.out.println(q.fractionToDecimal(1, -2));
	}
}
