package org.mingtaoz.leetcode.list;

public class DoublyLinkedList {

	Node head;
	Node tail;

	public static class Node {
		public Node prev;
		public int key;
		public int value;
		public Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return key + ":" + value;
		}
	}

	public DoublyLinkedList() {
	}

	public int remove(Node node) {
		int ret = node.key; // key
		if (node.next == null && node.prev == null) {
			// only one case
			head = null;
			tail = null;
			return ret;
		}

		if (node.prev == null) {
			// prev null case
			head = node.next;
			head.prev = null;
			return ret;
		}

		if (node.next == null) {
			// next null case
			tail = node.prev;
			tail.next = null;
			return ret;
		}

		// normal case
		node.prev.next = node.next;
		node.next.prev = node.prev;
		return ret;
	}

	// this addToFront routine need to clear the old node pointers
	public void addToFront(Node node) {
		node.prev = null;
		if (head == null && tail == null) {
			// empty case
			node.next = null;
			head = node;
			tail = node;
			return;
		}

		// single/multi case
		node.next = head;
		head.prev = node;
		head = node;
	}

	// precondition: non empty
	public int removeTail() {
		int ret = tail.key;
		if (head == tail) {
			// single case
			head = null;
			tail = null;
			return ret;
		}

		tail = tail.prev;
		tail.next = null;
		return ret;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			ret.append(temp.toString()).append(",");
			temp = temp.next;
		}
		temp = tail;
		while (temp != null) {
			ret.append(temp.toString()).append(",");
			temp = temp.prev;
		}
		return ret.toString();
	}
}
