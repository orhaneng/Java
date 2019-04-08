package LinkedList;

import LinkedList.AddTwoNumbers.ListNode;

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		//head.next.next.next.next = new ListNode(5);
		ListNode result = rotateRight(head, 6);
		while(result!=null) {
			System.out.println(result.val);
			result=result.next;
		}
	}
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length 
        	fast=fast.next;
        
        for (int j=i-k%i;j>0;j--) //Get the i- n%i th node
        	slow=slow.next;
        
        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;
        
        return dummy.next;
    }

}
