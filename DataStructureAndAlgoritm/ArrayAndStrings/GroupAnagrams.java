import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*https://leetcode.com/problems/group-anagrams/
 * 49. Group Anagrams
Medium

1443

99

Favorite

Share
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
Complexity Analysis

Time Complexity: O(NK \log K)O(NKlogK), where NN is the length of strs, 
and KK is the maximum length of a string in strs. The outer loop has 
complexity O(N)O(N) as we iterate through each string. 
Then, we sort each string in O(K \log K)O(KlogK) time.
Space Complexity: O(NK)O(NK), the total information content stored in ans
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		String[] arr= {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(arr);
		System.out.println(result);
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			if (map.containsKey(String.copyValueOf(arr))) {
				List<String> list = map.get(String.copyValueOf(arr));
				list.add(strs[i]);
				map.put(String.copyValueOf(arr), list);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				Arrays.sort(arr);
				map.put(String.copyValueOf(arr), list);
			}
		}

		return new ArrayList<List<String>>(map.values());
	}
}
