package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Encode and Decode Strings
 * https://leetcode.com/problems/encode-and-decode-strings/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q271 {

    public class Codec {

        char spliter = ';';

        String spliterStr = ";";

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            if (strs == null || strs.size() <= 0) {
                return sb.toString();
            }
            for (int i = 0; i < strs.size(); i++) {
                sb.append(strs.get(i).replace(spliterStr, "\\" + spliter));
                sb.append(spliter);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> list = new ArrayList<>();
            int escapeCnt = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '\\') {
                    escapeCnt++;
                    continue;
                }

                if (c == spliter && (escapeCnt == 0 || i == s.length() - 1)) {
                    list.add(s.substring(start, i).replace("\\" + spliter, spliterStr));
                    start = i + 1;
                }
                escapeCnt = 0;
            }
            return list;
        }
    }

    public static void main(String... strings) {

    }


}
