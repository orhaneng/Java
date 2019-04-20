/* https://leetcode.com/problems/find-the-duplicate-number/		
 * 287. Find the Duplicate Number
Medium

2287

250

Favorite

Share
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
package BinarySearch;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 0, 0, 0 };
		// int[] nums= {1,1,1,2,2};
		// printRepeating(nums, nums.length);
		System.out.println(alg_ntime_constant_space(nums));

	}

	private static int alg_ntime_constant_space(int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result ^= a[i];
		}
		return (result > 0 ? result : -1);
	}

	static int printRepeating(int input[], int size) {
		int xorArray = 1;// ,dup=0;
		for (int i = 2; i <= (input.length - 1); i++) {
			xorArray = xorArray ^ i;
			// System.out.println(“XOR : ” + xorArray);
		}
		System.out.println("XOR Array : " + xorArray);
		for (int k = 0; k <= input.length - 1; k++) {
			xorArray = xorArray ^ input[k];
			System.out.println(xorArray);
		}
		return xorArray;
	}

	static int fact(int n) {
		return (n == 0) ? 1 : n * fact(n - 1);
	}
	/*
	 * public static int findDuplicate(int[] nums) { int slow = nums[0]; int fast =
	 * nums[0]; do { slow = nums[slow]; fast = nums[nums[fast]]; } while (slow !=
	 * fast);
	 * 
	 * // Find the "entrance" to the cycle. int ptr1 = nums[0]; int ptr2 = slow;
	 * while (ptr1 != ptr2) { ptr1 = nums[ptr1]; ptr2 = nums[ptr2]; }
	 * 
	 * return ptr1; }
	 */
}
