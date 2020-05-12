// Practical 2 - Eanna Curran - 18311676 - Timing for Fibonacci Sequence Generators
package src.Practical3;

public class fibonacciTimingComparison {


	/**
	 * Method to compare timing of iterative and recursive solution to printing the nth term in the fibonacci sequence
	 */
	public static void timingComparison(){
		int n = 1;

		// Loops the first 25 items in the fibonacci sequence
		while (n < 26){

			// Records the time taken for the iterative method to find the nth term in the sequence
			long startTime = System.nanoTime();
			int iterative = fibonacciIterativeSolver(n);
			final long elapsedTime1 = System.nanoTime() - startTime;

			// Records the time taken for the recursive method to find the nth term in the sequence
			startTime = System.nanoTime();
			int recursion = fibonacciRecursionSolver(n);
			final long elapsedTime2 = System.nanoTime() - startTime;

			// Prints the time taken by both methods
			System.out.println("N value: " + n + " Iterative time: " + elapsedTime1 +" Recursion time: " + elapsedTime2 + " Result equal: " + (iterative==recursion));
			n++;
		}
	}

	public static void main(String[] args) {

		timingComparison();
	}


	/**
	 * Implementation of recursively finding the nth term of the Fibonacci Sequence
	 * @param n: Which term in the Fibonacci Sequence you want
	 * @return fib: nth term in the Fibonacci Sequence
	 */
	public static int fibonacciRecursionSolver(int n) {

		// Returns 0 for base case of n equalling 0
		if(n == 0) {
			return 0;
		}

		// Returns 1 for base case of n equalling 1
		else if (n == 1){
			return 1;
		}

		// Recursively returns the sum of the previous 2 terms
		else {
			return fibonacciRecursionSolver(n - 1) + fibonacciRecursionSolver(n - 2);
		}
	}


	/**
	 * Implementation of iteratively printing a specified number of terms in the Fibonacci Sequence
	 * @param n: Which term in the Fibonacci Sequence you want
	 * @return fib: nth term in the Fibonacci Sequence
	 */
	public static int fibonacciIterativeSolver(int n) {

		// Returns 0 for base case of n being less than 1
		if (n < 1) {
			return 0;
		}

		// Returns 1 for base case of n equalling 1
		if (n == 1){
			return 1;
		}

		// Declaring current and previous values in the sequence
		int fib = 1;
		int prevFib = 1;

		// Loops for n terms, adds the previous term in the sequence to fib and increments the previous term
		for (int i = 2; i < n; i++) {
			int temp = fib;
			fib += prevFib;
			prevFib = temp;
		}

		// Returns value of nth term of sequence
		return fib;
	}
}
