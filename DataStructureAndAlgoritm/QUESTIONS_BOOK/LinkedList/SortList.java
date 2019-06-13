package LinkedList;

import LinkedList.SortList.ListNode;

public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		Solution sol = new Solution();
		System.out.println(sol.sortList(head));
	}

	static public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static class Solution {
		public ListNode sortList(ListNode head) {
			if (head == null) {
				return head;
			}
			int count = 0;
			ListNode node = head;
			while (node != null) {
				count++;
				node = node.next;
			}

			return divide(head, 1, count);
		}

		private ListNode divide(ListNode node, int start, int end) {
			if (end == start)
				return node;

			int mid = (start + end) / 2;
			ListNode left = null;
			ListNode right = node;

			left = new ListNode(node.val);
			ListNode leftroot = null;
			leftroot = left;
			node = node.next;
			int temp = start + 1;
			while (temp <= mid) {
				left.next = new ListNode(node.val);
				left = left.next;
				node = node.next;
				temp++;
			}

			right = node;

			left = divide(leftroot, start, mid);
			right = divide(right, mid + 1, end);
			return merge(left, right);
		}

		public ListNode merge(ListNode left, ListNode right) {
			ListNode root=new ListNode(1);
			ListNode res=root;

			if (left.val < right.val) {
				res = new ListNode(left.val);
				left = left.next;
			} else {
				res =  new ListNode(right.val);
				right = right.next;
			}
			while (right != null && left != null) {
				if (left.val < right.val) {
					res.next = new ListNode( left.val);
					left = left.next;
					res = res.next;
				} else {
					res.next =  new ListNode(right.val);
					right = right.next;
					res = res.next;
				}
			}
			while (right != null) {
				res.next =  new ListNode(right.val);
				res = res.next;
				right = right.next;

			}
			while (left != null) {
				res.next =  new ListNode(left.val);
				res = res.next;
				left = left.next;
			}
			return root;
		}
	}

}
