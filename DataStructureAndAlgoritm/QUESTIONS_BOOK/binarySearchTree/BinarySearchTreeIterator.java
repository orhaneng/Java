/*
 *   Binary Search Tree Iterator
  Go to Discuss
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Example:
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
Note:
next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */
package binarySearchTree;

import java.util.Stack;

public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		BinarySearchTreeIterator iterator = new BinarySearchTreeIterator(root);
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());



	}

	static private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BinarySearchTreeIterator(TreeNode root) {
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public static boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public static int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private static void pushAll(TreeNode node) {
		for (; node != null; stack.push(node), node = node.left)
			;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	

}

class BSTIterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        push(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        push(temp.right);
        return temp.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public void push(TreeNode root){
        while(root!=null){
            stack.push(root.left);
            root = root.left;
        }
    }
}
