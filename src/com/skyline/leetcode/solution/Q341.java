package com.skyline.leetcode.solution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Flatten Nested List Iterator
 * 
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * 
 * @author jairus
 *
 */
public class Q341 {

	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer> {

		List<NestedInteger> nestedList;

		Queue<Integer> queue = null;

		public NestedIterator(List<NestedInteger> nestedList) {
			this.nestedList = nestedList;
			queue = new LinkedList<>();
			for (NestedInteger nni : nestedList) {
				t(nni);
			}
		}

		protected void t(NestedInteger ni) {
			if (ni == null) {
				return;
			}
			if (ni.isInteger()) {
				queue.add(ni.getInteger());
			} else {
				List<NestedInteger> list = ni.getList();
				for (NestedInteger nni : list) {
					t(nni);
				}
			}
		}

		@Override
		public Integer next() {
			return queue.poll();
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
	}
}
