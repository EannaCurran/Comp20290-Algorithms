// Practical 8 - Eanna Curran - 18311676 -  Trie

package src.Practical8;

public class Trie{


	// Declaring variables for Trie
	static final int ALPHABET_SIZE = 26;
	static TrieNode root;


	/**
	 * TrieNode class
	 */
	static class TrieNode {

		// Declaring variables for Node
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
		static TrieNode root;


		/**
		 * Constructor for TrieNode, initialises all children nodes to null
		 */
		TrieNode(){
			isEndOfWord = false;

			for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
		}
	}


	/**
	 * Method to insert a new string into the trie
	 * @param key String to place into the trie
	 */
	static void insert(String key){

		// Declares variables
		int keyLength = key.length();
		int currentIndex;
		TrieNode currentNode = root;

		// Loops through each character in the string
		for(int currentLevel = 0; currentLevel < keyLength; currentLevel++){

			// Converts the current character to its index position in the trie
			currentIndex = key.charAt(currentLevel) - 'a';

			// Checks if the index of the has a node in it
			if(currentNode.children[currentIndex] == null){
				currentNode.children[currentIndex] = new TrieNode();
			}

			// Sets the current node child to be the node of the current character
			currentNode = currentNode.children[currentIndex];
		}

		// Sets the last node in the trie to be the end of the word
		currentNode.isEndOfWord = true;
	}


	/**
	 * Method to search the trie for a given string
	 * @param key String to search trie for
	 * @return Boolean result for if the string is in the trie
	 */
	static boolean search(String key) {

		// Declaring variables
		int keyLength = key.length();
		int currentIndex;
		TrieNode currentNode = root;

		// Loops through each character in the string
		for(int currentLevel = 0; currentLevel < keyLength; currentLevel++){

			// Converts the current character to its index position in the trie
			currentIndex = key.charAt(currentLevel) - 'a';

			// If the node at the current index doesn't exit the word is not in the trie
			if(currentNode.children[currentIndex] == null){ return false; }

			// Moves to the next node
			currentNode = currentNode.children[currentIndex];
		}

		// Returns true if the current node is the end of the given string
		return currentNode.isEndOfWord;
	}


	// Driver
	public static void main(String[] args) {

        // Input keys (use only 'a' through 'z' and lower case)
		String[] keys = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


		String[] output = {"Not present in trie", "Present in trie"};

		root = new TrieNode();
		// Construct trie
		int i;
		for (i = 0; i < keys.length ; i++) {
			insert(keys[i]);
		}
		System.out.println("Is bank in the trie? - " + search("bank"));
		System.out.println("Is cat in the trie? - " + search("cat"));



	}
}