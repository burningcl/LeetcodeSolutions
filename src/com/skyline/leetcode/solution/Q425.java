package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Word Squares
 * https://leetcode.com/problems/word-squares/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q425 {

    public List<List<String>> wordSquares(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 1; j < word.length(); j++) {
                String key = word.substring(0, j);
                List<String> list = map.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(key, list);
                }
                list.add(word);
            }
        }
        List<List<String>> list = new ArrayList<>();
        List<String> curList = new ArrayList<>();

        int len = words[0].length();
        for (String word : words) {
            curList.add(word);
            this.wordSquares(list, curList, map, 1, len);
            curList.remove(curList.size() - 1);
        }
        return list;
    }

    public void wordSquares(List<List<String>> list, List<String> curList, Map<String, List<String>> map, int index, int len) {
        if (index >= len) {
            list.add(new ArrayList<>(curList));
            return;
        }
       // System.out.println(curList);
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < index; i++) {
            key.append(curList.get(i).charAt(index));
        }
        String keyStr = key.toString();
        List<String> words = map.get(keyStr);
        if (words == null || words.size() <= 0) {
            return;
        }
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            curList.add(word);
            this.wordSquares(list, curList, map, index + 1, len);
            curList.remove(curList.size() - 1);
        }
    }

}
