/*
 * 451. Sort Characters By Frequency
Medium

692

61

Favorite

Share
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */
package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.frequencySort("tree"));

	}

	static class Solution {
		public String frequencySort(String s) {
			Map<Character, Integer> map = new HashMap();
			StringBuilder build = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			}

			PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<Map.Entry<Character, Integer>>(
					(p1, p2) -> p2.getValue() - p1.getValue());
			queue.addAll(map.entrySet());

			while (!queue.isEmpty()) {
				Map.Entry e = queue.poll();
				for (int i = 0; i < (int) e.getValue(); i++) {
					build.append(e.getKey());
				}
			}

			return build.toString();
		}
	}

}
