package org.mingtaoz.leetcode.list;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1), current = dummyHead;
        while (head != null) {
            if (head.val != val) {
                current.next = head;
                current = head;
            }
            head = head.next;
        }
        current.next = null;
        return dummyHead.next;
    }
}
