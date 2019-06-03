import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 17. Letter Combinations of a Phone Number
Medium

2171

293

Favorite

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.letterCombinations2("234"));
	}

	static class Solution {
		public List<String> letterCombinations2(String digits) {
			LinkedList<String> ans = new LinkedList<String>();
			if (digits.isEmpty())
				return ans;
			String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
			ans.add("");
			for (int i = 0; i < digits.length(); i++) {
				int x = Character.getNumericValue(digits.charAt(i));
				while (ans.peek().length() == i) {
					String t = ans.remove();
					for (char s : mapping[x].toCharArray())
						ans.add(t + s);
				}
			}
			return ans;
		}

		public List<String> letterCombinations(String digits) {
			List<String> result = new ArrayList<String>();
			if (digits.isEmpty())
				return result;
			Map<Integer, List<Character>> map = new HashMap();
			map.put(1, new ArrayList<Character>());
			int first = Integer.parseInt(String.valueOf(digits.charAt(0)));
			List<Character> list = new ArrayList<Character>();
			int i = 2;
			int count = (i == 7 || i == 9 ? 4 : 3);
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (count == 0) {
					i++;
					list = new ArrayList<Character>();
					count = (i == 7 || i == 9 ? 4 : 3);
				}
				count--;
				list.add(ch);
				map.put(i, list);
			}
			if (digits.toCharArray().length == 1) {
				for (Character character : map.get(first)) {
					result.add(String.valueOf(character));
				}
			} else {
				int second = Integer.parseInt(String.valueOf(digits.charAt(1)));
				for (int j = 0; j < map.get(first).size(); j++) {
					for (int k = 0; k < map.get(second).size(); k++) {
						result.add(String.valueOf(map.get(first).get(j)) + String.valueOf(map.get(second).get(k)));
					}
				}
			}
			return result;
		}
	}

}
