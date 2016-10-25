package com.skyline.leetcode.solution;

/**
 * Palindrome Linked List
 * 
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * @author jairus
 *
 */
public class Q234 {

	public ListNode reverse(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = cur.next;
		cur.next = null;
		while (next != null) {
			ListNode last = next.next;
			next.next = cur;
			cur = next;
			next = last;
		}
		return cur;
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode h1 = head, h2 = head, t = null, c = head;
		while (c != null) {
			t = h2;
			h2 = h2.next;
			c = c.next;
			if (c != null) {
				c = c.next;
			}
		}
		t.next = null;
		h2 = reverse(h2);
		while (h1 != null && h2 != null) {
			if (h1.val != h2.val) {
				return false;
			}
			h1 = h1.next;
			h2 = h2.next;
		}
		return true;
	}

	public static void main(String... strings) {
		Q234 q = new Q234();
		int[] nums1 = { 1, 2, 3 };
		System.out.println(q.reverse(ListNode.toList(nums1)));
		int[] nums2 = { 1, 2, 3, 4 };
		System.out.println(q.reverse(ListNode.toList(nums2)));
		int[] nums3 = { 1, 2 };
		System.out.println(q.reverse(ListNode.toList(nums3)));

		int[] nums4 = { 1, 2, 2, 1 };
		System.out.println(q.isPalindrome(ListNode.toList(nums4)));
		int[] nums5 = { 1, 2, 5, 2, 1 };
		System.out.println(q.isPalindrome(ListNode.toList(nums5)));
		int[] nums6 = { 1,1 };
		System.out.println(q.isPalindrome(ListNode.toList(nums6)));
		int[] nums7 = { 1,2,3,4,5,5,4,3,2,1};
		System.out.println(q.isPalindrome(ListNode.toList(nums7)));
	}

}
