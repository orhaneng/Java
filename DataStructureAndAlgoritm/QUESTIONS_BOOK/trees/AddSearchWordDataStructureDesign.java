/*
 * 211. Add and Search Word - Data structure design
Medium

786

51

Favorite

Share
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */
package trees;

public class AddSearchWordDataStructureDesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary obj = new WordDictionary();
		obj.addWord("bad");
		System.out.println(obj.search("c.ad"));
	}

	static class WordDictionary {

		TrieNode root;

		/** Initialize your data structure here. */
		public WordDictionary() {
			root = new TrieNode();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new TrieNode();
				}
				node = node.children[c - 'a'];
			}
			node.val = word;
		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character '.' to represent any one letter.
		 */
		public boolean search(String word) {
			return match(word.toCharArray(), 0, root);
		}

		public boolean match(char[] chs, int k, TrieNode node) {
			if (k == chs.length)
				return !node.val.equals("");
			if (chs[k] != '.') {
				return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
			} else {
				for (int i = 0; i < node.children.length; i++) {
					if (node.children[i] != null) {
						if (match(chs, k + 1, node.children[i])) {
							return true;
						}
					}
				}
			}
			return false;
		}

		public class TrieNode {
		       public TrieNode[] children = new TrieNode[26];
		        public String val = "";
		}
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
	 * = obj.search(word);
	 */
}
