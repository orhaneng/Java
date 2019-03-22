/* NAME:OMER ORHAN GID:16
 * HOMEWORK7
 * Create a program that creates and uses the valid word matrix described in class for 
 * the ValidWordSequence recursive problem. i.e. Give a string and a dictionary create 
 * a two dimensional boolean matrix where m[i,j] = true if substring(i through j) is 
 * valid word and false if not. Then use the best algorithm to employ that matrix to 
 * solve the problem that was shown to be O(n!) in its recursive form.
 * 
 * TIME COMPLEXITY:O(N)
 * SPACE COMLEXITY:O(N)
 * test case:
 * String text = "theyaregreatbooks";
 * Dictionary;
 * 		dictionary.add("they");
		dictionary.add("are");
		dictionary.add("great");
		dictionary.add("books");
   OUTPUT
   a few TRUE examples
 * matrix[0][4]=true
   matrix[4][7]=true
   matrix[7][12]=true
   a few FALSE examples
   matrix[0][0]=false
   matrix[0][1]=false
   matrix[0][2]=false
   matrix[0][3]=false
 */
import java.util.ArrayList;

public class Homework7 {

	static String text = "theyaregreatbooks";
	static ArrayList<String> dictionary = new ArrayList<String>();

	static boolean[][] matrix = new boolean[text.length()][text.length()];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dictionary.add("they");
		dictionary.add("are");
		dictionary.add("great");
		dictionary.add("books");
		System.out.println(ValidWordSequence(0, 0));
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < text.length(); j++) {
					System.out.println("matrix[" + i + "][" + j + "]=" + matrix[i][j]);
			}
		}
	}

	public static boolean ValidWordSequence(int i, int j) {
		if (text == null && text.length() == 0) {
			return true;
		} else if (j == text.length() && dictionary.contains(text.substring(i, j))) {
			return true;
		} else if (j > text.length()) {
			return false;
		}
		// check if there is not a match,then increase j
		if (!dictionary.contains(text.substring(i, j))) {
			matrix[i][j] = false;
			return ValidWordSequence(i, ++j);
		} else {// if there is a match, check another word
			matrix[i][j] = true;
			i = j;
			return ValidWordSequence(i, ++j);
		}
	}

}
