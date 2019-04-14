/*https://leetcode.com/problems/leaf-similar-trees/
 * 872. Leaf-Similar Trees
Easy
349
19
Favorite
Share
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
package queue_stack_DFS_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(4);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(8);
		System.out.println(leafSimilarDFSStack(root, root));
	}
	
	
	public static boolean leafSimilarDFSStack(TreeNode root1, TreeNode root2) {
	       Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
	        s1.push(root1); s2.push(root2);
	        while (!s1.empty() && !s2.empty())
	            if (dfs(s1) != dfs(s2)) return false;
	        return s1.empty() && s2.empty();
	}
	
    public static int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            if (node.left == null && node.right == null) return node.val;
        }
    }

	
	

	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		getleaves(root1, list1);
		for (Integer integer : list1) {
			System.out.println(integer);
		}
		getleaves(root2, list2);
		return list1.equals(list2);
	}

	
	
	private static void getleaves(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		if (root.right == null & root.left == null) {
			list.add(root.val);
		}
		getleaves(root.left, list);
		getleaves(root.right, list);
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
