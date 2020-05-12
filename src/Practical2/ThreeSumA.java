// Practical 2 - Eanna Curran - 18311676 - Three Sum A
package src.Practical2;

import java.lang.*;

public class ThreeSumA {

    // Do not instantiate.
    private ThreeSumA() { }


    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param  a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     *         such that {@code a[i] + a[j] + a[k] == 0}
     */
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    /**
     * Reads in a sequence of integers from a file, specified as a command-line argument;
     * counts the number of triples sum to exactly zero; prints out the time to perform
     * the computation.
     *
     * @param args the command-line arguments of the file to be read
     */
    public static void main(String[] args)  {
        In in = new In("1Kints.txt");
        int[] a = in.readAllInts();
        final long startTime = System.currentTimeMillis();
        int count = count(a);
        final long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Count =" + count);
        System.out.println("Time elapsed = " + elapsedTime);
    }
}