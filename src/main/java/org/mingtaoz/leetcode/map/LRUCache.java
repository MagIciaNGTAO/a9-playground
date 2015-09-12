package org.mingtaoz.leetcode.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 */
interface Cache {
    int get(int key);

    void set(int key, int value);
}

public class LRUCache implements Cache {

    private int capacity;
    private Map<Integer, Node> map;
    private DoublyLinkedList accessList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        accessList = new DoublyLinkedList();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            accessList.remove(node);
            node.prev = null;
            node.next = null;
            accessList.addToFront(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            // TODO ??
            accessList.remove(node);
            node.prev = null;
            node.next = null;
            accessList.addToFront(node);
        } else {
            if (map.size() == capacity) {
                int removeKey = accessList.removeTail();
                map.remove(removeKey);
            }
            Node newNode = new Node(key, value);
            accessList.addToFront(newNode);
            map.put(key, newNode);
        }
    }

    class Node {
        public Node prev;
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;

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

            // normal
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return ret;
        }

        public void addToFront(Node node) {
            if (head == null) {
                // empty
                node.next = null;
                head = node;
                tail = node;
                return;
            }

            // single/multi
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
    }
}
