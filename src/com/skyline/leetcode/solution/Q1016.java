package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1016 {

    public boolean queryString(String S, int N) {
        for (int n = 1; n <= N; n++) {
          String s=  Integer.toBinaryString(n);
          if(!S.contains(s)){
              return false;
          }
        }
        return true;
    }

}
