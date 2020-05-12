// Practical 7 - Eanna Curran - 18311676 -  Brute Force Substring Finder

package src.Practical7;

public class substringBruteForce {


	/**
	 * Method to find the position if a given substring within a string
	 * @param pattern Substring to find
	 * @param text String to search
	 * @return Position of substring in string, returns null if substring not present
	 */
	public static Integer substringBruteForce(String pattern, String text){

		// Declares the length of the string and substring
		int patternLength = pattern.length();
		int textLength = text.length();

		// Loops until the last possible position to have the substring
		for(int i = 0; i <= textLength - patternLength; i++){
			int j;

			// Loops through the current position of the string for te length of the substring
			for(j = 0; j < patternLength; j++){

				// If the patterns doesn't match break
				if(text.charAt(i+j) != pattern.charAt(j)){ break; }

				// Returns i if the pattern matches
				if(j == patternLength-1){ return i; }
			}
		}

		// Returns null if the pattern doesn't match
		return null;
	}

	public static void main(String[] args) {
		String pattern = "H";
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		System.out.println(substringBruteForce(pattern,text));
	}
}
