package org.mingtaoz.leetcode.list;

public class ReverseNodesInKGroup {

	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	// 12345678
	// 32165478
	// TODO should I try best to deal with common case with short code?
	// or just list and complete cases with longer code
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1) {
			return head;
		}
		ListNode dummyHead = new ListNode(-1), prevGroupEnd = dummyHead;
		while (head != null) {
			int i = k;
			// connect
			ListNode cur = head, prev = null;
			while (i > 0 && cur != null) {
				prev = cur;
				cur = cur.next;
				i--;
			}
			if (i == 0) {
				prevGroupEnd.next = prev;
			} else {
				prevGroupEnd.next = head;
				return dummyHead.next;
			}
			prevGroupEnd = head;
			// reverse
			cur = head;
			prev = null;
			i = k;
			while (i-- > 0) {
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			head = cur;
		}
		return dummyHead.next;
	}
}
