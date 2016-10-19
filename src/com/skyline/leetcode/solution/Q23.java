package com.skyline.leetcode.solution;

/**
 * Merge k Sorted Lists
 * 
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * @author jairus
 *
 */
public class Q23 {

	public static class Heap {

		public int[][] array = null;

		public int size;

		public Heap(int max) {
			array = new int[max][2];
			size = 0;
		}

		private void swap(int i, int j) {
			if (i < 0 || j < 0) {
				return;
			}
			int[] t = array[i];
			array[i] = array[j];
			array[j] = t;
		}

		public void inset(int[] ele) {
			int index = size++;
			array[index] = ele;
			shiftUp(index);
		}

		protected void shiftUp(int index) {
			while (index > 0) {
				int pIndex = (index - 1) / 2;
				if (array[pIndex][0] > array[index][0]) {
					swap(pIndex, index);
					index = pIndex;
				} else {
					break;
				}
			}
		}

		protected int shiftDown(int index) {
			while (index < size) {
				int lIndex = index * 2 + 1;
				int rIndex = index * 2 + 2;
				int sIndex = -1;
				if (lIndex < size && rIndex < size) {
					sIndex = array[lIndex][0] < array[rIndex][0] ? lIndex : rIndex;
				} else if (lIndex < size) {
					sIndex = lIndex;
				} else if (rIndex < size) {
					sIndex = rIndex;
				} else {
					break;
				}
				array[index] = array[sIndex];
				index = sIndex;
			}
			return index;
		}

		public int[] peek() {
			int index = 0;
			int[] ele = array[0];
			index = shiftDown(index);
			swap(index, size - 1);
			shiftUp(index);
			size--;
			return ele;
		}

		public void print() {
			for (int i = 0; i < size; i++) {
				System.out.print(array[i][0] + "\t");
			}
			System.out.println();
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length <= 0) {
			return null;
		} else if (lists.length == 1) {
			return lists[0];
		}
		Heap heap = new Heap(lists.length);
		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			if (node == null) {
				continue;
			}
			int[] ele = new int[2];
			ele[0] = node.val;
			ele[1] = i;
			heap.inset(ele);
		}
		ListNode head = null;
		ListNode cur = null;
		while (heap.size > 0) {
			//heap.print();
			int[] ele = heap.peek();
			int index = ele[1];
			//System.out.println(index);
			ListNode node = lists[index];
			if (head == null) {
				head = node;
				cur = node;
			} else {
				cur.next = node;
				cur = node;
			}
			node = node.next;
			lists[index] = lists[index].next;
			if (node != null) {
				ele[0] = node.val;
				heap.inset(ele);
			}
		}
		return head;
	}

	public static void main(String... strings) {

		Q23 q = new Q23();
		int[][] arrays = { { -3, 2, 2 }, { -9 }, { -10, -5, -4, -2, -1, 1, 3, 4 }, { -10, -9, -8, 3, 4 },
				{ -5, -3, 3, 4 }, { -9, -8, -5, -4, -2, -1, 3 } };
		ListNode[] lists = { ListNode.toList(arrays[0]), ListNode.toList(arrays[1]), ListNode.toList(arrays[2]),
				ListNode.toList(arrays[3]), ListNode.toList(arrays[4]), ListNode.toList(arrays[5]), };
		System.out.println(q.mergeKLists(lists));
	}
}
