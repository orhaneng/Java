import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Design an algorithm which transforms a source word to a target word. 
 * for example: from head to tail. In each step, you just can replace one character, 
 * and the resulting word must be valid. You'll be given a dictionary. 
 * Your function must not only return if there is a path but spell the specific path:
bool isThereValidPath(map<string, bool> validWords, string startWord, string endWord) {
}

Please adapt the prototype to your language of choice. 
 */
public class homework8 {

	public static void main(String[] args) {
		HashMap<String, Boolean> validWords = new HashMap<String, Boolean>();
		validWords.put("hot", false);
		validWords.put("dot", false);
		validWords.put("dog", false);
		validWords.put("lot", false);
		validWords.put("log", false);
		homework8 work = new homework8();
		System.out.println(work.isThereValidPath(validWords, "hit", "cog"));
		
	}
	
	public boolean isThereValidPath(HashMap<String, Boolean> validWords, String startWord, String endWord) {
		LinkedList<String> queue = new LinkedList<String>();
		queue.add(startWord);
		validWords.put(endWord, false);
		while (!queue.isEmpty()) {
			String word = queue.remove();
			if (word.equals(endWord)) {
				return true;
			}
			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}

					String newWord = new String(arr);
					if (validWords.containsKey(newWord)) {
						System.out.println(newWord);
						queue.add(newWord);
						validWords.remove(newWord);
					}

					arr[i] = temp;
				}
			}
		}

		return false;
	}

}
