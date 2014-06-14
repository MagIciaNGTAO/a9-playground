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
		if (head == null) {
			return head;
		}
		// copy next, and old next point to new node
		RandomListNode cur = head, 
				dummy = new RandomListNode(-1),
				maintainance = new RandomListNode(-1),
				newCur = dummy, 
				next = null, 
				mainCur = maintainance;
		while (cur != null) {
			// for put everything back
			RandomListNode maintainanceNew = new RandomListNode(-1);
			maintainanceNew.next = cur.next;
			mainCur.random = maintainanceNew;
			mainCur = maintainanceNew;
			// copy next, and hook
			next = cur.next;
			RandomListNode newNode = new RandomListNode(cur.label);
			newNode.random = cur;
			newCur.next = newNode;
			cur.next = newNode;
			newCur = newNode;
			cur = next;
		}

		// copy the random pointer
		RandomListNode ret = dummy.next;
		newCur = ret;

		while (newCur != null) {
			next = newCur.next;
			cur = newCur.random;

			if (cur.random == null) {
				newCur.random = null;
			} else {
				newCur.random = cur.random.next;
			}

			// go further
			newCur = next;
		}

		// put everything back
		cur = head;
		maintainance = maintainance.random;
		
		while(maintainance != null) {
			cur.next = maintainance.next;
			maintainance = maintainance.random;
			cur = cur.next;
		}
		
		return ret;
	}
}
