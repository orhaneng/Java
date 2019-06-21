/*
 * 64. Minimum Path Sum
Medium

1393

40

Favorite

Share
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */
package dynamicProgramming;

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		Solution sol=new Solution();
		System.out.println(sol.minPathSum(input));
	}

	static class Solution {
		public int minPathSum(int[][] grid) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if(i==0&&j==0) continue; 
					grid[i][j] = Math.min((i - 1 < 0 ? Integer.MAX_VALUE : grid[i - 1][j]),
							(j - 1 < 0 ? Integer.MAX_VALUE : grid[i][j - 1]))+grid[i][j];
				}
			}

			return grid[grid.length - 1][grid[0].length-1];
		}
	}

}
