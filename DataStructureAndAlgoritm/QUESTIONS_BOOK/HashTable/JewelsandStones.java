/*
 * 771. Jewels and Stones
Easy

1303

244

Favorite

Share
You're given strings J representing the types of stones that are jewels, and S 
representing the stones you have.  Each character in S is a type of stone you have. 
 You want to know how many of the stones you have are also jewels.
The letters in J are guaranteed distinct, and all characters in J and S are letters.
Letters are case sensitive, so "a" is considered a different type of stone from "A".
Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
TIME COMLEXITY O(M*N)
MERMORY O(1)
 */
package HashTable;

public class JewelsandStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J = "aA", S = "aAAbbbb";
		System.out.println(numJewelsInStones(J, S));
	}
	
    public static int numJewelsInStones(String J, String S) {
        char[] a = J.toCharArray();
        int count=0;
        char[] ss= S.toCharArray();
        for(int i=0;i<ss.length;i++){
            for(int j=0;j<a.length;j++){
                if(ss[i]==a[j]){
                    count++;
                }
            }
        }
        return count;
    }

}
