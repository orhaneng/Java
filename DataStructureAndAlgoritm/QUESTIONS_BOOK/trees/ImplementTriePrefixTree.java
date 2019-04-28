/*\
 *  Implement Trie (Prefix Tree)
  Go to Discuss
Implement a trie with insert, search, and startsWith methods.
Example:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

 */
package trees;

import trees.ImplementTriePrefixTree.Trie.TrieNode;

public class ImplementTriePrefixTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("applx");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("orange"));
	}

	static class Trie {

		public class TrieNode {
			public char val;
			public boolean isWord;
			public TrieNode[] children = new TrieNode[26];;

			public TrieNode() {
			};

			public TrieNode(char val) {
				this.val = val;
			}
		}

		/** Initialize your data structure here. */
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.children[c - 'a'] == null) {
					node.children[c - 'a'] = new TrieNode(c);
				}
				node = node.children[c - 'a'];
			}
			node.isWord=true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.children[c - 'a'] == null)
					return false;
				node = node.children[c - 'a'];
			}
			return node.isWord;

		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode node = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (node.children[c - 'a'] == null)
					return false;
				node = node.children[c - 'a'];
			}
			return true;
		}
	}

}
