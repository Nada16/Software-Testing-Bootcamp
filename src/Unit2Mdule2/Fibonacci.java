package Unit2Mdule2;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter length:");
		int len = in.nextInt();
		
		System.out.println("Fibonacci Series:");
		
		int num1 = 0;
		int num2 = 1;
		int num3 = 1;
		
		if(len >= 1) {
			System.out.print(num1 + "  ");
			if(len >= 2) {
				System.out.print(num2 + "  ");
				for(int i = 3; i <= len; i++) {
					System.out.print(num3  + "  ");
					num1 = num2;
					num2 = num3;
					num3 = num1+num2;
				}
			}
		}
		
		in.close();
	}

}
