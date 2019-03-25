/*https://leetcode.com/problems/reverse-only-letters/
 * 917. Reverse Only Letters
Easy

200

23

Favorite

Share
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.

 

Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseOnlyLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseOnlyLetters("ab-cd"));

	}
    public static String reverseOnlyLetters(String S) {
        char[] array = S.toCharArray(); 
        char[] chara=new char[array.length];
        int k=0;
        for(int i=array.length-1;i>=0;i--){
            for (int j = 0; j < 26; j++)
            {
                if((array[i]==(char) ('A' + j))||(array[i]==(char) ('a' + j))){
                    chara[k]=array[i];
                    array[i]=' ';
                    ++k;
                    break;
                }
            }
        }
        k=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==' '){
                array[i]= chara[k];
                k=k+1;
            }
        }
        return String.copyValueOf(array);
    }

}
