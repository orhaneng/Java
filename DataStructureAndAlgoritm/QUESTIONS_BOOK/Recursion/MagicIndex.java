package Recursion;

/*
 * Magic Index: A magic index in an array A[e... n-1] 
 * is defined to be an index such that A[ i] = i. Given a sorted array of distinct
 *  integers, write a method to find a magic index, if one exists, in array A.

('

 */
public class MagicIndex {

	public static void main(String[] args) {
		// int[] array = { -10, -5, 0, 3, 7, 10, 12, 15, 19 }; //result:3
		int[] array = { -10, -5, 0, 1, 2, 5, 9 }; // result:3
		System.out.println(magicindex(array, 0, array.length - 1));
	}

	static int magicindex(int[] a, int low, int high) {
		if (low > high)
			return -1;

		int medium = (low + high) / 2;

		if (a[medium] == medium) {
			return medium;
		}
		if (a[medium] > medium) {
			return magicindex(a, low, medium - 1);
		} else if (a[medium] < medium) {
			return magicindex(a, medium + 1, high);
		} else {
			return medium;
		}
	}

}
