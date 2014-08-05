package org.mingtaoz.leetcode.list;

public class RemoveDuplicatesSortedList {
	/**
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 * 
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		// cuz first one won't be deleted
		if (head == null)
			return null;
		ListNode prev = head, cur = head.next;
		while (cur != null) {
			if (cur.val != prev.val) {
				prev.next = cur;
				prev = prev.next;
			}
			cur = cur.next;
		}
		prev.next = null;
		return head;
	}

	public ListNode deleteAllDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode newDummyHead = new ListNode(-1), newCur = newDummyHead, prev = head, cur = head.next;
		boolean dup = false;
		while (cur != null) {
			if (cur.val != prev.val) {
				if (!dup) {
					newCur.next = prev;
					newCur = newCur.next;
				}
				dup = false;
			} else {
				dup = true;
			}
			prev = cur;
			cur = cur.next;
		}

		if (!dup) {
			// clear the prev buf
			newCur.next = prev;
			newCur = newCur.next;
		}

		newCur.next = null;

		return newDummyHead.next;
	}
}
