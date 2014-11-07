package org.mingtaoz.leetcode.list;

import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedList {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode newHead = null, cur = head;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    /**
     * 
     * Reverse a linked list from position m to n. Do it in-place and in
     * one-pass.
     * 
     * For example:
     * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * 
     * return 1->4->3->2->5->NULL.
     * 
     * Note:
     * Given m, n satisfy the following condition:
     * 1 ≤ m ≤ n ≤ length of list.
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    // TODO practise it for 3 times
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode start = null, cur = head, end = null, prev = null;
        for (int i = 1; i < m; i++) {
            start = cur;
            cur = cur.next;
        }
        prev = start;
        end = cur;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = prev;
            prev = temp;
        }
        end.next = cur;
        if (start == null) {
            return prev;
        } else {
            start.next = prev;
        }
        return head;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, normal = head;
        while (fast != null && fast.next != null) {
            if (fast.next == normal) {
                return true;
            }
            fast = fast.next.next;
            normal = normal.next;
        }
        return false;
    }

    // fast enter cycle : k - k (normal) - cycle (fast)
    // normal enter cycle: k - k - cycle (normal) - 2k (fast)
    // meet: k - k - cycle normal 2k to cycle starting point
    public ListNode detectCycle(ListNode head) {
        ListNode ret = null, fast = head, normal = head;
        while (fast != null && fast.next != null) {
            if (fast.next == normal) {
                break;
            }
            fast = fast.next.next;
            normal = normal.next;
        }
        if (fast != null && fast.next == normal) {
            normal = normal.next; // put normal to meeting spot
        } else {
            return ret;
        }
        ret = head;
        while (ret != normal) {
            ret = ret.next;
            normal = normal.next;
        }
        return ret;
    }

    // TODO refactoring 1.8
    public static <T> List<T> reverseCopy(List<T> source) {
        List<T> ret = new LinkedList<>();
        for (T t : source) {
            ret.add(0, t);
        }
        return ret;
    }

    public static <T> List<T> copy(List<T> source) {
        List<T> ret = new LinkedList<>();
        for (T t : source) {
            ret.add(t);
        }
        return ret;
    }
}
