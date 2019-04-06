/*https://leetcode.com/problems/find-duplicate-subtrees/
 * 652. Find Duplicate Subtrees
Medium

708

143

Favorite

Share
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.isComplete.Node;

public class FindDuplicateSubtrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root2 = null; 
        root2 = new TreeNode(1); 
        root2.left = new TreeNode(2); 
        root2.right = new TreeNode(3); 
        root2.left.left = new TreeNode(4); 
        root2.right.left = new TreeNode(2); 
        root2.right.right = new TreeNode(4); 
        root2.right.left.left = new TreeNode(4); 
        
        List<TreeNode> result = findDuplicateSubtrees(root2);
        for (TreeNode treeNode : result) {
			System.out.println(treeNode.val);
		}
	}
    static Map<String, Integer> count;
    static List<TreeNode> ans;
    
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    public  static String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial;
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
