package org.mingtaoz.leetcode.toolbox.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.mingtaoz.leetcode.toolbox.list.SinglyLinkedList;
import org.mingtaoz.leetcode.toolbox.list.SinglyLinkedList.ListNode;

public class BinaryTree {
	public static class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public class TreeLinkNode {
		public int val;
		public TreeLinkNode left, right, next;

		public TreeLinkNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (root == null)
			return ret;
		ret.add(root.val);
		ret.addAll(preorderTraversal(root.left));
		ret.addAll(preorderTraversal(root.right));
		return ret;
	}

	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur == null)
				continue;
			ret.add(cur.val);
			stack.push(cur.right);
			stack.push(cur.left);
		}
		return ret;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		if (root == null)
			return ret;
		ret.addAll(postorderTraversal(root.left));
		ret.addAll(postorderTraversal(root.right));
		ret.add(root.val);
		return ret;
	}

	public int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root, 0);
	}

	// TODO huhuh not sure why it's working, need to revisit
	public int sumNumbersHelper(TreeNode root, int prev) {
		if (root == null)
			return prev;

		int ret = 0;
		if (root.left != null) {
			ret += sumNumbersHelper(root.left, (prev + root.val) * 10);
		}

		if (root.right != null) {
			ret += sumNumbersHelper(root.right, (prev + root.val) * 10);
		}

		if (ret == 0) {
			ret = prev + root.val;
		}

		return ret;
	}

	public int maxPathSum(TreeNode root) {
		Data ret = maxPathSumHelper(root);
		return Math.max(ret.maxCanGrow, ret.maxCantGrow);
	}

	public static class Data {
		public int maxCantGrow;
		public int maxCanGrow;

		public Data() {
		}

		public Data(int maxCantGrow, int maxCanGrow) {
			this.maxCantGrow = maxCantGrow;
			this.maxCanGrow = maxCanGrow;
		}
	}

	public Data maxPathSumHelper(TreeNode node) {
		if (node == null)
			return new Data(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Data left = maxPathSumHelper(node.left);
		Data right = maxPathSumHelper(node.right);
		int maxCanGrow = Math.max(left.maxCanGrow > 0 ? left.maxCanGrow : 0,
				right.maxCanGrow > 0 ? right.maxCanGrow : 0) + node.val;
		int maxCantGrow = Math.max((left.maxCanGrow > 0 ? left.maxCanGrow : 0)
				+ node.val + (right.maxCanGrow > 0 ? right.maxCanGrow : 0),
				Math.max(left.maxCantGrow, right.maxCantGrow)); // TODO this
																// part is
																// tricky

		return new Data(maxCantGrow, maxCanGrow);
	}

	// public List<Integer> postorderTraversalIterativel(TreeNode root) {
	// List<Integer> ret = new LinkedList<Integer>();
	// Stack<TreeNode> stack = new Stack<TreeNode>();
	// TreeNode cur = root, lastVisited = null;
	// while (cur != null || !stack.isEmpty()) {
	// if (cur != null) {
	// stack.push(cur);
	// cur = cur.left;
	// } else {
	// TreeNode parent = stack.peek();
	// if (parent.right != null && lastVisited != parent.right) {
	// // make sure pop all the node has right child of the
	// // previous pop
	// cur = parent.right;
	// } else {
	// stack.pop();
	// ret.add(parent.val);
	// lastVisited = parent;
	// }
	// }
	// }
	// return ret;
	// }

	public List<Integer> postorderTraversalIterativel(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode parent = stack.peek(), child = null;
				if (parent.right == null) {
					// pop hard
					stack.pop();
					while (parent.right == child && !stack.isEmpty()) {
						child = parent;
						ret.add(child.val);
						parent = stack.pop();
					}
				} else {
					cur = parent.right;
				}
			}
		}
		return ret;
	}

	// layers traversal ~= BFS
	// working: both i and ii for populating-next-right-pointers-in-each-node
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> curLayer = new LinkedList<>(), nextLayer = new LinkedList<>();
		TreeLinkNode next = null;
		curLayer.add(root);
		while (!curLayer.isEmpty()) {
			TreeLinkNode cur = curLayer.poll();
			cur.next = next;
			next = cur;
			if (cur.right != null) {
				nextLayer.add(cur.right);
			}
			if (cur.left != null) {
				nextLayer.add(cur.left);
			}
			if (curLayer.isEmpty()) {
				// next layer
				curLayer = nextLayer;
				nextLayer = new LinkedList<>();
				next = null;
			}
		}
	}

	/**
	 * Given a binary tree, flatten it to a linked list in-place.
	 * 
	 * TODO still need the stack space?
	 * 
	 * @param root
	 */
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode dummyHead = new TreeNode(-1), dummyCur = dummyHead;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			dummyCur.right = cur;
			dummyCur.left = null;
			dummyCur = cur;
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		root = dummyHead.right;
	}

	/**
	 * 
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			// leaf
			return 1;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			return sum - root.val == 0;
		}
		if (root.left == null) {
			return hasPathSum(root.right, sum - root.val);
		}
		if (root.right == null) {
			return hasPathSum(root.left, sum - root.val);
		}
		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new LinkedList<>();
		pathSumHelper(root, sum, ret, new LinkedList<>());
		return ret;
	}

	private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> ret,
			List<Integer> cur) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			cur.add(root.val);
			if (sum - root.val == 0) {
				ret.add(SinglyLinkedList.copy(cur));
			}
			cur.remove(cur.size() - 1);
			return;
		}
		if (root.left == null) {
			cur.add(root.val);
			pathSumHelper(root.right, sum - root.val, ret, cur);
			cur.remove(cur.size() - 1);
			return;
		}
		if (root.right == null) {
			cur.add(root.val);
			pathSumHelper(root.left, sum - root.val, ret, cur);
			cur.remove(cur.size() - 1);
			return;
		}
		cur.add(root.val);
		pathSumHelper(root.right, sum - root.val, ret, cur);
		pathSumHelper(root.left, sum - root.val, ret, cur);
		cur.remove(cur.size() - 1);
	}

	/**
	 * 
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return isBalancedHelper(root) != -1;
	}

	private int isBalancedHelper(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 1;
		}
		int left = 0, right = 0;
		if (root.left != null) {
			left = isBalancedHelper(root.left);
			if (left == -1)
				return -1;
		}
		if (root.right != null) {
			right = isBalancedHelper(root.right);
			if (right == -1)
				return -1;
		}
		int diff = Math.abs(right - left);
		int depth = Math.max(left, right) + 1;
		return diff <= 1 ? depth : -1;
	}

	/**
	 * 
	 * Convert Sorted Array to Binary Search Tree
	 * 
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 * 
	 * @param num
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;
		return sortedArrayToBSTHelper(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBSTHelper(int[] num, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start + 1) / 2;
		TreeNode cur = new TreeNode(num[mid]);
		cur.left = sortedArrayToBSTHelper(num, start, mid - 1);
		cur.right = sortedArrayToBSTHelper(num, mid + 1, end);
		return cur;
	}

	/**
	 * 
	 * Given a singly linked list where elements are sorted in ascending order,
	 * convert it to a height balanced BST.
	 * 
	 * @param head
	 * @return
	 */
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int n = 0;
		ListNode cur = head;
		while (cur != null) {
			cur = cur.next;
			n++;
		}
		return sortedListToBSTHelper(head, n);
	}

	// length is number of nodes
	private TreeNode sortedListToBSTHelper(ListNode start, int length) {
		if (length < 1) {
			return null;
		}
		if (length == 1) {
			return new TreeNode(start.val);
		}
		int mid = length / 2 + 1, n = 1;
		ListNode findMid = start;
		while (n < mid) {
			findMid = findMid.next;
			n++;
		}
		TreeNode cur = new TreeNode(findMid.val);
		cur.left = sortedListToBSTHelper(start, mid - 1);
		cur.right = sortedListToBSTHelper(findMid.next, length - mid);
		return cur;
	}

	/**
	 * 
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ret = new LinkedList<>();
		if (root == null)
			return ret;
		Queue<TreeNode> curLevel = new LinkedList<>(), nextLevel = new LinkedList<>();
		curLevel.add(root);
		while (!curLevel.isEmpty()) {
			List<Integer> tempLevel = new LinkedList<>();
			while (!curLevel.isEmpty()) {
				TreeNode cur = curLevel.poll();
				tempLevel.add(cur.val);
				if (cur.left != null) {
					nextLevel.add(cur.left);
				}
				if (cur.right != null) {
					nextLevel.add(cur.right);
				}
			}
			curLevel = nextLevel;
			nextLevel = new LinkedList<>();
			ret.add(0, tempLevel);
		}
		return ret;
	}

	/**
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return null;
	}

	/**
	 * Given inorder and postorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 * 
	 * @param inorder
	 * @param postorder
	 * @param dummy
	 * @return
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder, int dummy) {
		return null;
	}

	/**
	 * 
	 * Given a binary tree, find its maximum depth. The maximum depth is the
	 * number of nodes along the longest path from the root node down to the
	 * farthest leaf node.
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return maxDepth(root.right) + 1;
		}
		if (root.right == null) {
			return maxDepth(root.left) + 1;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
