/*
 * 931. Minimum Falling Path Sum
Medium

240

29

Favorite

Share
Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.
 */
public class MinimumFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(minFallingPathSum(arr));
	}

	public static int minFallingPathSum(int[][] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		// int[][] dp = new int[A.length][A[0].length];
		int curmin = Integer.MAX_VALUE;
		for (int i = A.length - 2; i >= 0; i--) {
			for (int j = 0; j < A[0].length; j++) {
				if (j == 0) {
					A[i][j] += Math.min(A[i + 1][j], A[i + 1][j + 1]);
				} else if (j == A[0].length - 1) {
					A[i][j] += Math.min(A[i + 1][j], A[i + 1][j - 1]);
				} else {
					int min = Math.min(A[i + 1][j], A[i + 1][j + 1]);
					A[i][j] += Math.min(min, A[i + 1][j - 1]);
				}
			}
		}

		for (int i = 0; i < A[0].length; i++) {
			curmin = Math.min(curmin, A[0][i]);
		}

		return curmin;

	}

}
