package com.skyline.leetcode.solution;

/**
 * Intersection of Two Linked Lists
 * 
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * @author jairus
 * 
 */
public class Q160 {

	private int len(ListNode cur) {
		int cnt = 0;
		while (cur != null) {
			cur = cur.next;
			cnt++;
		}
		return cnt;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int cntA = len(headA);
		int cntB = len(headB);
		ListNode cur = null;
		int step = 0;
		if (cntA > cntB) {
			cur = headA;
			step = cntA - cntB;
		} else {
			cur = headB;
			step = cntB - cntA;
		}
		while (step-- > 0) {
			cur = cur.next;
		}
		ListNode curA=headA;
		ListNode curB=headB;
		if (cntA > cntB) {
			curA=cur;
		}else{
			curB=cur;
		}
		while(curA!=curB){
			curA=curA.next;
			curB=curB.next;
		}
		return curA;
	}
}
