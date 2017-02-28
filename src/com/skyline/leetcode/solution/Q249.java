package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Group Shifted Strings
 * https://leetcode.com/problems/group-shifted-strings/?tab=Description
 * Created by chenliang on 2017/2/25.
 */
public class Q249 {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> list = new ArrayList<>();
        if (strings == null || strings.length <= 0) {
            return list;
        }
        boolean[] added = new boolean[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (added[i]) {
                continue;
            }
            added[i] = true;
            String string = strings[i];
            List<String> subList = new ArrayList<>();
            subList.add(string);
            list.add(subList);
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[j].length() != string.length()) {
                    continue;
                }
                String curString = strings[j];
                boolean sameGroup = true;
                for (int k = 1; k < string.length() && sameGroup; k++) {
                    if ((curString.charAt(k) - curString.charAt(k - 1) + 26) % 26
                            != (string.charAt(k) - string.charAt(k - 1) + 26) % 26) {
                        sameGroup = false;
                    }
                }
                if (sameGroup) {
                    subList.add(curString);
                    added[j] = true;
                }
            }
        }
        return list;
    }
}
