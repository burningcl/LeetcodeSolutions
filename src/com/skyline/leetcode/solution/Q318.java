package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Maximum Product of Word Lengths
 * 
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 * 
 * @author jairus
 *
 */
public class Q318 {

	/**
	 * @param words
	 * @return
	 */
	public int maxProduct(String[] words) {
		if (words == null || words.length <= 1) {
			return 0;
		}
		List<Set<Character>> sets = new ArrayList<Set<Character>>();
		for (String word : words) {
			Set<Character> set = new HashSet<>();
			for (int i = 0; i < word.length(); i++) {
				set.add(word.charAt(i));
			}
			sets.add(set);
		}
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			Set<Character> setI = sets.get(i);
			String wordI = words[i];
			for (int j = i + 1; j < words.length; j++) {
				Set<Character> setJ = sets.get(j);
				String wordJ = words[j];
				boolean d=true;
				for(Character c:setJ){
					if(setI.contains(c)){
						d=false;
						break;
					}
				}
				if(!d){
					continue;
				}
				int len=wordI.length()*wordJ.length();
				if(len>max){
					max=len;
				}
			}
		}

		return max;
	}
}
