package org.mingtaoz.leetcode.list;

public class SwapNodesInPairs {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1), prevEnd = dummyHead;
        while (head != null) {
            if (head.next != null) {
                prevEnd.next = head.next;
                prevEnd = head;
                ListNode next = head.next.next;
                head.next.next = head;
                head = next;
            } else {
                prevEnd.next = head;
                return dummyHead.next;
            }
        }
        // always forgot this
        prevEnd.next = null;
        return dummyHead.next;
    }
}
