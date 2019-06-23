package dynamicProgramming;

public class MaximalSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int M[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		Solution sol = new Solution();
		// System.out.println(
		sol.printMaxSubSquare(M);

	}

	static class Solution {
		public int maximalSquare(int[][] matrix) {
			int n = matrix.length;
			int m = matrix[0].length;

			int[][] temp = new int[n][m];

			/* Set first column of S[][] */
			for (int i = 0; i < n; i++)
				temp[i][0] = matrix[i][0];

			/* Set first row of S[][] */
			for (int j = 0; j < m; j++)
				temp[0][j] = matrix[0][j];

			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					if (matrix[i][j] == 1)
						temp[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j - 1])) + 1;
					else
						temp[i][j] = 0;
				}
			}
			int max_of_s, max_i, max_j;

			max_of_s = temp[0][0];
			max_i = 0;
			max_j = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (max_of_s < temp[i][j]) {
						max_of_s = temp[i][j];
						max_i = i;
						max_j = j;
					}
				}
			}
			System.out.println("Maximum size sub-matrix is: ");
			for (int i = max_i; i > max_i - max_of_s; i--) {
				for (int j = max_j; j > max_j - max_of_s; j--) {
					System.out.print(matrix[i][j] + " ");
				}
				System.out.println();
			}
			return 0;
		}

		static void printMaxSubSquare(int M[][]) {
			int i, j;
			int R = M.length; // no of rows in M[][]
			int C = M[0].length; // no of columns in M[][]
			int S[][] = new int[R][C];

			int max_of_s, max_i, max_j;

			/* Set first column of S[][] */
			for (i = 0; i < R; i++)
				S[i][0] = M[i][0];

			/* Set first row of S[][] */
			for (j = 0; j < C; j++)
				S[0][j] = M[0][j];

			/* Construct other entries of S[][] */
			for (i = 1; i < R; i++) {
				for (j = 1; j < C; j++) {
					if (M[i][j] == 1)
						S[i][j] = Math.min(S[i][j - 1], Math.min(S[i - 1][j], S[i - 1][j - 1])) + 1;
					else
						S[i][j] = 0;
				}
			}

			/*
			 * Find the maximum entry, and indexes of maximum entry in S[][]
			 */
			max_of_s = S[0][0];
			max_i = 0;
			max_j = 0;
			for (i = 0; i < R; i++) {
				for (j = 0; j < C; j++) {
					if (max_of_s < S[i][j]) {
						max_of_s = S[i][j];
						max_i = i;
						max_j = j;
					}
				}
			}
			System.out.println("Maximum size sub-matrix is: ");
			for (i = max_i; i > max_i - max_of_s; i--) {
				for (j = max_j; j > max_j - max_of_s; j--) {
					System.out.print(M[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
