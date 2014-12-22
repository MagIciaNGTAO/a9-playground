package org.mingtaoz.leetcode.list;

public class ReverseNodesInKGroup {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1), prevGroupEnd = dummyHead;
        while (head != null) {
            int i = k;
            // 1. connect
            ListNode cur = head, prev = null;
            while (i > 0 && cur != null) {
                prev = cur;
                cur = cur.next;
                i--;
            }
            if (cur != null) {
                prevGroupEnd.next = prev;
            } else {
                prevGroupEnd.next = head;
                return dummyHead.next;
            }
            prevGroupEnd = head;
            // 2. reverse
            cur = head;
            prev = null;
            i = k;
            while (i-- > 0) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            head = cur;
        }
        return dummyHead.next;
    }
    

}
