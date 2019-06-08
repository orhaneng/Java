/*
 * Sudoku Solver
  Go to Discuss
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


 */
package BackTracking;

import java.util.Arrays;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		Solution sol = new Solution();
		sol.solveSudoku(grid);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	static public class Solution {
		int count=0;
		public void solveSudoku(char[][] board) {
			dfs(board, 0);
			System.out.println(count);
		}

		private boolean dfs(char[][] board, int d) {
			count++;
			for (int i = 0; i < board.length; i++) {
				if (i % 3 == 0) {
					System.out.println("----------------------");
				}
				for (int j = 0; j < board[0].length; j++) {
					if (j % 3 == 0)
						System.out.print("|");
					System.out.print(board[i][j] + " ");
				}

				System.out.println();
			}
			System.out.println("================================");
			System.out.println("================================");

			if (d == 81)
				return true; // found solution
			int i = d / 9, j = d % 9;
			if (board[i][j] != '.')
				return dfs(board, d + 1);// prefill number skip

			boolean[] flag = new boolean[10];
			validate(board, i, j, flag);
			for (int k = 1; k <= 9; k++) {
				if (flag[k]) {
					board[i][j] = (char) ('0' + k);
					if (dfs(board, d + 1))
						return true;
				}
			}
			board[i][j] = '.'; // if can not solve, in the wrong path, change back to '.' and out
			return false;
		}

		private void validate(char[][] board, int i, int j, boolean[] flag) {
			Arrays.fill(flag, true);
			for (int k = 0; k < 9; k++) {
				if (board[i][k] != '.')
					flag[board[i][k] - '0'] = false;
				if (board[k][j] != '.')
					flag[board[k][j] - '0'] = false;
				int r = i / 3 * 3 + k / 3;
				int c = j / 3 * 3 + k % 3;
				if (board[r][c] != '.')
					flag[board[r][c] - '0'] = false;
			}
		}
	}
}
