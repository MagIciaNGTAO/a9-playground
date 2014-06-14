package org.mingtaoz.leetcode.toolbox.list;

public class SinglyLinkedList {

	public ListNode head;

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public SinglyLinkedList() {
	}

	public ListNode findMiddle() {
		return findMiddle(head);
	}

	public ListNode reverse() {
		return reverse(head);
	}
	
    public boolean hasCycle() {
        return hasCycle(head);
    }

    public ListNode detectCycle() {
        return detectCycle(head);
    }
    
	public static ListNode findMiddle(ListNode head) {
		ListNode fast = head, normal = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			normal = normal.next;
		}

		return normal;
	}

	public static ListNode reverse(ListNode head) {
		ListNode newHead = null, cur = head;

		while(cur != null) {
			ListNode temp = cur;
			cur = cur.next;
			temp.next = newHead;
			newHead = temp;
		}
		
		return newHead;
	}
    
    public static boolean hasCycle(ListNode head) {
		ListNode fast = head, normal = head;
		while (fast != null && fast.next != null) {
			if(fast.next == normal) {
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
    public static ListNode detectCycle(ListNode head) {
        ListNode ret = null;
        
		ListNode fast = head, normal = head;
		while (fast != null && fast.next != null) {
			if(fast.next == normal) {
				
				break;
			}
			fast = fast.next.next;
			normal = normal.next;
		}
		
		if(fast != null && fast.next == normal) {
			normal = normal.next; // put normal to meeting spot
		} else {
			return ret;
		}
		
		ret = head;
		
		while(ret != normal) {
			ret = ret.next;
			normal = normal.next;
		}
		
        return ret;
    }
}
