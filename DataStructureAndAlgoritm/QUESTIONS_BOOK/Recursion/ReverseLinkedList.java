package Recursion;

import Recursion.SwapNodesinPairs.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node= new ListNode(1);
		node.next= new ListNode(2);
		node.next.next=new ListNode(3);
		node.next.next.next=new ListNode(4);
		//ListNode res =
		trylink(node);
		while(node!=null) {
			System.out.println(node.val);
			node=node.next;
		}
	}
	
	public static void trylink(ListNode root) {
		ListNode node =root;
		while(node!=null) {
			node=node.next;
			if(node!=null && node.val==3) node.val=9;
		}
	}
	public static ListNode reverseList(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}
	
    public static ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        head.next= null;          
        while(p1!=null&&p2!=null ) {
            ListNode t = p2.next;
            p2.next= p1;
            p1 = p2;
            p2= t;
        }
        
        return p1;
    }
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
