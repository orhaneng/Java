import java.util.ArrayList;
import java.util.List;

/*https://leetcode.com/problems/find-and-replace-pattern/
 * 890. Find and Replace Pattern
Medium

298

27

Favorite

Share
You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
 */
public class FindandReplacePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		//String pattern = "abb";

		String[] words = { "a", "b", "c" };
		String pattern = "a";
		List<String> result = findAndReplacePattern(words, pattern);
		for (String string : result) {
			System.out.println(string);
		}
	}

	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if(pattern.length()==1) {
				for (String string : words) {
					list.add(string);
				}
				break;
			}
			if(pattern.length()>1)
			for (int j = 1; j < words[i].length(); j++) {
				if (words[i].length() == 1 && pattern.length() == 1) {
					list.add(words[i]);
					continue;
				}
				if ((words[i].charAt(j - 1) == words[i].charAt(j) && pattern.charAt(j - 1) == pattern.charAt(j))
						|| (words[i].charAt(j - 1) != words[i].charAt(j)
								&& pattern.charAt(j - 1) != pattern.charAt(j))) {
					if (j == words[i].length() - 1) {
						list.add(words[i]);
						break;
					}
				} else
					break;
			}
		}
		return list;
	}
	
	

}
