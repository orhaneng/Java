/*
 * First Unique Character in a String
  Go to Discuss
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
time o(n)
space o(n)
 */
package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterString {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
    public static int firstUniqChar(String s) {
        if(s==null || s=="") return -1;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        char[] arr =s.toCharArray();
        if(arr.length<1) return -1;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],Integer.MAX_VALUE);
            }else{
                map.put(arr[i],i);
            }
        }
        int min=Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(min>entry.getValue()){
                min = entry.getValue();
            }
        }
        
        return min==Integer.MAX_VALUE?-1:min;
    }
}
