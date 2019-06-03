/*
 * 103. Binary Tree Zigzag Level Order Traversal
Medium

944

59

Favorite

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
package queue_stack_DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			if (root == null)
				return res;
			queue.offer(root);
			queue.offer(new TreeNode(Integer.MAX_VALUE));
			List<Integer> list = new ArrayList<Integer>();
			boolean reverse = false;
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.val == Integer.MAX_VALUE) {
					if (reverse) {
						Collections.reverse(list);
						reverse = false;
					} else {
						reverse = true;
					}
					res.add(list);
					if (!queue.isEmpty())
						queue.offer(new TreeNode(Integer.MAX_VALUE));
					list = new ArrayList<Integer>();
					continue;
				}
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				list.add(node.val);
			}
			return res;
		}

		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int x) {
				val = x;
			}
		}
	}

}
