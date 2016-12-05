package com.skyline.leetcode.solution;

/**
 * Integer to English Words
 * 
 * https://leetcode.com/problems/integer-to-english-words/
 * 
 * @author jairus
 *
 */
public class Q273 {

	static final String[] ARRAY_SMALL_THAN_20 = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

	static final String[] ARRAY_DECADE = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	/**
	 * 输出 1~999之间的数值
	 * 
	 * @param num
	 *            取值 1~999
	 * @return
	 */
	public void numberToWords(int num, StringBuilder sb) {
		if (num >= 100) {
			int hundreds = num / 100;
			sb.append(ARRAY_SMALL_THAN_20[hundreds]).append(" Hundred");
			num = num % 100;
			if (num == 0) {
				return;
			}
			sb.append(" ");
		}
		if (num <= 19) {
			sb.append(ARRAY_SMALL_THAN_20[num]);
		} else {
			int decades = num / 10;
			sb.append(ARRAY_DECADE[decades - 2]);
			num = num % 10;
			if (num != 0) {
				sb.append(" ").append(ARRAY_SMALL_THAN_20[num]);
			}
		}
	}

	static String[] ARRAY_THOUSAND = { "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0) {
			return ARRAY_SMALL_THAN_20[0];
		}
		long num1 = num;
		StringBuilder sb = new StringBuilder();
		if (num < 0) {
			sb.append("Negative ");
			num1 = -num1;
		}
		//System.out.println(num1+", "+num);
		
		for (int i = 3; i >= 0; i--) {
			int div = (int) Math.pow(1000, i);
			if (num1 < div) {
				continue;
			}
			this.numberToWords((int) (num1 / div), sb);
			if (div > 1)
				sb.append(" ").append(ARRAY_THOUSAND[i - 1]);
			num1 = num1 % div;
			if (num1 == 0) {
				break;
			}
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Q273 q = new Q273();
		System.out.println(q.numberToWords(100));
		System.out.println(q.numberToWords(12));
		System.out.println(q.numberToWords(123));
		System.out.println(q.numberToWords(256));
		System.out.println(q.numberToWords(0));
		System.out.println(q.numberToWords(110));
		System.out.println(q.numberToWords(2890));
		System.out.println(q.numberToWords(35740));
		System.out.println(q.numberToWords(764752));
		System.out.println(q.numberToWords(800000));
		System.out.println(q.numberToWords(Integer.MAX_VALUE));
		System.out.println(q.numberToWords(Integer.MIN_VALUE));
	}

}
