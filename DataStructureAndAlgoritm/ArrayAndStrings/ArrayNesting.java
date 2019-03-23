import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*https://leetcode.com/problems/array-nesting/
 * 565. Array Nesting
Medium

506

69

Favorite

Share
A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

 

Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

TIME O(N)
MEMORY O(N)
 */
public class ArrayNesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 4, 0, 3, 1, 6, 2 };
		System.out.println(arrayNesting(nums));
	}

	public static int arrayNesting(int[] nums) {
		int max = 0;
	    Map<Integer, Integer> memo = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			int index = i;
			while (!list.contains(index)) {
				if(memo.containsKey(index)) {
					count=memo.get(index);
					break;
				}
				++count;
				list.add(index);
				index = nums[index];
			}
			memo.put(i, count);
			if (max < count) {
				max = count;
			}
		}
		return max;
	}

}
