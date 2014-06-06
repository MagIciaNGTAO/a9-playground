package org.mingtaoz.leetcode.sorting;

public class SortList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// kinda in place merge sort
	public ListNode sortList(ListNode head) {
		ListNode l1 = null, l2 = null;
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findTheMiddle(head);
		if (mid == null || mid.next == null) {
			l2 = mid;
		} else {
			ListNode midNext = mid.next;
			mid.next = null;
			l1 = sortList(head);
			l2 = sortList(midNext);
		}

		return merge(l1, l2);
	}

	// TODO how to find the middle accurate?
	// a -> b return a
	// a return null
	// a -> b -> c return b
	public ListNode findTheMiddle(ListNode head) {
		ListNode ret = null;
		while (head != null && head.next != null) {
			if (ret == null) {
				ret = head;
			} else {
				ret = ret.next;
			}
			head = head.next.next;
		}
		return ret;
	}

	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode ret = new ListNode(-1); // redundant
		ListNode listNode = ret;

		while (true) {
			if (l1 == null || l2 == null) {
				break;
			}
			if (l1.val < l2.val) {
				listNode.next = l1;
				l1 = l1.next;
			} else {
				listNode.next = l2;
				l2 = l2.next;
			}
			listNode = listNode.next;
		}

		// finish the rest of either list l1 or l2
		while (l1 != null) {
			listNode.next = l1;
			listNode = listNode.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			listNode.next = l2;
			listNode = listNode.next;
			l2 = l2.next;
		}

		return ret.next;
	}
}
