import java.util.ArrayList;

/*
 * X419-01: Take-Home Assignment 1
Assume you are given a function bool hit(int x, int y) that returns true 
if there was a hit to a ship and false if not. You are to write a function 
that returns the coordinates of a single ship on a grid of given size, the 
function takes at least one argument int gridSize and must return the 
coordinates of the 3 unit ship present in the board in the shortest 
time possible. Estimate the Time and memory complexity of your proposed 
solution. You are to select the data structure to return what you need as 
output and the prototype of the function.
 * 
 * 
 */
public class Homework2 {

	public static void main(String[] args) {
		ArrayList<String> result = getCoordinates(5);

		for (String string : result) {
			System.out.println(string);
		}
	}

	public static ArrayList<String> getCoordinates(int gridSize) {

		ArrayList<String> coordinates = new ArrayList<String>();
		int[][] grid = new int[gridSize][gridSize];
		grid[3][1] = 1;
		grid[3][2] = 1;
		grid[3][3] = 1;

		for (int i = 0; i < gridSize - 1; i++) {
			for (int j = 0; j < gridSize - 1; j++) {
				if (grid[i][j] == 1) {
					coordinates.add(i + "x" + j);
					if (i + 1 < gridSize && grid[i + 1][j] == 1) {
						coordinates.add((i + 1) + "x" + j);
						coordinates.add((i + 2) + "x" + j);
						break;
					} else if (j + 1 < gridSize && grid[i][j + 1] == 1)
						coordinates.add((i) + "x" + (j + 1));
					coordinates.add((i) + "x" + (j + 2));
					break;
				}
			}
		}
		return coordinates;

	}

}
