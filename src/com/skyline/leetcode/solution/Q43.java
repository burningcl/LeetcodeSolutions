package com.skyline.leetcode.solution;

import java.math.BigInteger;

/**
 * Multiply Strings
 * 
 * https://leetcode.com/problems/multiply-strings/
 * 
 * @author jairus
 *
 */
public class Q43 {

	public static final int TEN_TH = 1000 * 1000 * 1000 ;

	public static class BigInt {

		long[] array = null;

		boolean negative = false;

		public BigInt() {

		}

		public BigInt(String str) {
			if (str.startsWith("-")) {
				negative = true;
				str = str.substring(1);
			} else if (str.startsWith("+")) {
				str = str.substring(1);
			}

			array = new long[str.length() / 9 + 1];
			int num = 0;
			int size = -1;
			for (int i = 0; i < str.length(); i++) {
				int pos = str.length() - 1 - i;
				if (i % 9 == 0) {
					if (size >= 0) {
						array[size] = num;
					}
					num = 0;
					size++;
				}
				num += (str.charAt(pos) - '0') * (int) Math.pow(10, i % 9);
			}
			array[size++] = num;
		}

		public BigInt mutiply(BigInt bi) {
			BigInt ret = new BigInt();
			ret.array = new long[array.length + bi.array.length + 1];
			for (int i = 0; i < array.length; i++) {
				long carry = 0;
				for (int j = 0; j < bi.array.length; j++) {
					long num = ret.array[i + j] + array[i] * bi.array[j] + carry;
					ret.array[i + j] = num % TEN_TH;
					carry = num / TEN_TH;
				}
				int k = 0;
				while (carry > 0 && i + bi.array.length + k < ret.array.length) {
					long num = ret.array[i + bi.array.length + k] + carry;
					ret.array[i + bi.array.length + k] = num % TEN_TH;
					carry = carry / TEN_TH;
					k++;
				}
			}
			ret.negative = negative ^ bi.negative;
			return ret;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			if (negative) {
				builder.append("-");
			}
			int i = array.length - 1;
			while (i >= 0 && array[i] == 0) {
				i--;
			}
			if (i < 0) {
				return "0";
			}
			builder.append(String.format("%d", array[i]));
			i--;
			while (i >= 0) {
				builder.append(String.format("%09d", array[i]));
				i--;
			}
			return builder.toString();
		}

	}

	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() <= 0 || num2 == null || num2.length() <= 0) {
			return "0";
		}
		BigInt bi1 = new BigInt(num1);
		BigInt bi2 = new BigInt(num2);
		return bi1.mutiply(bi2).toString();
	}

	public static void main(String... strings) {
		System.out.println(999999999l * 999999999l);
		System.out.println(String.format("%012d", 999999999l));
		Q43 q = new Q43();
		System.out.println(q.multiply("1", "0"));
		System.out.println(q.multiply("1", "-2"));
		System.out.println(q.multiply("-1", "2"));
		System.out.println(q.multiply("-1", "-2"));
		System.out.println(q.multiply("123456", "2").equals(String.valueOf((123456 * 2))));
		System.out.println(q.multiply("999999", "783274")
				.equals(BigInteger.valueOf(999999).multiply(BigInteger.valueOf(783274)).toString()));
		System.out.println(q
				.multiply("-75432895798437985793421759812347453271984723942314213",
						"8908590438190583241854234795874395792317492374982")
				.equals(new BigInteger("-75432895798437985793421759812347453271984723942314213")
						.multiply(new BigInteger("8908590438190583241854234795874395792317492374982")).toString()));
		System.out.println(q
				.multiply(
						"4382590843258043850943820958043860954280685093685042860438584305804384093218432180483290483201483219084032859034869084830",
						"0")
				.equals(new BigInteger(
						"4382590843258043850943820958043860954280685093685042860438584305804384093218432180483290483201483219084032859034869084830")
								.multiply(new BigInteger("0")).toString()));
	}
}
