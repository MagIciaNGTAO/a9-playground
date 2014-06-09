package org.mingtaoz.leetcode.sorting;

import org.mingtaoz.leetcode.sorting.SortList.ListNode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SortListTest extends TestCase {

	private SortList sut;

	public SortListTest(String testName) {
		super(testName);
		sut = new SortList();
	}

	public static Test suite() {
		return new TestSuite(SortListTest.class);
	}

	public void testFindTheMiddle1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		assertEquals(n2.val, sut.findTheMiddle(n1).val);
	}

	public void testFindTheMiddle2() {
		ListNode n1 = new ListNode(1);
		assertEquals(null, sut.findTheMiddle(n1));
	}

	public void testFindTheMiddle3() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		assertEquals(n1.val, sut.findTheMiddle(n1).val);
	}

	public void testMerge() {
		ListNode l1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		ListNode n4 = new ListNode(5);

		l1.next = n2;
		n2.next = n3;

		l2.next = n4;

		ListNode result = sut.merge(l1, l2);
		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
		assertEquals(3, result.next.next.val);
		assertEquals(4, result.next.next.next.val);
		assertEquals(5, result.next.next.next.next.val);
	}

	public void testSortList1() {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		ListNode result = sut.sortList(n1);
		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
		assertEquals(3, result.next.next.val);
		assertEquals(4, result.next.next.next.val);
		assertEquals(5, result.next.next.next.next.val);
	}

	public void testSortList2() {
		ListNode n1 = new ListNode(2);

		ListNode result = sut.sortList(n1);
		assertEquals(2, result.val);
	}
	
	public void testInsertionSortList1() {
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;

		ListNode result = sut.insertionSortList(n1);
		assertEquals(1, result.val);
		assertEquals(3, result.next.val);
		assertEquals(4, result.next.next.val);
	}
}
