package src.Practical6;

import java.util.Arrays;

public class quickSort {

	/**
	 * Implementation of an enhanced version of quick SORT
	 * @param arr: Array to be sorted
	 * @param low: First index of the array
	 * @param high: Last index of the array
	 * @return Sorted array
	 */
	public static int[] quickSort(int[] arr, int low, int high) {

		// Checks if there are still recursive calls divide the array to be made
		if (low < high) {

			// Partitions the array between the high and low values
			int pi = partition(arr, low, high);

			// Recursive call to quick sort the first half ot the array
			quickSort(arr, low, pi - 1);

			// Recursive call to quick sort the second half of the array
			quickSort(arr, pi + 1, high);
		}

		// Returns the sorted array
		return arr;
	}

	/**
	 * Method to swap the values at index i and j
	 * @param arr: Array containing elements to be swapped
	 * @param i: First index of element to be swapped
	 * @param j: Second index of element to be swapped
	 */
	private static void swap(int[] arr, int i, int j) {

		// Temporary holds the value at i;
		int temp = arr[i];

		// Swaps the values at i and j
		arr[i] = arr[j];
		arr[j] = temp;
	}


	/**
	 * Method to partition a given array
	 * @param arr: Array to be partitioned
	 * @param low: Lowest index in the array
	 * @param high: Highest index in the array
	 * @return The index of the new pivot
	 */
	private static int partition(int[] arr, int low, int high) {

		// Declaring variables
		int pivot = arr[high];
		int i = low - 1;
		int temp;

		// Loops through each element in the array other than the last one
		for (int j = low; j <= high - 1; j++) {

			// Checks if the element at the pivot is greater than the current element
			if (arr[j] < pivot) {

				// I is incremented and i/j are swapped
				i++;
				swap(arr, i, j);
			}
		}

		// Elements at i + 1 and high are swapped
		swap(arr, i + 1, high);

		// i + 1 are returned
		return i + 1;
	}

	public static void main(String[] args) {
		int[] array = {1,5,2,7,8,3,6,8,3,6,2,6,2};

		System.out.println(Arrays.toString(quickSort(array, 0, 12)));
	}





}