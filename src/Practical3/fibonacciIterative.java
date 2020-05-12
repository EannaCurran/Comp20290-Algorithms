package src.Practical3;

/**
 * Practical 3 - Fibonacci Sequence Using a Iterative Approach - 10/2/2020
 */


public class fibonacciIterative {

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