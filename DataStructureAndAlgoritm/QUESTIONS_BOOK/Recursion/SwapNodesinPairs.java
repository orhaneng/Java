/*https://leetcode.com/problems/swap-nodes-in-pairs/
 * 24. Swap Nodes in Pairs
Medium
Favorit
Share
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
package Recursion;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node= new ListNode(1);
		node.next= new ListNode(2);
		node.next.next=new ListNode(3);
		node.next.next.next=new ListNode(4);
		ListNode res =swapPairs4(node);
		while(res!=null) {
			System.out.println(res.val);
			res=res.next;
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
  
    public static ListNode swapPairs4(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs4(head.next.next);
        n.next = head;
        return n;
    }
	public static ListNode swapPairs(ListNode head) {
		ListNode node = head;
		if (node == null)
			return null;
		if (node.next == null)
			return node;
		
		while(node!=null&&node.next!=null) {
			ListNode temp = node.next;
			node.next = node.next.next;
			temp.next = node;
			node=node.next.next;
		}
		//helper(node);
		return head;
	} 

	public static void helper(ListNode node) {
		if (node == null || node.next == null)
			return;
		ListNode temp = node.next;
		node.next = node.next.next;
		temp.next = node;
		node = temp;
		helper(node.next.next);
	}

}
