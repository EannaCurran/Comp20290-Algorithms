// Practical 7 - Eanna Curran - 18311676 -  Knuth Morris Pratt Algorithm

package src.Practical7;

public class knuthMorrisPrattAlgorithm {

	/**
	 * Implementation of the Knuth Morris Pratt Algorithm
	 * @param pattern Substring to find
	 * @param text String to search
	 * @return Position of substring in string, returns null if substring not present
	 */
	public static Integer knuthMorrisPrattAlgorithm(String pattern, String text){

		// Declaring variables
		int patternLength = pattern.length();
		int textLength = text.length();
		int[] lps = new int[patternLength];
		int textIndex = 0;
		int patternIndex = 0;


		// Preprocesses the pattern
		computeLPSArray(pattern, patternLength, lps);

		// Loops through the text
		while(textIndex < textLength){

			// Check for pattern and string having the same character
			if(pattern.charAt(patternIndex) == text.charAt(textIndex)){
				patternIndex++;
				textIndex++;

			}

			// Return if the pattern has been found
			if(patternIndex == patternLength){
				return textIndex - patternIndex;
			}

			// Checks if the pattern doesn't match the current place in the string and moves to the
			// index in the lps array
			else if(textIndex < textLength && pattern.charAt(patternIndex) != text.charAt(textIndex)){
				if(patternIndex != 0){
					patternIndex = lps[patternIndex - 1];
				}
				else{
					textIndex = textIndex + 1;
				}
			}
		}

		// Null is returned since no substring is found
		return null;
	}


	/**
	 * Method to process the pattern into a array of position that indicate where it can skip indexes
	 * @param pattern Substring
	 * @param patternLength Length of the substring
	 * @param lps Array to hold array of positions
	 */
	static void computeLPSArray(String pattern, int patternLength, int[] lps){

		// Declaring variables
		int length = 0;
		int index = 1;
		lps[0] = 0;

		// Loops until the pattern length has been reached in the position array
		while(index < patternLength){

			// Updates index value if it matches the current character in the pattern
			if(pattern.charAt(index) == pattern.charAt(length)){
				length++;
				lps[index] = length;
				index++;
			}

			// Moves to next index
			else{
				if(length != 0){
					length = lps[length-1];
				}
				else{
					lps[index] = length;
					index++;
				}
			}
		}
	}

	public static void main(String[] args) {
		String text = "ABCDEFGHIJKLMNOPQRSTUVQXYZ";
		String pattern = "HIJK";
		System.out.println(knuthMorrisPrattAlgorithm(pattern, text));
	}
}
