/*
 * Given an array A of non-negative integers, return an array consisting of all the 
 * even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.
Example 1:
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 
TIME O(N)
SPACE O(N)

 */
public class SortArrayByParity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,1,2,4};
		int[] result = new int[A.length];
		int begin=0;
		int end=A.length-1;
		for (int i = 0; i < result.length; i++) {
			if(A[i]%2==0) {
				result[begin]=A[i];
				++begin;
			}
			else {
				result[end]=A[i];
				--end;
			}
		}
		for (int i : result) {
			System.out.println(i);
		}
	}

}
