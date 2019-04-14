/*
 * 542. 01 Matrix
Medium

608

76

Favorite

Share
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 
 */
package queue_stack_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class sifirbirMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0 }, { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 } };
		// { { 0, 0, 0 },
		// { 0, 1, 0 },
		// { 1, 1, 1 } };
		updateMatrix(matrix);

	}

	public static int[][] updateMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					setDistance(matrix, i, j);
				}
			}
		}
		return matrix;
	}

	private static void setDistance(int[][] matrix, int row, int col) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { row, col });
		int[][] list = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int level = 0;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] location = queue.poll();
				for (int j = 0; j < list.length; j++) {
					int[] newLoc = { location[0] + list[j][0], location[1] + list[j][1] };
					if (newLoc[0] >= 0 && newLoc[0] < matrix.length && newLoc[1] >= 0 && newLoc[1] < matrix[0].length
							&& matrix[newLoc[0]][newLoc[1]] == 0) {
						matrix[row][col] = level;
						return;
					} else if (newLoc[0] >= 0 && newLoc[0] < matrix.length && newLoc[1] >= 0
							&& newLoc[1] < matrix[0].length && matrix[newLoc[0]][newLoc[1]] == 1) {
						queue.offer(newLoc);
					}
				}
			}
		}
	}

}
