package Unit3Module1;
import java.util.Arrays;

public class CoppyingArray {
	public static void main(String[] args) {
		int[] originalArray = {25, 14, 56, 15, 36};
		
		//Using an assignment operator
		int[] arr1 = originalArray;
		
		//Iterating through each array item by item
		int[] arr2 = new int[originalArray.length];
		for(int i = 0; i < originalArray.length; i++) {
			arr2[i] = originalArray[i];
		}
		
		//Using the clone method
		int[] arr3 = originalArray.clone();
		
		//using the arraycopy method
		int[] arr4 = new int[originalArray.length];
		System.arraycopy(originalArray, 0, arr4, 0, originalArray.length);
		
		System.out.println("Original array: " + Arrays.toString(originalArray));
		System.out.println("Copied array technique 1: " + Arrays.toString(arr1));
		System.out.println("Copied array technique 2: " + Arrays.toString(arr2));
		System.out.println("Copied array technique 3: " + Arrays.toString(arr3));
		System.out.println("Copied array technique 4: " + Arrays.toString(arr4));

	}
}
