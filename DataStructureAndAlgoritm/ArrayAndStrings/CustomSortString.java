/*
 * 791. Custom Sort String
Medium

320

106

Favorite

Share
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 */
public class CustomSortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(customSortString2("exv", "xwvee"));
	}
    public static String customSortString(String S, String T) {
//        for(char c : S.toCharArray()){
//             if(T.indexOf(c) ==-1)
//                 return null;
//        }
        
        char[] arr = T.toCharArray();
        for(int i=0;i<S.toCharArray().length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]==S.toCharArray()[i]){
                   arr[j]=' '; 
                   break;
                }
            }
        }
        int k=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==' '){
                arr[i]=S.toCharArray()[k];
                k=k+1;
            }
        }
        return String.copyValueOf(arr);
    }
    public static String customSortString2(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) { ++count[c - 'a']; }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {                            
            while (count[c - 'a']-- > 0) { sb.append(c); }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }   // group chars in T but not in S.
        }
        return sb.toString();
   }	
    
    
}
