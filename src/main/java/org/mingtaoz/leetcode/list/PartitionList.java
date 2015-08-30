package org.mingtaoz.leetcode.list;

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}

public class PartitionList {

    /**
     * 
     * Partition List
     * 
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.
     * 
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1), moreHead = new ListNode(-1), lessCur = lessHead, moreCur = moreHead;
        while (head != null) {
            if (head.val < x) {
                lessCur.next = head;
                lessCur = lessCur.next;
            } else {
                moreCur.next = head;
                moreCur = moreCur.next;
            }
            head = head.next;
        }
        lessCur.next = moreHead.next;
        moreCur.next = null;
        return lessHead.next;
    }
}
