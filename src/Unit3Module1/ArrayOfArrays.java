package Unit3Module1;

import java.util.Arrays;

public class ArrayOfArrays {

	public static void main(String[] args) {
		int[][] arr = {{5,7,6,4},{1,3,1,8,6},{9,2,3,5}};
		for(int[] subArr : arr) {
			System.out.println(Arrays.toString(subArr));
		}
	}

}
