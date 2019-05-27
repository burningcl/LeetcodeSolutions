package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * @author huasong.cl
 */
public class Q1047 {

//    public String removeDuplicates(String S) {
//        ArrayDeque<Character> stack = new ArrayDeque<>();
//        for (int i = 0; i < S.length(); i++) {
//            char c = S.charAt(i);
//            if (!stack.isEmpty() && stack.peek() == c) {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        return sb.reverse().toString();
//    }

//    public String removeDuplicates(String S) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < S.length(); i++) {
//            char c = S.charAt(i);
//            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
//                sb.setLength(sb.length() - 1);
//            } else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }

    public String removeDuplicates(String S) {
        char[] array = S.toCharArray();
        int low = 0, high = 0;
        for (; high < array.length; ++high) {
            if (low > 0 && array[low - 1] == array[high]) {
                --low;
            } else {
                array[low++] = array[high];
            }
        }
        return String.valueOf(array, 0, low);
    }

}
