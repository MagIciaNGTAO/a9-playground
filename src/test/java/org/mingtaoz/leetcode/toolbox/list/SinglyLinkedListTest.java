package org.mingtaoz.leetcode.toolbox.list;

import org.mingtaoz.leetcode.toolbox.list.SinglyLinkedList.ListNode;

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
		
		sut.head = n1;
		
		assertTrue(sut.hasCycle());
	}
	
	public void testHasCycle2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
	
		n1.next = n2;
		n2.next = n3;
		
		sut.head = n1;
	
		assertFalse(sut.hasCycle());
	}
	
	public void testDetectCycle1() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
	
		n1.next = n2;
		n2.next = n3;
		n3.next = n2;
		
		sut.head = n1;
		
		assertEquals(n2, sut.detectCycle());
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
		
		sut.head = n1;
		
		assertEquals(n3, sut.detectCycle());
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
		
		sut.head = n1;
		
		assertEquals(null, sut.detectCycle());
	}
	
	public void testDetectCycle4() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
	
		n1.next = n2;
		
		sut.head = n1;
		
		assertEquals(null, sut.detectCycle());
	}
}
