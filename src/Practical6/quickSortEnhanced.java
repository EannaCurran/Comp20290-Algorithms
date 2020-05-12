
package src.Practical6;

import java.util.Arrays;

import static src.Practical4.sortingAlgorithms.insertionSort;

public class quickSortEnhanced {

	/**
	 * Implementation of an enhanced version of quick SORT
	 * @param arr: Array to be sorted
	 * @param low: First index of the array
	 * @param high: Last index of the array
	 * @return Sorted array
	 */
	public static int[] quickSortEnhanced(int[] arr, int low, int high) {

		// Declares cutoff for when insertion sort will be used over quick sort
		int CUTOFF = 10;

		// If the size of the array is less than the cutoff then insertion sort is used to sort the array
		if (high <= low + CUTOFF) {
			insertionSort(arr);
			return arr;
		}

		// Checks if there are still recursive calls divide the array to be made
		if (low < high) {

			// Finds the medium between the low,high and the middle index
			int medium = medianOfThree(arr, low, low + (high - low) / 2, high);

			// Swaps the low and medium indexes
			swap(arr, low, medium);

			// Partitions the array between the high and low values
			int pi = partition(arr, low, high);

			// Recursive call to quick sort the first half ot the array
			quickSortEnhanced(arr, low, pi - 1);

			// Recursive call to quick sort the second half of the array
			quickSortEnhanced(arr, pi + 1, high);
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
	 * Method to find the medium of thee numbers on an array
	 * @param arr: Array containing numbers to be compared
	 * @param low: First index of number to be checked
	 * @param middle: Second index of number to be checked
	 * @param high: Third index of number to be checked
	 * @return Index containing the medium number of numbers at index low, middle and high
	 */
	private static int medianOfThree(int[] arr, int low, int middle, int high) {

		// Checks element at low is greater than element at high
		if (arr[low] > arr[middle]) {

			// Returns middle if the element at middle is greater than the element at high
			if (arr[middle] > arr[high]) {

				return middle;
			}

			// Returns high when the element at low is greater than high
			else if (arr[low] > arr[high]) {

				return high;
			}

			// Otherwise, the element at low is the medium and low is returned
			else {
				return low;

			}
		}


		else {

			// Returns low if the element at low is greater than the element at high
			if (arr[low] > arr[high]) {

				return low;
			}

			// Returns high if the element at middle is greater than the element at high
			else if (arr[middle] > arr[high]) {

				return high;
			}

			// Otherwise middle is returned
			else {

				return middle;
			}
		}
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
		int[] array = {1, 5, 2, 7, 8, 3, 6, 8, 3, 6, 2, 6, 2};

		System.out.println(Arrays.toString(quickSortEnhanced(shuffle(array), 0, 12)));
	}




	/**
	 * Method to randomly shuffle a given array
	 * @param a: Array to be shuffled
	 * @return Shuffled array
	 */
	public static int[] shuffle(int[] a) {

		// Declaring variable to hold the length of a
		int n = a.length;


		// Loops through each index of a
		for (int i = 0; i < n; i++) {

			// Generates a random int within the range of i
			int r = (int) (Math.random() * (i + 1));

			// Swaps elements at index i and r
			swap(a, i, r);
		}

		// Returns the shuffled array
		return a;
	}
}

