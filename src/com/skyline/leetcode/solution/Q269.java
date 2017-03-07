package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Alien Dictionary
 * https://leetcode.com/problems/alien-dictionary/?tab=Description
 * Created by chenliang on 2017/3/2.
 */
public class Q269 {

    public String alienOrder(String[] words) {
        if (words == null || words.length <= 0) {
            return "";
        }
        boolean[][] matrix = new boolean[128][128];
        int[] inEdgeCnts = new int[128];
        Arrays.fill(inEdgeCnts, -1);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
        }
        if (!this.alienOrder(list, 0, matrix, inEdgeCnts)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int j = 0;
        while (j++ < 128) {
            int index = -1;
            for (int i = 0; i < 128 && index == -1; i++) {
                if (inEdgeCnts[i] == 0) {
                    index = i;
                }
            }
            if (index < 0) {
                break;
            }
            builder.append((char) index);
            inEdgeCnts[index] = -1;
            for (int i = 0; i < 128; i++) {
                if (matrix[index][i]) {
                    inEdgeCnts[i]--;
                }
            }
        }
        for (int i = 0; i < 128; i++) {
            if (inEdgeCnts[i] >= 0) {
                return "";
            }
        }
        return builder.toString();
    }

    public boolean alienOrder(List<String> words, int index, boolean[][] matrix, int[] inEdgeCnts) {
//        System.out.println(words);
        if (words.size() <= 0) {
            return true;
        }
        if (words.size() == 1) {
            String word = words.get(0);
            for (int i = 0; i < word.length(); i++) {
                if (inEdgeCnts[word.charAt(i)] == -1) {
                    inEdgeCnts[word.charAt(i)] = 0;
                }
            }
            return true;
        }
        List<String> subList = new ArrayList<>();
        subList.add(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            String curWord = words.get(i);
            String preWord = words.get(i - 1);
            if (preWord.length() > index && curWord.length() <= index) {
                return false;
            }
            if (preWord.length() <= index) {
                if (!this.alienOrder(subList, index + 1, matrix, inEdgeCnts)) {
                    return false;
                }
                subList.clear();
                subList.add(curWord);
                continue;
            }
            char curChar = curWord.charAt(index);
            char preChar = preWord.charAt(index);
            if (curChar == preChar) {
                subList.add(curWord);
            } else {
                if (!matrix[preChar][curChar]) {
                    matrix[preChar][curChar] = true;
                    //System.out.println(preChar + "->" + curChar);
                    if (inEdgeCnts[preChar] == -1) {
                        inEdgeCnts[preChar] = 0;
                    }
                    if (inEdgeCnts[curChar] == -1) {
                        inEdgeCnts[curChar] = 0;
                    }
                    inEdgeCnts[curChar]++;
                }
                if (matrix[curChar][preChar]) {
                    return false;
                }
                if (!this.alienOrder(subList, index + 1, matrix, inEdgeCnts)) {
                    return false;
                }
                subList.clear();
                subList.add(curWord);
            }
        }
        return this.alienOrder(subList, index + 1, matrix, inEdgeCnts);
    }

}
