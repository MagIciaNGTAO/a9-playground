package org.mingtaoz.leetcode.list;

class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
}

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode lessHead = new ListNode(-1), moreHead = new ListNode(-1), lessCur = lessHead, moreCur = moreHead;

		while (head != null) {
			if (head.val < x) {
				lessCur.next = head;
				lessCur = lessCur.next;
			} else {
				moreCur.next = head;
				moreCur = moreCur.next;
			}
			head = head.next;
		}

		lessCur.next = moreHead.next;
		moreCur.next = null;
		return lessHead.next;
	}
}
