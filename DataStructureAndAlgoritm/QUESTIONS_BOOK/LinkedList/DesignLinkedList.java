/*https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
 *   Design Linked List
  Go to Discuss
Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
Example:

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
Note:

All values will be in the range of [1, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in LinkedList library.
 */
package LinkedList;

public class DesignLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtHead(1);
		linkedList.print(linkedList.root);
		linkedList.addAtTail(3);
		linkedList.print(linkedList.root);
		linkedList.addAtIndex(1, 2);
		linkedList.print(linkedList.root);
		System.out.println("result="+linkedList.get(1));
		linkedList.print(linkedList.root);
		linkedList.deleteAtIndex(1);
		linkedList.print(linkedList.root);
		System.out.println("result"+linkedList.get(2)); 
		System.out.println("result"+linkedList.get(1));


	}
	
	static class MyLinkedList {
	    
	    /** Initialize your data structure here. */
	    Node root=null;
	    int size;
	    public MyLinkedList() {
	    }
	    
	    public class Node{
	        Node next;
	        int val;
	        public Node(int val){
	            this.val = val;
	            this.next = null;
	        }
	    }
	    
	    public void print(Node node) {
	    	System.out.println("===");
	    	while(node!=null) {
	    		System.out.println(node.val);
	    		node=node.next;
	    	}
	    }
	    
	    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	    public int get(int index) {
	    	if(index>=size) return -1;
	        Node current =root;
	        for (int i = 0; i < index; i++) {
				current= current.next;
			}
	        return current.val;
	    }
	    
	    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	    public void addAtHead(int val) {
	    		Node prev = root;
	            root =new Node(val);
	            root.next = prev;
	            size++;
	    }
	    
	    /** Append a node of value val to the last element of the linked list. */
	    public void addAtTail(int val) {
	    	size++;
	        if(root==null){
	            root= new Node(val);
	        }else{
	            Node node = root;
	            while(node.next!=null) {
	            	node = node.next;
	            }
	            node.next = new Node(val);
	        }
	    }
	    
	    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	    public void addAtIndex(int index, int val) {
	    	if(index>size) return;
	    	if(index==0) addAtHead(val);
	    	else {
	    		size++;
	    		Node current = root;
	    		for (int i = 0; i < index-1; i++) {
					current= current.next;
				}
	    		Node node = new Node(val);
	    		node.next = current.next;
	    		current.next=node;
	    	}
	    }
	    
	    /** Delete the index-th node in the linked list, if the index is valid. */
	    public void deleteAtIndex(int index) {
	        if(index>=size) return;
	        size--;
	        Node current = root;
	        for (int i = 0; i < index-1; i++) {
				current = current.next;
			}
	        current.next= current.next.next;
	    }
	}


}
