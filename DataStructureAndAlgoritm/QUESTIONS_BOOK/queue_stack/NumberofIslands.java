/*
 * Number of Islands
  Go to Discuss
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by 
connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
package queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0)
			return -1;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					bfsFill(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private static void bfsFill(char[][] grid, int x, int y) {
		int n = grid.length;
		int m = grid[0].length;
		grid[x][y] = '0';
		int code = x * m + y;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(code);
		while (!queue.isEmpty()) {
			code = queue.poll();
			int i = code / m;
			int j = code % m;

			if (i > 0 && grid[i - 1][j] == '1') { // upward
				queue.offer((i - 1) * m + j);
				grid[i - 1][j] = '0';
			}
			if (i < n - 1 && grid[i + 1][j] == '1') { // downward
				queue.offer((i + 1) * m + j);
				grid[i + 1][j] = '0';
			}
			if (j > 0 && grid[i][j - 1] == '1') { // left
				queue.offer(i * m + j - 1);
				grid[i][j - 1] = '0';
			}
			if (j < m - 1 && grid[i][j + 1] == '1') { // right
				queue.offer(i * m + j + 1);
				grid[i][j + 1] = '0';
			}

		}

	}

}
