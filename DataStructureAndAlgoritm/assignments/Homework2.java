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

	//Time complexity is O(N2)(O square)
	//Memory complexity O(1)
	public static ArrayList<String> getCoordinates(int gridSize) {
		/*
		 * You are to write a function that returns the coordinates of a single ship on a grid of given size, 
		 * the function takes at least one argument int gridSize and must return the coordinates of the 3 unit 
		 * ship present in the board in the shortest time possible. 
		 */
		ArrayList<String> coordinates = new ArrayList<String>();//getting coordinates
		for (int i = 0; i < gridSize ; i++) { //looking each row
			for (int j = 0; j < gridSize; j++) { //looking each column
				if (checkHitShipAssumed(i, j, gridSize)) { //checking hit
					coordinates.add(i + "x" + j); //if find the ship, it adds the coordinate
					if (i + 1 < gridSize && checkHitShipAssumed(i + 1, j, gridSize)) {//looking around the point to 
						//another coordinate
						coordinates.add((i + 1) + "x" + j);//second coordinate
						coordinates.add((i + 2) + "x" + j);//third coordinate
						
						break;
					} else if (j + 1 < gridSize && checkHitShipAssumed(i, j + 1, gridSize))//it is the same as above
						coordinates.add((i) + "x" + (j + 1));
					coordinates.add((i) + "x" + (j + 2));
					break;
				}
			}
		}
		return coordinates;

	}

	public static boolean checkHitShipAssumed(int x, int y, int gridSize) {
		/*
		 *Assume you are given a function bool hit(int x, int y) that returns true 
		 *if there was a hit to a ship and false if not.
		 */
		int[][] grid = new int[gridSize][gridSize];
		grid[4][2] = 1;
		grid[4][3] = 1;
		grid[4][4] = 1;

		if (grid[x][y] == 1) {
			return true;
		}
		return false;

	}

}
