package binarySearchTree;

import binarySearchTree.PopulatingNextRightPointersEachNode.Node;

public class PopulatingNextRightPointersEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root= new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		//root.right.left= new Node(6);
		root.right.right= new Node(7);	
		connect(root);
	}
	
	static class Node {
		  int val;
		  Node left;
		  Node right;
		  Node next;
		  public Node(int val) {
			  this.val=val;
		  }
		}
	
    public static Node connect(Node root) {

        Node head=null;
        Node prev=null;
        Node curr=root;
        while(curr!=null){
            while(curr!=null){
                if(curr.left!=null){
                    if(prev!=null){
                        prev.next= curr.left;
                    }else{
                        head=curr.left;
                    }
                    prev= curr.left;
                }
                if(curr.right!=null){
                    if(prev!=null){
                        prev.next=curr.right;
                    }
                    else{
                        head=curr.right;
                    }
                    prev=curr.right;
                }
                curr=curr.next;
            }
            curr=head;
            head=null;
            prev=null;
        }
        return root;
    }

}
