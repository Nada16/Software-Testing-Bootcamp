package Unit3Module1;

import java.util.Arrays;

public class FillArray {

	public static void main(String[] args) {
		int[] arr = {1,6,3,2,9};
		System.out.println("Actual values: " + Arrays.toString(arr));
		
		Arrays.fill(arr, 18);
		System.out.println("New values after using fill() method: " + Arrays.toString(arr));

	}

}
