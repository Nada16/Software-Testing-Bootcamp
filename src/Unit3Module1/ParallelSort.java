package Unit3Module1;

import java.util.Arrays;

public class ParallelSort {

	public static void main(String[] args) {
		//Creating an array
		int[] arr = {40,20,60,10,50,30};
		//Printing unsorted Array
		System.out.println("Unsorted Array: " + Arrays.toString(arr));
		//Using parallelSort method sort the array
		Arrays.parallelSort(arr);
		//Printing sorted Array
		System.out.println("Sorted Array: " + Arrays.toString(arr));
	}

}
