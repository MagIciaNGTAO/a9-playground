package org.mingtaoz.leetcode.list;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.mingtaoz.leetcode.list.CopyRandomList.RandomListNode;

public class CopyRandomListTest extends TestCase {

	private CopyRandomList sut;

	public CopyRandomListTest(String testName) {
		super(testName);
		sut = new CopyRandomList();
	}

	public static Test suite() {
		return new TestSuite(CopyRandomListTest.class);
	}

	public void testCopyRandomList1() {
		RandomListNode head = new RandomListNode(-1);
		assertEquals(-1, sut.copyRandomList(head).label);
	}

	public void testCopyRandomList2() {
		RandomListNode head = new RandomListNode(-1);
		RandomListNode next = new RandomListNode(-1);
		head.next = next;
		assertEquals(-1, sut.copyRandomList(head).label);
		assertEquals(-1, sut.copyRandomList(head).next.label);
	}
}
