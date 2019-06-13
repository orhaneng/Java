/*
 * 79. Word Search
Medium

1769

87

Favorite

Share
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

package BackTracking;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {  { 'C', 'A', 'A' }, 
							{ 'A', 'A', 'A' }, 
							{ 'B', 'C', 'D' } };
		
//		char[][] board = {  { 'a'}}; 

		Solution sol = new Solution();
		System.out.println(sol.exist(board, "AAB"));
	}

	static class Solution {
		public boolean exist(char[][] board, String word) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j]==word.charAt(0)&&helper(board, word, 0, i, j))
						return true;
				}  
			}
			return false;
		}

		public boolean helper(char[][] board, String word, int count, int ri, int ci) {
			if (count + 1 == word.length())
				return true;
			if (word.length() > count && board[ri][ci] == word.charAt(count)) {
				int row = board.length;
				int col = board[0].length;
				char temp = board[ri][ci];
				board[ri][ci] = 'X';
				++count;
				if (ri < row - 1 && board[ri + 1][ci] == word.charAt(count)) {
					 if(helper(board, word, count, ri + 1, ci)) return true;
				}
				if (ri > 0 && board[ri - 1][ci] == word.charAt(count)) {
					 if(helper(board, word, count, ri - 1, ci)) return true;
				}
				if (ci < col - 1 && board[ri][ci + 1] == word.charAt(count)) {
					 if(helper(board, word, count, ri, ci + 1)) return true;
				}
				if (ci > 0 && board[ri][ci - 1] == word.charAt(count)) {
					 if(helper(board, word, count, ri, ci - 1)) return true;
				}
				board[ri][ci] = temp;
			}
			return false;
		}
	}

}
