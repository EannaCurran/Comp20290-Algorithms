// Practical 4 - Eanna Curran - 18311676 - Sorting Algorithms Timing
package src.Practical4;

import java.util.Random;

public class algorithmTiming {

    /**
     * Method to check if a given array is in order
     * @param array Array to check
     * @return Boolean result of if the array is sorted
     */
    public static boolean isOrdered(int[] array){

        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                return false;
            }
        }
        return true;
    }


    /**
     * Method to generate an array of random integers
     * @param n Size of array to generate
     * @return Random array
     */
    public static int[] randomArray(int n){
        int[] array = new int[n];
        Random random = new Random();

        for(int i = 0; i < n; i++){
            array[i] = random.nextInt(n);
        }
        return array;
    }


    /**
     * Method to record the time taken to sort random arrays with sorting algorithms
     */
    public static void sortingTiming(){

        int n = 10;
        int[] randomArray;
        long startTime;
        long endTime;
        long elapsedTime;
        int[] result;

        while(n < 10000) {
            randomArray = randomArray(n);
            startTime = System.nanoTime();
            result = sortingAlgorithms.selectionSort(randomArray);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Selection sort - " + "Size: " + n + " Is Sorted: " + isOrdered(result) + " Time: " + elapsedTime);

            startTime = System.nanoTime();
            result = sortingAlgorithms.insertionSort(randomArray);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Insertion Sort - " + "Size: " + n + " Is Sorted: " + isOrdered(result) + " Time: " + elapsedTime);

            startTime = System.nanoTime();
            result = sortingAlgorithms.stalinSort(randomArray);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Stalin Sort    - " + "Size: " + n + " Is Sorted: " + isOrdered(result) + " Time: " + elapsedTime);
            n *= 2;
        }


        }

    public static void main(String[] args) {
        sortingTiming();
    }


}
