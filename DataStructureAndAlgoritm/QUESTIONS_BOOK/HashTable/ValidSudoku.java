/*https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
package HashTable;

import java.util.HashSet;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
				            { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				            { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
				            { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				            { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
				            { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				            { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
				            { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				            { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }; 
		System.out.println(isValidSudoku(board));

	}
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            HashSet<Character> rows=new HashSet<Character>();
            HashSet<Character> columns=new HashSet<Character>();
            HashSet<Character> cube=new HashSet<Character>();
            for(int j =0;j<board[0].length;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j])){
                    return false;
                }
                else if(board[j][i]!='.' && !columns.add(board[j][i])){
                    return false;
                } 
                int rowindex =3*(i/3);
                int colindex = 3*(i%3);
                System.out.println((rowindex+j/3)+'-'+(colindex+j%3));
                if(board[rowindex+j/3][colindex+j%3]!='.'&&!cube.add(board[rowindex+j/3][colindex+j%3]))
                    return false;
            }


        }
        return true;
    }

}
