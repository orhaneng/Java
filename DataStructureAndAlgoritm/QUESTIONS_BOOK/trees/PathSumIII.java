package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathSumIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(10);
		root.left=new TreeNode(5);
		root.right=new TreeNode(-3);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(2);
		root.right.left=new TreeNode(11);
		root.left.left.left=new TreeNode(3);
		root.left.left.right=new TreeNode(-2);
		root.left.right.right=new TreeNode(1);
		
		Solution2 sol=new Solution2();
		System.out.println(sol.pathSum(root, 8));
		}

	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	static class Solution2{
		 public int pathSum(TreeNode root, int sum) {
		        HashMap<Integer, Integer> preSum = new HashMap();
		        preSum.put(0,1);
		        return helper(root, 0, sum, preSum);
		    }
		    
		    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
		        if (root == null) {
		            return 0;
		        }
		        
		        currSum += root.val;
		        int res = preSum.getOrDefault(currSum - target, 0);
		        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
		        
		        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
		        preSum.put(currSum, preSum.get(currSum) - 1);
		        return res;
		    }
	}

	static class Solution {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		public int pathSum(TreeNode root, int sum) {
			helper(root, sum, 0, new LinkedList<Integer>());
			return res.size();
		}

		public void helper(TreeNode root, int sum, int isum, Queue<Integer> queue) {
			if (root == null)
				return;
			if(root.val<sum)
			if (isum  + root.val== sum) {
				queue.add(root.val);
				isum += root.val;
				List<Integer> list = new ArrayList<Integer>();
				int count = queue.size();
				while (count > 0) {
					int val = queue.poll();
					list.add(val);
					queue.add(val);
					count--;
				}
				res.add(list);
			} else if (isum  + root.val > sum) {
				int val = queue.poll();
				isum -= val;
				queue.add(root.val);
				isum += root.val;
			} else {
				isum += root.val;
				queue.add(root.val);
			}
			helper(root.left, sum, isum, queue);
			helper(root.right, sum, isum, queue);
		}
	}

}
