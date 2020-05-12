package src.Practical5;

import java.util.Arrays;

import static src.Practical4.sortingAlgorithms.insertionSort;

public class mergeSortEnhanced {

		public static int[] mergeSortEnhanced(int[] array, int low, int high){

			// Declaring variable to store the length of the array
			int length = array.length;

			// Base case
			if(length == 1){ return array; }

			// Declares cutoff for when insertion sort will be used over quick sort
			int CUTOFF = 10;

			// If the size of the array is less than the cutoff then insertion sort is used to sort the array
			if (high <= low + CUTOFF) {
				array = insertionSort(array);
				return array;
			}

			// Declaring new integer arrays to hold the left and right side of the array
			int[] left = new int[(length + 1)/2];
			int[] right = new int[length - left.length];

			// Creates copies of the array of the left and right side of the array
			System.arraycopy(array, 0, left, 0, left.length);
			System.arraycopy(array, left.length, right, 0, right.length);

			// Create left and right sub array
			mergeSortEnhanced(left, 0, left.length);
			mergeSortEnhanced(right, 0, right.length);

			// Mergers the sorted sub arrays
			if (left[left.length - 1] <= right[0]) {
				return array;
			}
			merge(left, right, array);

			// Returns the sorted array
			return array;
		}

		private static void merge(int[] left, int[] right, int[] array){

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
			System.out.println(Arrays.toString(mergeSortEnhanced(array, 0, 12)));
		}
	}


