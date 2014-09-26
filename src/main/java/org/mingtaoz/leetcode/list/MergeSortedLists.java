package org.mingtaoz.leetcode.list;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode ret = new ListNode(-1), cur = ret;
		if (lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(
				lists.size(), new Comparator<ListNode>() {
					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}
				});

		for (ListNode node : lists) {
			if (node != null) {
				priorityQueue.add(node);
			}
		}

		while (priorityQueue.size() > 0) {
			ListNode node = priorityQueue.poll();
			cur.next = node;
			cur = cur.next;
			if (node.next != null) {
				priorityQueue.add(node.next);
			}
		}

		return ret.next;
	}

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
