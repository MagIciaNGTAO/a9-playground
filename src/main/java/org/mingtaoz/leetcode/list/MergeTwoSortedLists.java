package org.mingtaoz.leetcode.list;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1), current = dummyHead;

		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				current.next = l2;
				l2 = l2.next;
			} else {
				current.next = l1;
				l1 = l1.next;
			}
			current = current.next;
		}

		while (l1 != null) {
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}

		while (l2 != null) {
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}

		return dummyHead.next;
	}
}
