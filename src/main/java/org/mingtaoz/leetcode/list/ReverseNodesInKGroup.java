package org.mingtaoz.leetcode.list;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 * 
 * @author mingtaozhang
 *
 */
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
