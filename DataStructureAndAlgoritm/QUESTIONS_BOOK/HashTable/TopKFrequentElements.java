/*
 * 347. Top K Frequent Elements
Medium

1483

94

Favorite

Share
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = { 4, 1, -1, 2, -1, 2, 3 };
		System.out.println(sol.topKFrequent(nums, 2));
	}

	static class Solution {
		public List<Integer> topKFrequent(int[] nums, int k) {
			List<Integer> list = new ArrayList<Integer>();

			Map<Integer, Integer> hashmap = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				hashmap.put(nums[i], hashmap.getOrDefault(nums[i], 0) + 1);
			}
			TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
			for (int num : hashmap.keySet()) {
				int freq = hashmap.get(num);
				if(!map.containsKey(freq)) {
					map.put(freq, new ArrayList<Integer>());
				}
				map.get(freq).add(num);
			}

			while(list.size()<k) {
				Map.Entry<Integer, List<Integer>> entry= map.pollLastEntry();
				list.addAll(entry.getValue());
			}
			return list;
		}
	}

}
