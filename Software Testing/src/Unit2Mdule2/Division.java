package Unit2Mdule2;
import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a value for the dividend:");
		int divide = in.nextInt();
		System.out.println("Enter a value for the divisor:");
		int by = in.nextInt();
		
		System.out.println("Quotient value: " + (divide/by));
		System.out.println("Remainder value: " + (divide%by));
		
		in.close();
	}

}
