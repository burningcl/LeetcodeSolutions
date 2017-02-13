package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Keyboard Row
 * https://leetcode.com/problems/keyboard-row/
 * Created by chenliang on 2017/2/10.
 */
public class Q500 {

    public static Map<Character, Integer> map;

    public void initMap(){
        if(map!=null){
            return;
        }
        String[] keys = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        map  = new HashMap<>();
        for (int row = 0; row < keys.length; row++) {
            String key = keys[row];
            for (int i = 0; i < key.length(); i++) {
                map.put(key.charAt(i), row);
                map.put((char) (key.charAt(i) + 'A' - 'a'), row);
            }
        }
    }

    public String[] findWords(String[] words) {
        if (words == null || words.length <= 0) {
            return new String[0];
        }

        initMap();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int row = map.get(word.charAt(0));
            boolean singleRow = true;
            for (int i = 1; i < word.length(); i++) {
                if (row != map.get(word.charAt(i))) {
                    singleRow = false;
                    break;
                }
            }
            if (singleRow) {
                list.add(word);
            }
        }
        String[] ret=new String[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i]=list.get(i);
        }
        return ret;
    }

}
