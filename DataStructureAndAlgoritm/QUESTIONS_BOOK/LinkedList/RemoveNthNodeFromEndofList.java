/*
 *  Remove Nth Node From End of List
  Go to Discuss
Given a linked list, remove the n-th node from the end of list and return its head.
Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Follow up:
Could you do this in one pass?
 */
package LinkedList;

public class RemoveNthNodeFromEndofList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode result = removeNthFromEnd2(head, 10);
		while(result.next!=null) {
			result = result.next;
			System.out.println(result.val);
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		ListNode slow = head;
		
		int count = 0;
		ListNode result;
		while (fast.next != null) {
			fast = fast.next;
			if (count == n-1) {
				break;
			}
			count++;

		}
		if (count != n-1 )
			return null;

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;

			if (fast.next == null) {
				slow.next = slow.next.next;
				return head;
			}
		}
		return null;
	}

	public static ListNode removeNthFromEnd2(ListNode head, int n) {
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
		
}
