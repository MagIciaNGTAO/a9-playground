package org.mingtaoz.leetcode.list;

import org.junit.Before;
import org.junit.Test;

import static org.truth0.Truth.ASSERT;

public class MergeTwoSortedListsTest {

	private MergeTwoSortedLists sut;

	@Before
	public void setup() {
		sut = new MergeTwoSortedLists();
	}

	@Test
	public void testDeleteDuplicates1() {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;

		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(6);
		b1.next = b2;
		b2.next = b3;

		ListNode c1 = new ListNode(1);
		ListNode c2 = new ListNode(2);
		ListNode c3 = new ListNode(3);
		ListNode c4 = new ListNode(4);
		ListNode c5 = new ListNode(5);
		ListNode c6 = new ListNode(6);
		c1.next = c2;
		c2.next = c3;
		c3.next = c4;
		c4.next = c5;
		c5.next = c6;

		ListNode ret = sut.mergeTwoLists(a1, b1);

		ListNode cur = c1;
		ListNode curR = ret;
		while (cur != null) {
			ASSERT.that(curR.val).is(cur.val);
			curR = curR.next;
			cur = cur.next;
		}
	}
}
