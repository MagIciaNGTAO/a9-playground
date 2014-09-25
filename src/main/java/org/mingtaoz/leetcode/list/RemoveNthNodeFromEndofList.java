package org.mingtaoz.leetcode.list;

public class RemoveNthNodeFromEndofList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, fast = cur, prev = null;
		// move one more, so cur is one less
		while (fast != null && n > 0) {
			fast = fast.next;
			n--;
		}
		while (fast != null) {
			fast = fast.next;
			prev = cur;
			cur = cur.next;
		}
        if(null == prev) {
			return head.next;
		} else {
			prev.next = cur.next;
			return head;
		}
	}
}
