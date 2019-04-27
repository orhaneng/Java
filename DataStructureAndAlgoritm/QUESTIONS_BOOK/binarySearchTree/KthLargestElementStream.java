/*
 * Kth Largest Element in a Stream
  Go to Discuss
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
Example:
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
 */
package binarySearchTree;

public class KthLargestElementStream {

	public static void main(String[] args) {

		int[] arr = {4,5,8,2};
		KthLargest largest= new KthLargest(3, arr);
		
		System.out.println(largest.add(3));

	}
	

	
	static class KthLargest {
	    TreeNode root;
	    int k;
	    public KthLargest(int k, int[] nums) {
	        this.k = k;
	        for (int num: nums) root = add(root, num);
	    }

	    public int add(int val) {
	        root = add(root, val);
	        return findKthLargest();
	    }

	    private TreeNode add(TreeNode root, int val) {
	        if (root == null) return new TreeNode(val);
	        root.count++;
	        if (val < root.val) root.left = add(root.left, val);
	        else root.right = add(root.right, val);

	        return root;
	    }

	    public int findKthLargest() {
	        int count = k;
	        TreeNode walker = root;

	        while (count > 0) {
	            int pos = 1 + (walker.right != null ? walker.right.count : 0);
	            if (count == pos) break;
	            if (count > pos) {
	                count -= pos;
	                walker = walker.left;
	            } else if (count < pos)
	                walker = walker.right;
	        }
	        return walker.val;
	    }

	    class TreeNode {
	        int val;
	        int count = 1;
	        TreeNode left, right;
	        TreeNode(int v) { val = v; }
	    }
	}

}
