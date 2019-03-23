/*https://leetcode.com/problems/max-area-of-island/
 * 695. Max Area of Island
Medium

997

58

Favorite

Share
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.


 */
public class MaxAreaofIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid2 = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
	   //it is wrong wit below case
		int[][] grid ={{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(maxAreaOfIsland(grid2));

	}

	public static int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		int[][] gridflag = new int[grid.length][grid[0].length - 1];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int count = findisland(grid, i, j, gridflag);
				if (max < count) {
					max = count;
				}

			}
			

		}
		return max;
	}

	public static int findisland(int[][] grid, int x, int y, int[][] gridflag) {

		if ((x == grid.length - 1) && (y == grid[0].length - 1)) {
			return 0;
		} else if (x == grid.length - 1) {
			return 0;
		} else if (y == grid[0].length - 1) {
			return 0;
		}
		if(gridflag[x][y]==1) {
			return 1;
		}
		if (grid[x][y] == 1) {
			gridflag[x][y] = 1;
			if (x == grid.length - 1) {
				return 1 + findisland(grid, x, y + 1, gridflag);
			} else if (y == grid[0].length - 1) {
				return 1 + findisland(grid, x + 1, y, gridflag);
			} else {
				return 1 + (findisland(grid, x, y + 1, gridflag)) + (findisland(grid, x + 1, y, gridflag));
			}
		} else {
			return 0;
		}
	}

}
