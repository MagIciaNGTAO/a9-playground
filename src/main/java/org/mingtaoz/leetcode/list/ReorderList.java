package org.mingtaoz.leetcode.list;

import org.mingtaoz.leetcode.toolbox.list.SinglyLinkedList.ListNode;
import static org.mingtaoz.leetcode.toolbox.list.SinglyLinkedList.*;

public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode mid = findMiddle(head);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode secondHalf = reverse(midNext);

		while (head != null && secondHalf != null) {
			ListNode temp = head.next;
			head.next = secondHalf;
			secondHalf.next = temp;
			head = temp;
		}
	}
}
