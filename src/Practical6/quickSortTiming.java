package src.Practical6;


import src.Practical5.mergeSort;

import java.util.Random;

public class quickSortTiming {

	/**
	 * Method to check if a given array is in order
	 *
	 * @param array Array to check
	 * @return Boolean result of if the array is sorted
	 */
	public static boolean isOrdered(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}


	/**
	 * Method to generate an array of random integers
	 *
	 * @param n Size of array to generate
	 * @return Random array
	 */
	public static int[] randomArray(int n) {
		int[] array = new int[n];
		Random random = new Random();

		for (int i = 0; i < n; i++) {
			array[i] = random.nextInt(n);
		}
		return array;
	}


	/**
	 * Method to record the time taken to sort random arrays with sorting algorithms
	 */
	public static void sortingTiming() {

		int n = 10;
		int[] randomArray;
		long startTime;
		long endTime;
		long elapsedTime;
		int[] result;

		while (n < 100000) {
			randomArray = randomArray(n);
			startTime = System.nanoTime();
			result = quickSort.quickSort(randomArray, 0, randomArray.length-1);
			endTime = System.nanoTime();
			elapsedTime = endTime - startTime;
			System.out.println("Quick Sort- " + "Size: " + n + " Is Sorted: " + isOrdered(result) + " Time: " + elapsedTime);


			startTime = System.nanoTime();
			result = mergeSort.mergeSort(randomArray);
			endTime = System.nanoTime();
			elapsedTime = endTime - startTime;
			System.out.println("Merge Sort - " + "Size: " + n + " Is Sorted: " + isOrdered(result) + " Time: " + elapsedTime);
			n *= 2;
		}
	}

	public static void main(String[] args) {
		sortingTiming();
	}
}