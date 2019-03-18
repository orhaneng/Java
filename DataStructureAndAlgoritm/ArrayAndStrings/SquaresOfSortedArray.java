import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Given an array of integers A sorted in non-decreasing order, return an array of the 
 * squares of each number, also in sorted non-decreasing order.
Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
public class SquaresOfSortedArray {

	public static void main(String[] args) {
		int[] a = {-4,-1,0,3,10};
		//int[] a = { -3, -1, 0 };
		int[] result = (squaresofsorted(a));
		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] squaresofsorted(int[] A) {
		int N = A.length;
		int[] ans = new int[N];
		for(int i=0;i<N;i++) {
			ans[i]=A[i]*A[i];
		}
		
		Arrays.sort(ans);
		return ans;
	}

}
