package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Binary Search Tree Iterator
 * 
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * @author jairus
 *
 */
public class Q173 {
	public class BSTIterator {

		Stack<TreeNode> stack = null;

		public BSTIterator(TreeNode root) {
			this.stack = new Stack<>();
			this.push(root);
		}

		private void push(TreeNode root) {
			if (root == null) {
				return;
			}
			stack.push(root);
			this.push(root.left);
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			if (hasNext()) {
				TreeNode cur = stack.pop();
				this.push(cur.right);
				return cur.val;
			} else {
				return 0;
			}
		}
	}
}
