package org.mingtaoz.leetcode.list;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public static class Node {
        public int key;
        public int value;

        public Node prev;
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

        // middle of no where :)
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return ret;
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

    // precondition: non empty
    public int removeFront() {
        int ret = head.key;
        if (head == tail) {
            // single case
            head = null;
            tail = null;
            return ret;
        }

        head = head.next;
        head.prev = null;
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
