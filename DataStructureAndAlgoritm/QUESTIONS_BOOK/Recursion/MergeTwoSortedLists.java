/*
 *   Merge Two Sorted Lists
  Go to Discuss
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
package Recursion;

import Recursion.SwapNodesinPairs.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1= new ListNode(1);
		node1.next= new ListNode(2);
		node1.next.next=new ListNode(4);

		ListNode node2= new ListNode(1);
		node2.next= new ListNode(3);
		node2.next.next=new ListNode(4);
		ListNode res= mergeTwoLists(node1, node2);
		while(res!=null) {
			System.out.println(res.val);
			res=res.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
