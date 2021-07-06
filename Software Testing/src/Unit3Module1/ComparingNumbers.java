package Unit3Module1;

import java.util.Scanner;

public class ComparingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the first number:");
		Integer num1 = in.nextInt();		
		System.out.println("Enter the second number:");
		Integer num2 = in.nextInt();
		System.out.println("The result of comparing " + num1 + " and " + num2 + " is: " + num1.equals(num2));
		in.close();
	}

}
