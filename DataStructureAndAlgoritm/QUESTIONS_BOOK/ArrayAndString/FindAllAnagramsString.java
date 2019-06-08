package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.findAnagrams("abab", "ab"));
	}

	static class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> list = new ArrayList<Integer>();
			if (s == null)
				return list;
			char[] psorted = p.toCharArray();
			Arrays.sort(psorted);
			for (int i = 0; i < s.length() - p.length() + 1; i++) {
				char[] sub = s.substring(i, p.length() + i).toCharArray();
				Arrays.sort(sub);
				if (Arrays.equals(sub, psorted)) {
					list.add(i);
				}
			}
			return list;
		}
	}

}
