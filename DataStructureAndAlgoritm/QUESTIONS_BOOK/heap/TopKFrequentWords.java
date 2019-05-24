/*https://leetcode.com/problems/top-k-frequent-words/
 * 692. Top K Frequent Words
Medium

718

67

Favorite

Share
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
 */
package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		System.out.println(sol.topKFrequent(words, 4));
	}

	static class Solution {
		public List<String> topKFrequent(String[] words, int k) {
			Map<String, Integer> map = new HashMap<>();
			for (String n : words) {
				map.put(n, map.getOrDefault(n, 0) + 1);
			}

			PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
					(a, b) -> (b.getValue().equals(a.getValue()) ? b.getKey().compareTo(a.getKey())
							: b.getValue() - a.getValue()));
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				maxHeap.add(entry);
			}

			List<String> res = new ArrayList<>();
			while (res.size() < k) {
				Map.Entry<String, Integer> entry = maxHeap.poll();
				res.add(entry.getKey());
			}
			//Collections.reverse(res);
			return res;
		}
	}

}
