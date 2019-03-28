/*
 * NAME:OMER ORHAN  GID:16
 * Design an algorithm which transforms a source word to a target word. 
 * for example: from head to tail. In each step, you just can replace one character, 
 * and the resulting word must be valid. You'll be given a dictionary. 
 * Your function must not only return if there is a path but spell the specific path:
bool isThereValidPath(map<string, bool> validWords, string startWord, string endWord) {
}

Please adapt the prototype to your language of choice. 
TIME COMPLEXITY:O(M*N) M is length of the array N is length of the words
SPACE COMPLEXITY:O(M*N) M is length of the array N is length of the words
test case:
input: hit,cog
path:hot-dot-lot-dog-log-cog
isvalidpath= true
input hit,cox
isvalidpath=false
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class homework8 {
	public class Result{
		//to return isvalidpath and path
		boolean isValidPath;
		List<String> path;
		public Result(boolean isValidPath,List<String> path) {
			this.isValidPath=isValidPath;
			this.path=path;
		}
	}

	public static void main(String[] args) {
		HashMap<String, Boolean> validWords = new HashMap<String, Boolean>();
		validWords.put("hot", false);
		validWords.put("dot", false);
		validWords.put("dog", false);
		validWords.put("lot", false);
		validWords.put("log", false);
		homework8 work = new homework8();
		Result result = work.isThereValidPath(validWords, "hit", "cox");
		//print out result
		System.out.println("isValidPath"+result!=null?result.isValidPath:false);
		if(result!=null&&result.path!=null) {
			for (String string : result.path) {
				System.out.println(string);
			}
		}
	}

	public Result isThereValidPath(HashMap<String, Boolean> validWords, String startWord,
			String endWord) {
		Result result= new Result(false, null);
		result.path=new ArrayList<String>();
		LinkedList<String> queue = new LinkedList<String>();
		queue.add(startWord);
		validWords.put(endWord, false);
		while (!queue.isEmpty()) {
			String word = queue.remove();
			if (word.equals(endWord)) {
				result.isValidPath=true;
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
						result.path.add(newWord);
						queue.add(newWord);
						validWords.remove(newWord);
					}

					arr[i] = temp;
				}
			}
		}

		return result;
	}

}
