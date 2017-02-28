package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Shortest Word Distance II
 * https://leetcode.com/problems/shortest-word-distance-ii/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q244 {

    public class WordDistance {

        Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                List<Integer> list = map.get(word);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(word, list);
                }
                list.add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            if (list1 == null || list2 == null) {
                return -1;
            }
            int i = 0;
            int j = 0;
            int min = Integer.MAX_VALUE;
            for (; i < list1.size() && j < list2.size(); ) {
                int index1 = list1.get(i);
                int index2 = list2.get(j);
                if (index1 == index2) {
                    return 0;
                } else if (index1 > index2) {
                    if (index1 - index2 < min) {
                        min = index1 - index2;
                    }
                    j++;
                } else {
                    if (index2 - index1 < min) {
                        min = index2 - index1;
                    }
                    i++;
                }
            }
            return min;
        }
    }

}
