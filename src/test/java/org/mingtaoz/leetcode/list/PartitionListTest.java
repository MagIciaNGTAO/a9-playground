package org.mingtaoz.leetcode.list;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PartitionListTest extends TestCase {

	private PartitionList sut;

	public PartitionListTest(String testName) {
		super(testName);
		sut = new PartitionList();
	}

	public static Test suite() {
		return new TestSuite(PartitionListTest.class);
	}

	public void testPartitionList1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode ret = sut.partition(n1, 3);

		assertEquals(1, ret.val);
		assertEquals(2, ret.next.val);
		assertEquals(2, ret.next.next.val);
		assertEquals(4, ret.next.next.next.val);
		assertEquals(3, ret.next.next.next.next.val);
		assertEquals(5, ret.next.next.next.next.next.val);
	}

	public void testPartitionList2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode ret = sut.partition(n1, 1);

		assertEquals(1, ret.val);
		assertEquals(4, ret.next.val);
		assertEquals(3, ret.next.next.val);
		assertEquals(2, ret.next.next.next.val);
		assertEquals(5, ret.next.next.next.next.val);
		assertEquals(2, ret.next.next.next.next.next.val);
	}

	public void testPartitionList3() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode ret = sut.partition(n1, 5);

		assertEquals(1, ret.val);
		assertEquals(4, ret.next.val);
		assertEquals(3, ret.next.next.val);
		assertEquals(2, ret.next.next.next.val);
		assertEquals(2, ret.next.next.next.next.val);
		assertEquals(5, ret.next.next.next.next.next.val);
	}

	public void testPartitionList4() {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);

		n1.next = n2;

		ListNode ret = sut.partition(n1, 2);

		assertEquals(1, ret.val);
		assertEquals(2, ret.next.val);
		assertEquals(null, ret.next.next);
	}

}
