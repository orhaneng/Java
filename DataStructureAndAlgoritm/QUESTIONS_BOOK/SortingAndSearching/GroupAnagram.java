package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
 * Group anagram: write a method to sort an array of strings so that all the anagrams
 *  are next to each other
 */
public class GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String wordArr[] = { "cat", "dog", "tac", "god", "act" }; 
		/*
		Arrays.sort(wordArr, new AnagramComparator());
	
		*/
		sort(wordArr);
		for (String string : wordArr) {
			System.out.println(string);
		}	
	}
	
	static class AnagramComparator implements Comparator<String>{
		//time O(nlogn)
		private String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	private static String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	//second solution
	static String[] sort(String[] array) {
		HashMap<String, List<String> > hashmap = new HashMap();
		
		for(String s : array) {
			String key = sortChars(s);
			hashmap.put(key, Arrays.asList(s));
		}
		int index= 0;
		for(String key :hashmap.keySet()) {
			List<String> list = hashmap.get(key);
			for(String t:list) {
				array[index]=t;
				index++;
			}
		}
		
		return array;
	}

}
