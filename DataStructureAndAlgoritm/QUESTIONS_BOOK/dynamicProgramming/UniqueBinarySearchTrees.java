/*
 * 96. Unique Binary Search Trees
Medium

1717

68

Favorite

Share
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
package dynamicProgramming;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol= new Solution();
		System.out.println(sol.numTrees(5));
	}

	static class Solution {
		public int numTrees(int n) {
			int[] dp = new int[n + 1];
			dp[0] = 1;
			dp[1] = 1;
			for (int level = 2; level <= n; level++)
				for (int root = 1; root <= level; root++)
					dp[level] += dp[level - root] * dp[root - 1];
			return dp[n];
		}
	}

}
