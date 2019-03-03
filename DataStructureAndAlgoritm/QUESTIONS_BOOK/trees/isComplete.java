package trees;

public class isComplete {

	public static void main(String[] args) {
		/*
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		root.right.right.right = new Node(9);
		*/
		
		
        Node root2 = null; 
        root2 = new Node(1); 
        root2.left = new Node(2); 
        root2.right = new Node(3); 
        root2.left.right = new Node(5); 
        root2.left.left = new Node(4); 
        //root2.right.right = new Node(6);
        
		//System.out.println(isComplete(root2));		
		
        int node_count = countNodes(root2); 
        System.out.println(node_count);
        int index = 0; 
           
        if (isComplete(root2, index, node_count)) 
            System.out.print("The binary tree is complete"); 
        else
            System.out.print("The binary tree is not complete");  


	}

	static int  countNodes(Node root)  
    { 
        if (root == null) 
            return (0); 
        return (1 + countNodes(root.left) + countNodes(root.right)); 
    } 
   
    /* This function checks if the binary tree is complete or not */
	static boolean  isComplete(Node root, int index, int number_nodes) 
    { 
        // An empty tree is complete 
        if (root == null)         
           return true; 
   
        // If index assigned to current node is more than 
        // number of nodes in tree, then tree is not complete 
        if (index >= number_nodes) 
           return false; 
        System.out.println(index);
        // Recur for left and right subtrees 
        return (isComplete(root.left, 2 * index + 1, number_nodes) 
            && isComplete(root.right, 2 * index + 2, number_nodes)); 
    } 
 /*
	public static boolean isComplete(Node root) {
		Node node = root;
		if (node == null) {
			return true;
		}
		if (node.right == null && node.left != null)
			return false;
		if (node.right != null && node.left == null && (getLast(root) != node.left)) {
			return false;
		}
		return isComplete(node.left) && isComplete(node.right);
	}

	public static Node getLast(Node node) {
		if (node.left == null)
			return node;
		return getLast(node.right);
	}
*/
	public static class Node {
		int data;
		Node right, left;

		public Node(int data) {
			this.data = data;
		}
	}

}
