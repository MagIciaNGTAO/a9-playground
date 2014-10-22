package org.mingtaoz.leetcode.list;

import org.mingtaoz.leetcode.list.SinglyLinkedList;
import org.mingtaoz.leetcode.list.SinglyLinkedList.ListNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SinglyLinkedListTest extends TestCase {
	private SinglyLinkedList sut;

	public SinglyLinkedListTest(String testName) {
		super(testName);
		sut = new SinglyLinkedList();
	}

	public static Test suite() {
		return new TestSuite(SinglyLinkedListTest.class);
	}

	public void testHasCycle1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n2;

		assertTrue(sut.hasCycle(n1));
	}

	public void testHasCycle2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;

		assertFalse(sut.hasCycle(n1));
	}

	public void testDetectCycle1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);

		n1.next = n2;
		n2.next = n3;
		n3.next = n2;

		assertEquals(n2, sut.detectCycle(n1));
	}

	public void testDetectCycle2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		assertEquals(n3, sut.detectCycle(n1));
	}

	public void testDetectCycle3() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		assertEquals(null, sut.detectCycle(n1));
	}

	public void testDetectCycle4() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);

		n1.next = n2;

		assertEquals(null, sut.detectCycle(n1));
	}
}
