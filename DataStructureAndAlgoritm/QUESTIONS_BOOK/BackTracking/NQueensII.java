/*https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/
 *   N-Queens II
  Go to Discuss
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
package BackTracking;

public class NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.totalNQueens(4));
	}

	static public class Solution {
		int count = 0;

		public int totalNQueens(int n) {
			boolean[] cols = new boolean[n];
			boolean[] d1 = new boolean[n * 2];
			boolean[] d2 = new boolean[n * 2];
			backtracking(0, cols, d1, d2, n);
			return count;
		}

		public void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
			if (row == n)//find solution
				count++;
			for (int col = 0; col < n; col++) {
				int id1=col-row+n;
				int id2=col+row;
				if(cols[col]||d1[id1]||d2[id2]) continue; //valid
				cols[col]=true; d1[id1]=true;d2[id2]=true;//place
				backtracking(row+1, cols, d1, d2, n);//next
				cols[col]=false; d1[id1]=false;d2[id2]=false;//remove
			}
		}

	}

}
