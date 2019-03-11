package Recursion;

import java.util.ArrayList;

public class robotGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		String[][] grid = new String[n][n];
		grid[5][2] = "X";
		grid[3][0] = "X";
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> result = findPath(grid, 0, 0, path);
		System.out.println(result);
	}

	public static ArrayList<String> findPath(String[][] grid, Integer i, Integer j, ArrayList<String> path) {
		int n = grid[0].length - 1;
		if (i == n && j == n) {
			return path;
		}

		if (j < n && grid[i][j + 1] == "X") {
			i++;
			if (i >= n) {
				path.add("crushed");
				return path;
			}
			path.add(i + "-" + j);
			return findPath(grid, i, j, path);
		} else if (i < n && grid[i + 1][j] == "X") {
			j++;
			if (j >= n) {
				path.add("crushed");
				return path;
			}
			path.add(i + "-" + j);
			return findPath(grid, i, j, path);
		} else if (i == n) {
			j++;
			path.add(i + "-" + j);
			return findPath(grid, i, j, path);
		} else if (j == n) {
			i++;
			path.add(i + "-" + j);
			return findPath(grid, i, j, path);
		} else if (i < n) {
			i++;
			path.add(i + "-" + j);
			return findPath(grid, i, j, path);
		} else if (j < n) {
			j++;
			path.add(i + "-" + j);
			return findPath(grid, i, j, path);
		}

		return path;
	}

}
