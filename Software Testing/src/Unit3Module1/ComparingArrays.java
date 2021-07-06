package Unit3Module1;

import java.util.Arrays;

public class ComparingArrays {
	public static void main(String[] args) {
		Integer[] arr1 = {1,2,3,4,5,6};
		Integer[] arr2 = {4,5,6,7,8,9};
		Integer[] arr3 = {1,2,3,4,5,6};

		System.out.println("The result of comparing different arrays: " + Arrays.equals(arr1, arr2));
		System.out.println("The result of comparing two arrays with the same elements: " + Arrays.equals(arr1, arr3));
	}
}
