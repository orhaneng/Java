import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * 969. Pancake Sorting
 * https://leetcode.com/problems/pancake-sorting/
Medium

96

104

Favorite

Share
Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.

 

Example 1:

Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted. 
Example 2:

Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
 

Note:

1 <= A.length <= 100
A[i] is a permutation of [1, 2, ..., A.length]
 */
public class PancakeSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 3, 2, 4, 1 };
		List<Integer> result = pancakeSortleetcode(A);
		// for (Integer integer : result) {
		// System.out.println(integer);
		// }

//		int[] result2 = reverse(A, 4);
//		result2 = reverse(result2, 2);
//		result2 = reverse(result2, 4);
//		result2 = reverse(result2, 3);
//
		for (int i : result) {
			System.err.println(i);
		}

	}

	public static List<Integer> pancakeSort(int[] A) {
		int sayac = A.length;
		List<Integer> list = new ArrayList<Integer>();
		int remain = 0;

		while (!isSorted(A)) {

			int max = 0;
			int k = 0;
			for (int i = 0; i < A.length - remain; i++) {
				if (max < A[i]) {
					max = A[i];
					k = i;
				}
			}
			int[] temp = reverse(A, k + 1);
			list.add(k + 1);
			temp = reverse(temp, temp.length - remain);
			list.add(temp.length - remain);
			A = temp;
			++remain;

		}
		return list;
	}

	public static boolean isSorted(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1])
				return false;
		}
		return true;
	}

	public static int[] reverse(int[] A, int k) {
		int begin = 0;
		int end = k - 1;
		while (begin != k / 2) {
			int temp = A[begin];
			A[begin] = A[end];
			A[end] = temp;
			--end;
			begin++;
		}
		return A;
	}

	public static List<Integer> pancakeSortleetcode(int[] A) {
		List<Integer> ans = new ArrayList();
		int N = A.length;

		Integer[] B = new Integer[N];
		for (int i = 0; i < N; ++i)
			B[i] = i + 1;
		Arrays.sort(B, (i, j) -> A[j - 1] - A[i - 1]);

		for (int i : B) {
			for (int f : ans)
				if (i <= f)
					i = f + 1 - i;
			ans.add(i);
			ans.add(N--);
		}

		return ans;
	}

}
