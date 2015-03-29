package org.mingtaoz.leetcode.list;

public class AddTwoNumbers {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode retDummy = new ListNode(-1), cur = retDummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            carry = v / 10;
            cur.next = new ListNode(v % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return retDummy.next;
    }
}
