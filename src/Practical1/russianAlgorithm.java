// Practical 1 - Eanna Curran - 18311676 - Implementing and timing for the Russian multiplication algorithm

package src.Practical1;
import java.util.Random;


/**
 * Practical 1 - Russian algorithm to multiply two numbers
 */
public class russianAlgorithm {


    /**
     * Implementation of the Russian multiplying algorithm
     *
     * @param A: First number to multiply
     * @param B: Second number to multiply
     * @return Product of A and B
     */
    public static long russianAlgorithmSolver(long A, long B) {

        // Declares initial size of product
        long accumulator = 0;

        // Loops until A is equal to 0
        while (A != 0) {

            // Checks if A is odd, if so B is added to product
            if (A % 2 == 1) {

                accumulator += B;
            }

            // A is halved and B is doubled
            A /= 2;
            B *= 2;
        }

        // Returns product of A and B
        return accumulator;
    }


    /**
     * Method to check if russianAlgorithm has return the correct result
     * @param answer Result from russianAlgorithm
     * @param A First element of multiplication
     * @param B Second element of multiplication
     * @return Boolean result of comparison
     */
    public static boolean isEqual(long answer, long A, long B){ return answer== (A * B); }


    /**
     * Method to measure time taken for russianAlgorithm to return result in nano seconds
     */
    public static void russianAlgorithmTiming(){

        int n = 1;
        // Generates numbers with 1 to 1000000000
        while(n < 1000000000){

            // Generates random number within range of n and n*10
            int max = n * 10;
            int min = n;
            Random r = new Random();
            long A = r.nextInt((max - min) + 1) + min;
            long B = r.nextInt((max - min) + 1) + min;

            // Records time taken for russianAlgorithm to return result and prints answer
            final long startTime = System.nanoTime();
            long answer = russianAlgorithmSolver(A, B);
            final long elapsedTime = System.nanoTime() - startTime;
            System.out.println("the time taken " + elapsedTime + " A = " + A + " B = " + B + " Result = " + answer +" result valid " + isEqual(answer, A, B));


            n *= 10;
        }
    }


    public static void main(String[] args) {

        russianAlgorithmTiming();
    }
}
