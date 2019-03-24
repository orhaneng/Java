/*https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/
 *   Implement strStr()
  Go to Discuss
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "aaa", needle = "aaaa";
		System.out.println(strStr(haystack, needle));
	}
	
    public static int strStr(String haystack, String needle) {
    	if(haystack==null||needle==null||("".equals(haystack)&&"".equals(needle))) return 0;
        if(haystack.length()<needle.length())return -1;
    	int nsize=needle.length();
        for(int i=0;i<haystack.length();i++){
            if(needle.equals(haystack.substring(i,i+nsize))){
                return i;
            }
            
            if(haystack.length()-nsize-i-1<0)break;
        }
        return -1;
    }

}
