/*https://leetcode.com/problems/palindromic-substrings/
 * 647. Palindromic Substrings
Medium
1234
64
Favorite
Share
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 */
public class PalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSubstrings("aaa"));

	}
    public static int countSubstrings(String s) {
        int length=1;
        int count =0;
        while(length<s.length()+1){
            for(int i=0;i<s.length();i++){
                if(i+length>s.length()) break;
                if(palindromic(s.substring(i,i+length))){
                    ++count;
                }
            }
            ++length;
        }
        return count;
    }
    
    
    public static boolean palindromic(String text){
        if(text==null) return true;
        int length=text.length();
        if(length==1) return true;
        else{
            int begin=0;
            int end=text.length()-1;
            while(begin<end){
                if(text.charAt(begin)==text.charAt(end)){
                    ++begin;
                    --end;
                }
                   else return false;
            }
        }
        return true;
    }

}
