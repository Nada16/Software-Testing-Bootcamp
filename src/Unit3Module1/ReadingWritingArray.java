package Unit3Module1;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingWritingArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter row for the array (max 10) : ");
		int row = in.nextInt();
		
		System.out.print("Enter column for the array (max 10) : ");
		int col = in.nextInt();
		
		int arr[][] = new int[row][col];
		System.out.println("Enter " + (row*col) + " Array Elements :");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		in.close();
		
		System.out.println("The Array is : ");
		for(int[] subArr : arr) {
			System.out.println(Arrays.toString(subArr));
		}
	}
}
