package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Simplify Path
 * 
 * https://leetcode.com/problems/simplify-path/
 * 
 * 
 * @author jairus
 *
 */
public class Q71 {

	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] paths = path != null ? path.split("/") : null;
		if (paths != null) {
			for (String p : paths) {
				if (p.length() > 0 && !p.equals("..") && !p.equals(".")) {
					stack.push(p);
				} else if (p.equals("..") && !stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		String sp = "";
		while (!stack.isEmpty()) {
			sp = "/" + stack.pop() + sp;
		}
		return sp.equals("") ? "/" : sp;
	}

	public static void main(String[] args) {

		Q71 q = new Q71();
		System.out.println(q.simplifyPath("/../"));
		System.out.println(q.simplifyPath("/../aaa"));
		System.out.println(q.simplifyPath("/../aaa/../bbb"));
		System.out.println(q.simplifyPath("/../aa/"));
		System.out.println(q.simplifyPath("/aaa/bbb/.././ccc"));
	}

}
