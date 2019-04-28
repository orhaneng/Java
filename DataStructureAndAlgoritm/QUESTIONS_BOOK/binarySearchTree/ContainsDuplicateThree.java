/*https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1013
 *   Contains Duplicate III
  Go to Discuss
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

 */
package binarySearchTree;

import java.util.TreeSet;

public class ContainsDuplicateThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1};
		System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
		
	}

	public static  boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	        if (nums == null || nums.length == 0 || k <= 0) {
	            return false;
	        }

	        final TreeSet<Integer> values = new TreeSet<>();
	        for (int ind = 0; ind < nums.length; ind++) {

	            final Integer floor = values.floor(nums[ind] + t);
	            final Integer ceil = values.ceiling(nums[ind] - t);
	            if ((floor != null && floor >= nums[ind])
	                    || (ceil != null && ceil <= nums[ind])) {
	                return true;
	            }

	            values.add(nums[ind]);
	            if (ind >= k) {
	                values.remove(nums[ind - k]);
	            }
	        }

	        return false;
	}
}
