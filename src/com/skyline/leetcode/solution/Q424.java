package com.skyline.leetcode.solution;

import java.util.LinkedList;

/**
 * Longest Repeating Character Replacement
 * 
 * 
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * 
 * @author jairus
 *
 */
public class Q424 {

	// public int characterReplacement(String s, int k) {
	// if (s == null || s.length() <= 0) {
	// return 0;
	// } else if (s.length() < k + 1) {
	// return s.length();
	// }
	// int max = 0;
	// for (int i = 0; i < s.length() - max; i++) {
	// char c = s.charAt(i);
	// int ck = 0;
	// int j = i + 1;
	// for (; j < s.length(); j++) {
	// if (s.charAt(j) != c) {
	// if (++ck > k) {
	// break;
	// }
	// }
	// }
	// if (j - i > max) {
	// max = j - i ;
	// }
	// }
	//
	// //第一行表示一个字母的，出现次数，开始Index，结束Index
	// int[][] array=new int[26][3];
	// for(int i=0;i<s.length();i++){
	// int cindex=s.charAt(i)-'A';
	// if(array[cindex][0]==0){
	// array[cindex][1]=i;
	// }
	// array[cindex][0]++;
	// array[cindex][2]=i;
	//
	// int startIndex=array[cindex][1];
	// int endIndex=array[cindex][2];
	// int cnt=array[cindex][0];
	// int interOtherCnt=endIndex-startIndex+1-cnt;
	// if(interOtherCnt<=k){
	// int curMax=0;
	// curMax = endIndex - startIndex + 1 + k - interOtherCnt;
	// if(curMax>s.length()){
	// curMax=s.length();
	// }
	// if(curMax>max){
	// max=curMax;
	// }
	// }
	// }
	// return max;
	// }

	class Item {
		int k;
		int start;
		int end;
	}

	@SuppressWarnings("unchecked")
	public int characterReplacement(String s, int k) {
		if (s == null || s.length() <= 0) {
			return 0;
		} else if (s.length() <= k + 1) {
			return s.length();
		}

		int[] sumKs = new int[26];
		int[] maxs = new int[26];
		Object[] items = new Object[26];
		int max = k+1;
		for (int i = 0; i < s.length(); i++) {
			int cindex = s.charAt(i) - 'A';
			LinkedList<Item> itemList = null;
			if (items[cindex] == null) {
				itemList = new LinkedList<Item>();
				Item item = new Item();
				item.start = i;
				item.end = i;
				itemList.addLast(item);
				items[cindex] = itemList;
				maxs[cindex] = 1;
			} else {
				itemList = (LinkedList<Item>) items[cindex];
				Item lastItem = itemList.getLast();
				if (lastItem.end == i - 1) {
					lastItem.end = i;
					maxs[cindex]++;
				} else {
					Item item = new Item();
					item.start = i;
					item.end = i;
					lastItem.k = i - lastItem.end - 1;
					sumKs[cindex] += lastItem.k;
					maxs[cindex] += lastItem.k;
					while (sumKs[cindex] > k) {
						Item itemHead = itemList.removeFirst();
						sumKs[cindex] -= itemHead.k;
						maxs[cindex] -= itemHead.end - itemHead.start + 1 + itemHead.k;
					}
					itemList.addLast(item);
					maxs[cindex] ++;
				}
				int curMax = maxs[cindex] + k - sumKs[cindex];
				if (max < curMax) {
					max = curMax;
				}
			}
		}
		return max > s.length() ? s.length() : max;
	}

	public static void main(String[] args) {
		Q424 q = new Q424();
		System.out.println(q.characterReplacement("ABCDA", 1));
		System.out.println(q.characterReplacement("ABCDA", 2));
		System.out.println(q.characterReplacement("ABCDA", 3));
		System.out.println(q.characterReplacement("ABAB", 1));
		System.out.println(q.characterReplacement("ABAB", 2));
		System.out.println(q.characterReplacement("ABAB", 0));
		System.out.println(q.characterReplacement("AABABBA", 1));
		System.out.println(q.characterReplacement("AABABBA", 2));
		System.out.println(q.characterReplacement("ABBABBBA", 3));
		System.out.println(q.characterReplacement("AABABBA", 4));
	}

}
