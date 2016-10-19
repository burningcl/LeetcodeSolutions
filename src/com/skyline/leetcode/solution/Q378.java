package com.skyline.leetcode.solution;

/**
 * Kth Smallest Element in a Sorted Matrix
 * 
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * @author jairus
 *
 */
public class Q378 {

	public class Heap {

		protected Item[] array = null;

		protected int size;

		public Heap(int max) {
			array = new Item[max];
			size = 0;
		}

		private void swap(int i, int j) {
			if (i < 0 || j < 0) {
				return;
			}
			Item t = array[i];
			array[i] = array[j];
			array[j] = t;
		}

		public void inset(Item item) {
			int index = size++;
			array[index] = item;
			shiftUp(index);
		}

		protected void shiftUp(int index) {
			while (index > 0) {
				int pIndex = (index - 1) / 2;
				if (array[pIndex].val > array[index].val) {
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
					sIndex = array[lIndex].val < array[rIndex].val ? lIndex : rIndex;
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

		public Item peek() {
			int index = 0;
			Item item = array[index];
			index = shiftDown(index);
			swap(index, size - 1);
			shiftUp(index);
			size--;
			return item;
		}
	}

	public class Item {

		public int val;

		public int row;

		public Item(int val, int row) {
			this.val = val;
			this.row = row;
		}

	}

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int[] columns = new int[n];
		Heap heap = new Heap(n);
		for (int i = 0; i < n; i++) {
			heap.inset(new Item(matrix[i][0], i));
		}
		for (int i = 0; i < k && heap.size > 0; i++) {
			Item item = heap.peek();
			System.out.println(i + ":" + item.val + "," + heap.size);
			if (i == k - 1) {
				return item.val;
			}
			int row = item.row;
			int col = ++columns[row];
			System.out.println("pos:"+row + ", " + col);
			if (col < n) {
				heap.inset(new Item(matrix[row][col], row));
			}
		}
		return 0;
	}
}
