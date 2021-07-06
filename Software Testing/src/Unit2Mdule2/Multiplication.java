package Unit2Mdule2;
import java.util.Scanner;

public class Multiplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first number:");
		int a = in.nextInt();
		System.out.println("Enter the second number:");
		int b = in.nextInt();
		
		System.out.println("The product of these two numbers is " + (a*b));
		
		in.close();
	}

}
