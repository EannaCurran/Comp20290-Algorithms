package src.Practical5;

import java.util.Arrays;

public class mergeSort {

    /**
     * Implementation of merge sort
     * @param array: Array to be sorted
     * @return the sorted array
     */
    public static int[] mergeSort(int[] array) {

        // Declaring variable to store the length of the array
        int length = array.length;

        // Base case
        if(length == 1) { return array; }

        // Declaring new integer arrays to hold the left and right side of the array
        int[] left = new int[(length + 1)/2];
        int[] right = new int[length - left.length];

        // Creates copies of the array of the left and right side of the array
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);

        // Create left and right sub array
        mergeSort(left);
        mergeSort(right);

        // Merges the sub arrays into a new array
        merge(left, right, array);

        // Returns the sorted array
        return array;
    }


    /**
     * Method to merge two arrays together
     * @param left: Left array
     * @param right: Right array
     * @param array: Original array
     */
    private static void merge(int[] left, int[] right, int[] array){

        // Declaring variables
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = 0;

        // Repeats while the arrays have elements in them
        while(leftIndex < left.length && rightIndex < right.length){

            // Checks if the current left or right item is bigger, puts the smaller one first into the array
            if(left[leftIndex] < right[rightIndex]){

                array[arrayIndex++] = left[leftIndex++];
            }
            else{

                array[arrayIndex++] = right[rightIndex++];
            }
        }

        // Adds the rest of left and right to the
        System.arraycopy(left, leftIndex, array, arrayIndex, left.length - leftIndex );
        System.arraycopy(right, rightIndex, array, arrayIndex, right.length - rightIndex );
    }


    public static void main(String[] args) {
        int[] array = {1,5,2,7,8,3,6,8,3,6,2,6,2};
        System.out.println(Arrays.toString(mergeSort(array)));
    }
}
