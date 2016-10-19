package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 * 
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * @author jairus
 *
 */
public class Q118 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		if (numRows == 0) {
			return list;
		}
		List<Integer> line1 = new ArrayList<>();
		line1.add(1);
		list.add(line1);
		for (int i = 1; i < numRows; i++) {
			List<Integer> fline = list.get(i - 1);
			List<Integer> cline = new ArrayList<>();
			cline.add(1);
			for (int j = 1; j < fline.size(); j++) {
				cline.add(fline.get(j - 1) + fline.get(j));
			}
			cline.add(1);
			list.add(cline);
		}
		return list;
	}

	public static void main(String[] args) {
		Q118 q=new Q118();
		System.out.println(q.generate(0));
		System.out.println(q.generate(1));
		System.out.println(q.generate(2));
		System.out.println(q.generate(3));
		System.out.println(q.generate(4));
		System.out.println(q.generate(5));
		System.out.println(q.generate(6));
		System.out.println(q.generate(7));
		System.out.println(q.generate(8));
		System.out.println(q.generate(9));
	}

}
