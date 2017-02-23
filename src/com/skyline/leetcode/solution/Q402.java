package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * Remove K Digits
 * <p>
 * https://leetcode.com/problems/remove-k-digits/
 *
 * @author jairus
 */
public class Q402 {

    // public String removeKdigits(String num, int k) {
    // if (num == null || num.length() <= 0 || num.length() <= k) {
    // return "0";
    // }
    // boolean[] dels = new boolean[num.length()];
    // int low = 0;
    // int high = 1;
    // int cnt = 0;
    // for (; cnt < k && high < num.length();) {
    // int lowV = num.charAt(low) - '0';
    // int highV = num.charAt(high) - '0';
    // if (lowV == 0) {
    // dels[low] = true;
    // while (dels[low]) {
    // low++;
    // if (low == high) {
    // high++;
    // }
    // }
    // } else if (lowV == highV) {
    // high++;
    // } else if (lowV < highV) {
    // dels[high] = true;
    // high++;
    // cnt++;
    // } else {
    // dels[low] = true;
    // while (dels[low]) {
    // low++;
    // if (low == high) {
    // high++;
    // }
    // }
    // cnt++;
    // }
    // }
    // for (int i = 0; i <k- cnt && low < num.length(); i++) {
    // while (dels[low]) {
    // low++;
    // }
    // dels[low] = true;
    // }
    // StringBuilder sb = new StringBuilder();
    // boolean start = false;
    // for (int i = low; i < num.length(); i++) {
    // if (!dels[i]) {
    // if (num.charAt(i) != '0')
    // start = true;
    // if (start)
    // sb.append(num.charAt(i));
    // }
    // }
    // return sb.length() > 0 ? sb.toString() : "0";
    // }

    // int low = 0;
    //
    // int high = 1;
    //
    // boolean[] dels = null;
    //
    // String num;
    //
    // private void delZeros() {
    // if (dels == null || num == null || low >= num.length() || num.charAt(low)
    // != '0') {
    // return;
    // }
    // while (low < num.length() && (num.charAt(low) == '0' || dels[low])) {
    // dels[low] = true;
    // low++;
    // }
    // high = low + 1;
    // for (; high < num.length() && !dels[high]; high++) {
    // }
    // }
    //
    // public String removeKdigits(String num, int k) {
    // if (num == null || k <= 0) {
    // return num;
    // } else if (num.length() < k) {
    // return "0";
    // }
    //
    // this.num = num;
    // // 初始化
    // low = 0;
    // high = 1;
    // dels = new boolean[num.length()];
    // delZeros();
    //
    // // i表示被删除的数字的个数
    // for (int i = 0; i < k && low < num.length();) {
    // char l = num.charAt(low);
    // char h = 0;
    // if (high < num.length())
    // h = num.charAt(high);
    // if (l > h) {
    // System.out.println("del, " + low + ", l: " + l + ", h: " + h);
    // dels[low] = true;
    // low = high;
    // for (; high < num.length() && dels[high]; high++) {
    // }
    // i++;
    // } else {
    // int j = high;
    // int m = j + 1;
    // char th = '9' + 1;
    // for (; m < num.length(); m++) {
    // if (dels[m]) {
    // continue;
    // }
    // if (num.charAt(j) <= num.charAt(m)) {
    // j = m;
    // } else {
    // th = num.charAt(m);
    // break;
    // }
    // }
    // System.out.println(th + ", " + j + ", " + num.charAt(j));
    //
    // for (m = j; m >= high && i < k; m--) {
    // if (dels[m]) {
    // continue;
    // } else if (num.charAt(m) <= th) {
    // break;
    // }
    // System.out.println("del " + m + ": " + num.charAt(m));
    // dels[m] = true;
    // i++;
    // }
    // high = j + 1;
    // }
    // delZeros();
    // }
    // StringBuilder sb = new StringBuilder();
    // for (int i = 0; i < num.length(); i++) {
    // if (!dels[i]) {
    // sb.append(num.charAt(i));
    // }
    // }
    // return sb.length() > 0 ? sb.toString() : "0";
    // }

//	int low = 0;
//
//	boolean[] dels = null;
//
//	String num;
//
//	private void delZeros() {
//		if (dels == null || num == null || low >= num.length() || (num.charAt(low) != '0' && !dels[low])) {
//			return;
//		}
//		while (low < num.length() && (num.charAt(low) == '0' || dels[low])) {
//			dels[low] = true;
//			low++;
//		}
//	}
//
//	public String removeKdigits(String num, int k) {
//		if (num == null || k <= 0) {
//			return num;
//		} else if (num.length() < k) {
//			return "0";
//		}
//
//		// 初始化
//		low = 0;
//		this.num = num;
//		this.dels = new boolean[num.length()];
//		delZeros();
//
//		for (int i = 0; i < k && low < num.length(); i++) {
//			int high = low + 1;
//			char fh = num.charAt(low);
//			int fHigh = low;
//			for (; high < num.length(); high++) {
//				if (dels[high]) {
//					continue;
//				} else if (num.charAt(high) >= fh) {
//					fh = num.charAt(high);
//					fHigh = high;
//				} else {
//					break;
//				}
//			}
//			high = fHigh;
//			char l = num.charAt(low);
//			char h = num.charAt(high);
//			if (l > h) {
//				dels[low] = true;
//				low = high;
//			} else {
//				dels[high] = true;
//			}
//			delZeros();
//		}
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < num.length(); i++) {
//			if (!dels[i]) {
//				sb.append(num.charAt(i));
//			}
//		}
//		return sb.length() > 0 ? sb.toString() : "0";
//	}

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return String.valueOf(0);
        } else if (k <= 0) {
            return num;
        }
        StringBuilder sb = new StringBuilder();
        MinQueue q = new MinQueue();
        boolean flag = false;
        for (int i = 0; i < num.length(); ) {
            int add = k - q.size() + 1;
            for (int j = 0; j < add && j + i < num.length(); j++) {
                q.push(num.charAt(j + i));
            }
            char min = q.min();
            while (!q.empty() && q.pop() != min) {
                k--;
            }
            if ((min != '0') || flag) {
                sb.append(min);
                flag = true;
            }
            i += add;
        }
        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return String.valueOf(0);
        }
    }

    public class MinQueue {

        public ArrayDeque<Character> numStack1 = new ArrayDeque<>();

        public ArrayDeque<Character> minStack1 = new ArrayDeque<>();

        public ArrayDeque<Character> numStack2 = new ArrayDeque<>();

        public ArrayDeque<Character> minStack2 = new ArrayDeque<>();

        public void push(char num) {
            numStack1.push(num);
            if (minStack1.isEmpty() || num < minStack1.peek()) {
                minStack1.push(num);
            } else {
                minStack1.push(minStack1.peek());
            }
        }

        public char pop() {
            if (numStack2.isEmpty()) {
                while (!numStack1.isEmpty()) {
                    char num = numStack1.pop();
                    minStack1.pop();
                    numStack2.push(num);
                    if (minStack2.isEmpty() || num < minStack2.peek()) {
                        minStack2.push(num);
                    } else {
                        minStack2.push(minStack2.peek());
                    }
                }
            }
            minStack2.pop();

            return numStack2.pop();
        }

        public char min() {
            return (char) Integer.min(
                    minStack1.isEmpty() ? Integer.MAX_VALUE : minStack1.peek(),
                    minStack2.isEmpty() ? Integer.MAX_VALUE : minStack2.peek()
            );
        }

        public boolean empty() {
            return minStack1.isEmpty() && minStack2.isEmpty();
        }

        public int size() {
            return minStack1.size() + minStack2.size();
        }

    }


    public static void main(String... strings) {
        Q402 q = new Q402();
        System.out.println(q.removeKdigits("1432219", 3));
        System.out.println(q.removeKdigits("12", 1));
        System.out.println(q.removeKdigits("10200", 1).equals("200"));
        System.out.println(q.removeKdigits("1111", 3).equals("1"));
        System.out.println(q.removeKdigits("1000000001", 2).equals("0"));
        System.out.println(q.removeKdigits("10", 100).equals("0"));
        System.out.println(q.removeKdigits("9", 1).equals("0"));
        System.out.println(q.removeKdigits("1234561", 2).equals("12341"));
        System.out.println(q.removeKdigits("12", 2).equals("0"));
        System.out.println(q.removeKdigits("54321", 2).equals("321"));
        System.out.println(q.removeKdigits("123432", 3));
    }
}
