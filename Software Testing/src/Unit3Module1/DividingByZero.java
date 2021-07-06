package Unit3Module1;

import java.util.Scanner;

public class DividingByZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Input two integers");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		int num;
		try {
			num = num1/num2;
			System.out.println("The division result is: " + num);
		}catch(Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
		in.close();
	}
}
