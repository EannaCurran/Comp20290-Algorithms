package src.Practical3;

/**
 * Practical 3 - Fibonacci Sequence Using Recursion - 10/2/2020
 */

public class fibonacciRecursion {

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
}