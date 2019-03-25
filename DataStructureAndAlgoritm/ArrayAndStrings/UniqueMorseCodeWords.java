import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*https://leetcode.com/problems/unique-morse-code-words/
 * 804. Unique Morse Code Words
Easy

398

293

Favorite

Share
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".

 */
public class UniqueMorseCodeWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
	}
    public static int uniqueMorseRepresentations(String[] words) {
        
        String[] list = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> map = new HashSet<String>();
        Map<String,String> table = new HashMap<String, String>();
        int j=0;
        for (int i = 65; i <= 90; i++) {
            table.put((String.valueOf((char)i)),list[j++]);
        }
        
        for(int i=0;i<words.length;i++){
            String word="";
            for(int k=0;k<words[i].length();k++){
            	
                word= word+ table.get(String.valueOf(words[i].toUpperCase()
                		.charAt(k)));
            }
            map.add(word);
        }
        return map.size();
    }
	

}
