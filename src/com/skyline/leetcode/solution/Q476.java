package com.skyline.leetcode.solution;

/**
 * Number Complement
 * https://leetcode.com/problems/number-complement/
 * Created by chenliang on 2017/1/18.
 */
public class Q476 {

    public int findComplement(int num) {
        if (num < 0) {
            return (-1) ^ (-num);
        } else if (num == 0) {
            return 1;
        } else {
            int log = (int) (Math.log(num) / Math.log(2));
            int mask = (1 << (log + 1)) - 1;
            return (~num) & mask;
        }
    }

    public static void main(String... str) {
        Q476 q = new Q476();
        System.out.println(q.findComplement(5) == 2);
        System.out.println(q.findComplement(0) == 1);
        System.out.println(q.findComplement(-5));
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println((int) (Math.log(128) / Math.log(2)));
    }
}
