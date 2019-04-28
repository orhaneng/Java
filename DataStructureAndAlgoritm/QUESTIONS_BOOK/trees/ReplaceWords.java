/*
 * 648. Replace Words
Medium
420
104
Favorite
Share
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
You need to output the sentence after the replacement.
Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 */
package trees;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> dict =new ArrayList<String>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		String sentence = "the cattle was rattled by the battery";
		System.out.println(replaceWords(dict, sentence));
	}
    static public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for(String word : dict){
            TrieNode curr = root;
            for(char letter:word.toCharArray()){
                if(curr.children[letter-'a']==null){
                    curr.children[letter-'a']=new TrieNode();
                }
                curr= curr.children[letter-'a'];
            }
            curr.word=word;
        }
        
        StringBuilder ans = new StringBuilder();
        for(String word:sentence.split(" ")){
            if(ans.length()>0) ans.append(" ");
            TrieNode cur= root;
            for (char letter:word.toCharArray()){
                if(cur.children[letter-'a']==null||cur.word!=null)
                    break;
                cur=cur.children[letter-'a'];
            }
            ans.append(cur.word!=null?cur.word:word);
        }
        return ans.toString();
    }
    
    static class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(){
            
        }
    }

}
