package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer
 * <p>
 * https://leetcode.com/problems/roman-to-integer/
 *
 * @author jairus
 */
public class Q13 {

    static final int[] map = new int[26];

    static {
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
    }

    public int romanToInt(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int sum = 0;
        int preV = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curV = map[c - 'A'];
            if (preV < curV) {
                sum += curV - 2 * preV;
            } else {
                sum += curV;
            }
            preV = curV;
        }
        return sum;
    }

    public static void main(String... strings) {
        Q12 q = new Q12();
        Q13 q13 = new Q13();
        for (int i = 1; i <= 3999; i++) {
            if (i != q13.romanToInt(q.intToRoman(i)))
                System.out.println(i + "\t" + q13.romanToInt(q.intToRoman(i)));
        }
    }
}
