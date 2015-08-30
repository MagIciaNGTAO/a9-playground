package org.mingtaoz.leetcode.list;

public class CopyRandomList {

    public static class RandomListNode {
        public int label;
        public RandomListNode next, random;

        public RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        // hack with copy next so the two lists are connected
        while (p != null) {
            RandomListNode next = p.next;
            RandomListNode copy = new RandomListNode(p.label);
            p.next = copy;
            copy.next = next;
            p = next;
        }
        // copy random
        p = head;
        while (p != null) {
            p.next.random = p.random != null ? p.random.next : null;
            p = p.next.next;
        }
        p = head;
        RandomListNode ret = p != null ? p.next : null;
        // restore next in both original list and copied list
        while (p != null) {
            RandomListNode originNext = p.next.next;
            p.next.next = originNext != null ? originNext.next : null;
            p.next = originNext;
            p = originNext;
        }
        return ret;
    }
}
