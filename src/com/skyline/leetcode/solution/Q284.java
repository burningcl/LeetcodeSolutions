package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Peeking Iterator
 * 
 * https://leetcode.com/problems/peeking-iterator/
 * 
 * @author jairus
 *
 */
public class Q284 {

	class PeekingIterator implements Iterator<Integer> {

		private List<Integer> list = null;

		private int index = 0;

		public PeekingIterator(Iterator<Integer> iterator) {
			list = new ArrayList<>();
			while (iterator != null && iterator.hasNext()) {
				list.add(iterator.next());
			}
			index = 0;
		}

		// Returns the next element in the iteration without advancing the
		// iterator.
		public Integer peek() {
			if (index >= list.size()) {
				return null;
			}
			return list.get(index);
		}

		// hasNext() and next() should behave the same as in the Iterator
		// interface.
		// Override them if needed.
		@Override
		public Integer next() {
			Integer next = peek();
			if (next != null) {
				index++;
			}
			return next;
		}

		@Override
		public boolean hasNext() {
			return index < list.size();
		}
	}

}
