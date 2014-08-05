package org.mingtaoz.leetcode.list;

import org.junit.Before;
import org.junit.Test;

import static org.truth0.Truth.ASSERT;

public class RemoveDuplicatesSortedListTest {

	private RemoveDuplicatesSortedList sut;

	@Before
	public void setup() {
		sut = new RemoveDuplicatesSortedList();
	}

	/**
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 */
	@Test
	public void testDeleteDuplicates1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);

		n1.next = n2;
		n2.next = n3;

		ListNode ret = sut.deleteDuplicates(n1);

		ASSERT.that(ret).is(n1);
		ASSERT.that(ret.next).is(n3);
		ASSERT.that(ret.next.next).isNull();
	}

	@Test
	public void testDeleteDuplicates2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode ret = sut.deleteDuplicates(n1);

		ASSERT.that(ret).is(n1);
		ASSERT.that(ret.next).is(n3);
		ASSERT.that(ret.next.next).is(n4);
		ASSERT.that(ret.next.next.next).isNull();
	}

	@Test
	public void testDeleteAllDuplicates1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode ret = sut.deleteAllDuplicates(n1);

		ASSERT.that(ret).is(n3);
		ASSERT.that(ret.next).isNull();
	}
}
