/*
 * 152. Maximum Product Subarray
Medium

2125

97

Favorite

Share
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
package dynamicProgramming;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol= new Solution();
		int[] arr= {2,3,-2,4};
		System.out.println(sol.maxProduct(arr));
	}
	static class Solution {
		   public int maxProduct(int[] A) {
		        if (A == null || A.length == 0) {
		            return 0;
		        }
		        int max = A[0], min = A[0], result = A[0];
		        for (int i = 1; i < A.length; i++) {
		            int temp = max;
		            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
		            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
		            if (max > result) {
		                result = max;
		            }
		        }
		        return result;
		    }
	}
}
