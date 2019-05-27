package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huasong.cl
 */
public class Q1023 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for (String query : queries) {
            list.add(camelMatch(query, pattern));
        }
        return list;
    }

    public Boolean camelMatch(String query, String pattern) {
        int i = 0;
        int j = 0;
        for (; i < pattern.length() && j < query.length(); i++) {
            char pChar = pattern.charAt(i);
            boolean match = false;
            for (; j < query.length(); j++) {
                char qChar = query.charAt(j);
                if (pChar == qChar) {
                    j++;
                    match = true;
                    break;
                } else if (Character.isUpperCase(qChar) && pChar != qChar) {
                    return false;
                }
            }
            if (!match) {
                return false;
            }
        }
        for (; j < query.length(); j++) {
            if (Character.isUpperCase(query.charAt(j))) {
                return false;
            }
        }
        return i >= pattern.length();
    }


    public static void main(String... args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        System.out.println(new Q1023().camelMatch(queries, "FoBaT"));
    }
}
