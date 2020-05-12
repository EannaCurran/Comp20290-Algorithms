// Practical 9 - Eanna Curran - 18311676 -  Run Length Encoding

package src.Practical9;

public class runLengthEncoding {

	/**
	 * Main Method which compresses a given string to run length encoding
	 * @param args string to encode
	 */
	public static void main(String[] args) {

		// Declares variables
		StringBuilder encoded = new StringBuilder();
		String input = args[0];
		int count = 1;
		char c = input.charAt(0);

		// Loops through the input string
		for(int i = 1; i < input.length(); i++){

			// Counts increases if the current character is the same as the previous one
			if(c == input.charAt(i)){
				count++;
			}

			// Otherwise append the current character and its count to the encode and sets a new
			// current character
			else{
				encoded.append(c);
				encoded.append(count);
				count = 1;
				c = input.charAt(i);
			}
		}

		encoded.append(c);
		encoded.append(count);

		// Prints the result
		System.out.println(encoded);
	}
}
