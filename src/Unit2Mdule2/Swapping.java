package Unit2Mdule2;
import java.util.Scanner;

public class Swapping {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter value x:");
		int x = in.nextInt();
		System.out.print("Enter value y:");
		int y = in.nextInt();
		
		System.out.println("Before Swapping");
		System.out.println("Value of X is: " + x);
		System.out.println("Value of Y is: " + y);
		
		//Swap x and y without a temp variable
		x += y;
		y = x - y; //y value is updated
		x -= y; //x value is updated
		
		System.out.println("After Swapping");
		System.out.println("Value of X is: " + x);
		System.out.println("Value of Y is: " + y);
		
		in.close();
	}
}
