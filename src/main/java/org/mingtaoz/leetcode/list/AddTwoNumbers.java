package org.mingtaoz.leetcode.list;

public class AddTwoNumbers {

	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode retDummy = new ListNode(-1), cur = retDummy;
		boolean carry = false;
		while (l1 != null && l2 != null) {
			// TODO the paranthesis is important!
			int v = (carry ? 1 : 0) + l1.val + l2.val;
			if (v > 9) {
				carry = true;
				v = v - 10;
			} else {
				carry = false;
			}
			cur.next = new ListNode(v);
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int v = (carry ? 1 : 0) + l1.val;
			if (v > 9) {
				carry = true;
				v = v - 10;
			} else {
				carry = false;
			}
			cur.next = new ListNode(v);
			cur = cur.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int v = (carry ? 1 : 0) + l2.val;
			if (v > 9) {
				carry = true;
				v = v - 10;
			} else {
				carry = false;
			}
			cur.next = new ListNode(v);
			cur = cur.next;
			l2 = l2.next;
		}
		if (carry) {
			cur.next = new ListNode(1);
		}
		return retDummy.next;
	}
}
