package org.mingtaoz.leetcode.list;

public class RotateList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * Given a list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * For example: Given 1->2->3->4->5->NULL and k = 2, return
	 * 4->5->1->2->3->NULL.
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int n) {
		ListNode fast = head, slow = head;
		if (fast == null) {
			return null;
		}
		// rotate as if it's cyclic list
		while (n-- > 0) {
			fast = fast.next;
			if (fast == null) {
				fast = head;
			}
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		fast.next = head;
		ListNode ret = slow.next;
		slow.next = null;
		return ret;
	}

	// public ListNode rotateRight(ListNode head, int n) {
	// ListNode newHead = null, prevTail = head, next = head.next, prev = null;
	//
	// while (head != null) {
	// int k = n;
	// // reverse k
	// while (k-- > 0 && head != null) {
	// head.next = prev;
	// prev = head;
	// head = next;
	// next = head.next;
	// }
	// if (newHead == null) {
	// newHead = head;
	// }
	// // connect
	// prevTail.next = next;
	// // scan k
	// k = n;
	// while (k-- > 0 && head != null) {
	// head = next;
	// next = head.next;
	// }
	// prevTail = head;
	// }
	// return newHead;
	// }

	private ListNode reverse(ListNode head, int n) {
		ListNode next = head.next, prev = null;
		while (n-- > 0 && next != null) {
			head.next = prev;
			prev = head;
			head = next;
			next = head.next;
		}
		return head;
	}
}
