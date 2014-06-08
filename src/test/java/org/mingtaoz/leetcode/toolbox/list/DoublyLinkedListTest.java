package org.mingtaoz.leetcode.toolbox.list;

import org.mingtaoz.leetcode.toolbox.list.DoublyLinkedList.Node;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DoublyLinkedListTest extends TestCase {
	private DoublyLinkedList sut;

	public DoublyLinkedListTest(String testName) {
		super(testName);
		sut = new DoublyLinkedList();
	}

	public static Test suite() {
		return new TestSuite(DoublyLinkedListTest.class);
	}

	public void testDoblyLinkedList1() {
		Node n1 = new Node(1, 1);
		Node n2 = new Node(2, 2);
		Node n3 = new Node(3, 3);
		sut.addToFront(n1);
		assertEquals(1, sut.removeTail());
		sut.addToFront(n2);
		sut.addToFront(n3);
		sut.remove(n3);
		assertEquals(2, sut.removeTail());
	}

	public void testDoblyLinkedList2() {
		Node n1 = new Node(1, 1);
		Node n2 = new Node(2, 2);
		Node n3 = new Node(3, 3);
		sut.addToFront(n1);
		sut.addToFront(n2);
		sut.addToFront(n3);
		sut.remove(n3);
		assertEquals(1, sut.removeTail());
		assertEquals(2, sut.removeTail());
	}

	public void testDoblyLinkedList3() {
		Node n1 = new Node(1, 1);
		Node n2 = new Node(2, 2);
		Node n3 = new Node(3, 3);
		sut.addToFront(n1);
		sut.addToFront(n2);
		sut.addToFront(n3);
		assertEquals(1, sut.removeTail());
		assertEquals(2, sut.removeTail());
		assertEquals(3, sut.removeTail());
	}

	public void testDoblyLinkedList4() {
		Node n1 = new Node(1, 1);
		Node n2 = new Node(2, 2);
		Node n3 = new Node(3, 3);
		sut.addToFront(n1);
		sut.addToFront(n2);
		sut.addToFront(n3);
		assertEquals(1, sut.remove(n1));
		assertEquals(2, sut.remove(n2));
		assertEquals(3, sut.remove(n3));
	}
	
	public void testDoblyLinkedList5() {
		Node n1 = new Node(1, 1);
		Node n2 = new Node(2, 2);
		Node n3 = new Node(3, 3);
		Node n4 = new Node(4, 4);
		sut.addToFront(n1);
		sut.addToFront(n2);
		sut.addToFront(n3);
		sut.addToFront(n4);
		assertEquals("4:4,3:3,2:2,1:1,1:1,2:2,3:3,4:4,", sut.toString());
	}
	
	public void testDoblyLinkedList6() {
		Node n1 = new Node(1, 1);
		Node n2 = new Node(2, 2);
		Node n3 = new Node(3, 3);
		Node n4 = new Node(4, 4);
		sut.addToFront(n1);
		sut.addToFront(n2);
		sut.addToFront(n3);
		sut.addToFront(n4);
		sut.remove(n2);
		assertEquals("4:4,3:3,1:1,1:1,3:3,4:4,", sut.toString());
	}
	
	public void testDoblyLinkedList7() {
		Node n1 = new Node(1, 1);
		Node n2 = new Node(2, 2);
		Node n3 = new Node(3, 3);
		Node n4 = new Node(4, 4);
		sut.addToFront(n1);
		sut.addToFront(n2);
		sut.addToFront(n3);
		sut.addToFront(n4);
		sut.removeTail();
		assertEquals("4:4,3:3,2:2,2:2,3:3,4:4,", sut.toString());
	}
}
