package Recursion;

/*
 * 8.1 Triple Step: A child is running up a staircase with n steps and can hop either 
 * 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible
 *  ways the child can run up the stairs.
 *  O(3N)
 */
public class TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countsteps(5));

	}

	public static int countsteps(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return (countsteps(n - 1) + countsteps(n - 2) + countsteps(n - 3));
		}
	}
}
