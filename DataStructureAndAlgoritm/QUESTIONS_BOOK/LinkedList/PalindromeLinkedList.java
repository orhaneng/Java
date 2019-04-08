/*https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
 * Palindrome Linked List
  Go to Discuss
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
package LinkedList;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next!=null) return true;
        int size = 0;
        ListNode fast =head;
        ListNode slow=head;
        
        while(fast!=null&&fast.next!=null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        
        if(fast!=null) {
        	slow=slow.next;
        }
        
        while(slow!=null) {
        	if(fast.val!=slow.val)return false;
        	slow = slow.next;
        	fast=fast.next;
        }
        return true;
        
        
    }
    
    public ListNode reverse(ListNode head) {
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

}
