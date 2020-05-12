// Practical 4 - Eanna Curran - 18311676 - Sorting Algorithms Timing
package src.Practical4;

import java.util.Arrays;


/**
 * Practical 4 - Implementation of sorting algorithms - 24/2/2020
 */
public class sortingAlgorithms {


    /**
     * Implementation of the selection sort algorithm
     * @param unsortedArray: Array of integers to be sorted
     * @return Sorted array of integers
     */
    public static int[] selectionSort(int [] unsortedArray) {

        // Declaring variables
        int temp;
        int minIndex;

        // Loops through each index in the array
        for(int i = 0; i < unsortedArray.length; i ++) {

            // Sets minIndex as current starting index
            minIndex = i;

            // Loops through each index after the minIndex
            for(int j = i+1; j < unsortedArray.length; j++) {

                // Checks if the item at the minIndex is larger than at index j, if so minIndex is set to j
                if(unsortedArray[minIndex] > unsortedArray[j]) {

                    minIndex = j;
                }
            }

            // Swaps item at index i and index minIndex
            temp =unsortedArray[i];
            unsortedArray[i] = unsortedArray[minIndex];
            unsortedArray[minIndex] = temp;

        }

        // Returns the original unsorted array sorted
        return unsortedArray;
    }



    /**
     * Implementation of the insert sort algorithm
     * @param unsortedArray: Array of integers to be sorted
     * @return Sorted array of integers
     */
    public static int[] insertionSort(int [] unsortedArray){

        // Loops through each index of the array
        for(int i = 1; i < unsortedArray.length; ++i) {

            // Declaring variables
            int key = unsortedArray[i];
            int j = i - 1;

            // Loops while the item at the previous index in the array is greater than the item at the current position;
            while(j >= 0 && unsortedArray[j] > key) {

                // Swaps the items at index j+1 and i
                unsortedArray[j+1] = unsortedArray[j];
                j--;
                unsortedArray[j + 1] = key;
            }
        }

        // Returns the sorted array
        return unsortedArray;
    }


    /**
     * Implementation of the Stalin sort algorithm
     * @param unsortedArray Array to sort
     * @return Sorted array
     */
    public static int[] stalinSort(int [] unsortedArray){

        // Copies the original array
        unsortedArray = Arrays.copyOf(unsortedArray, unsortedArray.length);

        int i = 0;

        // Loops through the original array and removes elements that are greater than their predecessor
        for (int j = 1; j < unsortedArray.length; i++, j++) {
            if (unsortedArray[i] > unsortedArray[j]) {
                i--;
            } else {
                if (j - i > 1) {
                    unsortedArray[i + 1] = unsortedArray[j];
                }
            }
        }

        // Returns a copy of the sorted array
        return Arrays.copyOf(unsortedArray, i + 1);
    }


    public static void main(String[] args) {
        int[] arraycop = {5,6,2,8,9,3,12,5,33};
        System.out.println(Arrays.toString(stalinSort(arraycop)));
    }
}
