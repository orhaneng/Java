/*
 * 78. Subsets
Medium

1851

49

Favorite

Share
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = { 1, 2, 3 };
		System.out.println(sol.subsets(nums));
	}

	static class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			helper(list, new ArrayList<Integer>(), nums, 0);
			return list;
		}

		public void helper(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
			list.add(new ArrayList<>(temp));
			for (int i = start; i < nums.length; i++) {
				temp.add(nums[i]);
				helper(list, temp, nums, i + 1);
				temp.remove(temp.size() - 1);

			}
		}

	}
}
