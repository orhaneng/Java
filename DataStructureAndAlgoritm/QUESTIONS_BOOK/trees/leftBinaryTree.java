package trees;
/*
 * Given a Binary Tree, print left view of it. Left view of a Binary 
 * Tree is set of nodes visible when tree is visited from left side.
 * Input : 
                 1
               /   \
              2     3
             / \     \
            4   5     6             
Output : 1 2 4

Input :
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Output :1 2 4 5 6

 * 
 */

public class leftBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		Node root = null;
		root = new Node(4);
		root.left = new Node(5);
		root.right = new Node(2);
		root.right.right = new Node(1);
		root.right.left = new Node(3);
		root.right.left.left = new Node(6);
		root.right.left.right = new Node(7);
		System.out.println(root.data);
		getleft(root);
		//
		*/
		
        Node root = new Node(12); 
        root.left = new Node(10); 
        root.right = new Node(30); 
        root.right.left = new Node(25); 
        root.right.right = new Node(40); 
        System.out.println(root.data);
		getleft(root);

	}

	public static void getleft(Node node) {
		if(node== null) {
			return;
		}
		if(node.left!= null) {
			System.out.println(node.left.data);
		}
		//bug what if node.left.right is not empty
		if(node.left!=null&& node.left.left==null) {
			getleft(node.right);
		}else {
			getleft(node.left);
		}
		

		return;
	}

	public static class Node {
		int data;
		Node right, left;

		public Node(int data) {
			this.data = data;
		}
	}
}
