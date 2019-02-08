/*
 * 
 * Partitioning a linked list around a given value and keeping the original order
Given a linked list and a value x, partition it such that all nodes less than x come first,
 then all nodes with value equal to x and finally nodes with value greater than or equal
  to x. The original relative order of the nodes in each of the three partitions should 
  be preserved. The partition must work in-place.

Examples:

Input : 1->4->3->2->5->2->3, 
        x = 3
Output: 1->2->2->3->3->4->5

Input : 1->4->2->10 
        x = 3
Output: 1->2->4->10

Input : 10->4->20->10->3 
        x = 3
Output: 3->10->4->20->10 


 */
package LinkedList;

public class partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3);  
	    head.next = new Node(5);  
	    head.next.next = new Node(8);  
	    head.next.next.next = new Node(5);  
	    head.next.next.next.next = new Node(10);  
	    head.next.next.next.next.next = new Node(2);	    
	    head.next.next.next.next.next.next = new Node(1);
	    
	    Node result = partition(head,5);
	    printList(result);
	}
	
	static void printList(Node head)  
	{  
	    Node temp = head;  
	    while (temp != null)  
	    {  
	        System.out.print(temp.data + " ");  
	        temp = temp.next;  
	    }  
	}  
	
	static Node partition(Node node, int x) {
		Node head= node;
		Node tail = node;
		
		
		while(node!= null) {
			Node next = node.next;
			if(node.data < x) {
				node.next = head;
				head = node;
			}
			else {
				tail.next = node ;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}

}

class Node {
	Node next = null;
	int data;
	
	public Node(int d ) {
		data =d;
	}
}

