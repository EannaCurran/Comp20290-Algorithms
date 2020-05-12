// Assignment 1 - Eanna Curran - 18311676 - Huffman Encoding

package src.Assignment;

import src.Assignment.helperCode.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Implementation of Huffman encoding to compress and decompress files
 */
public class Huffman {


	// Declaring private variables
	private static final int R = 256;
	private static BinaryOut fileWriter;
	private static BinaryIn fileInput;


	/**
	 * Empty constructor
	 */
	private Huffman() { }


	/**
	 * Private class to implement Huffman trie nodes
	 */
	private static class Node implements Comparable<Node> {

		// Declaring variables
		private final char ch;
		private final int freq;
		private final Node left, right;


		/**
		 * Constructor for trie node
		 * @param ch Character of node
		 * @param freq Frequency of character
		 * @param left Left child node
		 * @param right Right child node
		 */
		Node(char ch, int freq, Node left, Node right) {
			this.ch    = ch;
			this.freq  = freq;
			this.left  = left;
			this.right = right;
		}


		/**
		 * Method to check if the node is a leaf or not
		 * @return Boolean result of the check
		 */
		private boolean isLeaf() {
			assert ((left == null) && (right == null)) || ((left != null) && (right != null));
			return (left == null) && (right == null);
		}

		/**
		 * Method to compare the frequency of another node
		 * @param that Node to compare frequency
		 * @return Difference in frequencies of the two nodes
		 */
		public int compareTo(Node that) {
			return this.freq - that.freq;
		}
	}


	/**
	 * Method to read, compress and write the compressed file
	 * @param inputFile File to compress
	 * @param outputFile File to write compression to
	 * @throws FileNotFoundException If input file is not in local directory
	 */
	public static void compress(String inputFile, String outputFile) throws FileNotFoundException {

		// Declaring variables
		char[] inputCharacters;

		// Reads the input of the inputFile
		String inputString = new Scanner(new File(inputFile)).useDelimiter("\\Z").next(); // .useDelimiter used since developed in on ubuntu, removing it should work for windows
		inputCharacters = inputString.toCharArray();


		// Creates table of frequency count
		int[] frequencyCounter = new int[R];
		for (char inputCharacter : inputCharacters) {
			frequencyCounter[inputCharacter]++;
		}

		// Builds the Huffman trie
		Node huffmanTrie = buildTrie(frequencyCounter);

		// Builds the code table
		String[] codeTable = new String[R];
		buildCode(codeTable, huffmanTrie, "");

		// Writes the trie to the output file
		fileWriter = new BinaryOut(outputFile);
		writeTrie(huffmanTrie);

		// Writes the number of bytes in the original file
		fileWriter.write(inputCharacters.length);


		// Uses Huffman code to encode input and writes it to the output file
		for (char inputCharacter : inputCharacters) {
			String code = codeTable[inputCharacter];
			for (int j = 0; j < code.length(); j++) {
				if (code.charAt(j) == '0') {
					fileWriter.write(false);
				} else if (code.charAt(j) == '1') {
					fileWriter.write(true);
				}
			}
		}

		fileWriter.flush();
	}


	/**
	 * Method to read in a compressed file and expand it using Huffman encoding
	 * @param inputFile File to decompress
	 * @param outputFile File to write decompression to
	 */
	public static void decompress(String inputFile, String outputFile) {

		// Reads in Huffman trie from input file
		fileInput = new BinaryIn(inputFile);
		fileWriter = new BinaryOut(outputFile);
		Node huffmanTrie = readTrie();

		// Reads the number of bytes to write from input file
		int bytes = fileInput.readInt();

		// Decode the input file using the Huffman trie and writes the result to the output file
		for (int i = 0; i < bytes; i++) {
			Node currentNode = huffmanTrie;
			while (!currentNode.isLeaf()) {
				boolean move = fileInput.readBoolean();
				if (move){
					currentNode = currentNode.right;
				}
				else {
					currentNode = currentNode.left;
				}
			}

			fileWriter.write(currentNode.ch, 8);
		}

		fileWriter.flush();
	}


	// Build the Huffman trie given frequencies
	private static Node buildTrie(int[] freq) {

		// Initialize priority queue with singleton trees
		MinPQ<Node> pq = new MinPQ<Node>();
		for (char i = 0; i < R; i++)
			if (freq[i] > 0)
				pq.insert(new Node(i, freq[i], null, null));

		// special case in case there is only one character with a nonzero frequency
		if (pq.size() == 1) {
			if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
			else                 pq.insert(new Node('\1', 0, null, null));
		}

		// Merge two smallest trees
		while (pq.size() > 1) {
			Node left  = pq.delMin();
			Node right = pq.delMin();
			Node parent = new Node('\0', left.freq + right.freq, left, right);
			pq.insert(parent);
		}
		return pq.delMin();
	}


	// Write bit string encoded trie to standard output
	private static void writeTrie(Node x) {
		if (x.isLeaf()) {
			fileWriter.write(true);
			fileWriter.write(x.ch, 8);
			return;
		}
		fileWriter.write(false);
		writeTrie(x.left);
		writeTrie(x.right);
	}


	// Make a lookup table from symbols and their encodings
	private static void buildCode(String[] st, Node x, String s) {
		if (!x.isLeaf()) {
			buildCode(st, x.left,  s + '0');
			buildCode(st, x.right, s + '1');
		}
		else {
			st[x.ch] = s;
		}
	}


	// Read the trie from standard input
	private static Node readTrie() {
		boolean isLeaf = fileInput.readBoolean();
		if (isLeaf) {
			return new Node(fileInput.readChar(), -1, null, null);
		}
		else {
			return new Node('\0', -1, readTrie(), readTrie());
		}
	}


	/**
	 * Main method usage - java Huffman compress/decompress inputFile outputFile
	 * @param args Compression type and file name
	 * @throws FileNotFoundException If input file is not in local directory
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// Declaring variables
		final long startTime;
		final long endTime;
		final long elapsedTime;

		// Check if files are to be compressed and prints time taken to compress
		if(args[0].equals("compress")){
			startTime = System.currentTimeMillis();
			compress(args[1], args[2]);
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println("Time taken to compress: " + elapsedTime);
		}

		// Check if files are to be decompressed and prints time taken to decompress
		else if(args[0].equals("decompress")){
			startTime = System.currentTimeMillis();
			decompress(args[1], args[2]);
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			System.out.println("Time taken to compress: " + elapsedTime);
		}

		// Invalid command line arguments
		else{
			System.out.println("Error: Invalid command");
		}

	}

}
