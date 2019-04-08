/*https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
 *  Add Two Numbers
  Go to Discuss
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
package LinkedList;

import LinkedList.PalindromeLinkedList.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l1 = new ListNode(1);
		//l1.next = new ListNode(4);
		//l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		//l2.next.next = new ListNode(4);
		ListNode result = addTwoNumbers(l1, l2);
		while(result!=null) {
			System.out.println(result.val);
			result= result.next;
		}
		
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1==null&l2==null) return null;
    	
    	int l1num=0;
    	int digit=1;
    	while(l1!=null) {
    		l1num= l1num+ l1.val*digit;
    		l1=l1.next;
    		digit*=10;
    	}
    	
    	int l2num=0;
    	digit=1;
    	while(l2!=null) {
    		l2num=l2num+ l2.val*digit;
    		l2=l2.next;
    		digit*=10;
    	}
    	int sum = l2num+l1num;
    	digit=10;
    	ListNode result= new ListNode(sum%10);
		ListNode pointer = result;
		sum = sum/digit;
    	while(sum>=10) {
    		pointer.next=new ListNode(sum%digit);
    		pointer = pointer.next;
    		sum = sum/digit;

    	}
    	if(sum>0)
		pointer.next=new ListNode(sum%digit);
    	return result;
    	
    }
    

}
