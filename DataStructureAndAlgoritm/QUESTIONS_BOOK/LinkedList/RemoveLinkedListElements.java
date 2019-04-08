/*
 * Remove Linked List Elements
  Go to Discuss
Remove all elements from a linked list of integers that have value val.
Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
package LinkedList;

import LinkedList.RemoveNthNodeFromEndofList.ListNode;

public class RemoveLinkedListElements {

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
	
    public ListNode MyremoveElements(ListNode head, int val) {
        if(head==null) return head;
        
        ListNode node = head;
        while(node.next!=null&&node.next!=null){
            if(node.val == val&&node.next==null){
                node = null;
                return head;
            }else if(node.val == val){
                node = node.next;                
            }
            else if(node.next.val==val){
                if(node.next.next==null){
                node.next=null;   
                break;
                }else{
                    node.next=node.next.next;
                }
            }           
            node = node.next;
        }
        
        return head;
    }
    
	public ListNode removeElements(ListNode head, int val) {
		while(head!=null&&head.val==val) {
			head=head.next;
		}
		
		ListNode curr = head;
		while(curr!=null&&curr.next!=null) {
			if(curr.next.val==val) {
				curr.next=curr.next.next;
			}
			else {
				curr = curr.next;
			}
		}
		
		return head;
		
	}
	

}
