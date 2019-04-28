/*https://leetcode.com/problems/map-sum-pairs/
 * 677. Map Sum Pairs
Medium

283

56
Favorite
Share
Implement a MapSum class with insert, and sum methods.
For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 */
package trees;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapSum obj = new MapSum();
		obj.insert("apple", 3);
		System.out.println(obj.sum("ap"));
		obj.insert("app", 2);
		obj.insert("app", 2);
		System.out.println(obj.sum("ap"));

	}

	public static class MapSum {
		HashMap<String, Integer> map;
		TrieNode root;

		public MapSum() {
			map = new HashMap<String, Integer>();
			root = new TrieNode();
		}

		public void insert(String key, int val) {
			int delta = val - map.getOrDefault(key, 0);
			map.put(key, val);
			TrieNode cur = root;
			cur.score += delta;
			for (char c : key.toCharArray()) {
				cur.children.putIfAbsent(c, new TrieNode());
				cur = cur.children.get(c);
				cur.score += delta;
			}

		}
		public int sum(String prefix) {
			TrieNode cur = root;
			for (char c : prefix.toCharArray()) {
				cur=cur.children.get(c);
				if(cur==null) return 0;
			}
			return cur.score;
		}

		class TrieNode {
			Map<Character, TrieNode> children = new HashMap();
			int score;	
		}
	}

}
