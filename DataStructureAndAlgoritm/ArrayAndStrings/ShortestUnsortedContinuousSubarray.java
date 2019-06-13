import java.util.Arrays;

/*
 * 581. Shortest Unsorted Continuous Subarray
Easy

1433

70

Favorite

Share
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		System.out.println(sol.findUnsortedSubarray(nums));
	}

	static class Solution {
		public int findUnsortedSubarray(int[] nums) {
			if (nums.length < 2) {
				return 0;
			}

			int[] temp = nums.clone();
			Arrays.sort(temp);
			int start = 0, end = nums.length;
			for (int i = 0; i < nums.length; i++) {
				if (temp[i] != nums[i]) {
					start = i;
					break;
				}
			}
			for (int i = nums.length - 1; i >= 0; i--) {
				if (temp[i] != nums[i]) {
					end = i;
					break;
				}
			}
			return end - start + 1;
		}
	}

}
