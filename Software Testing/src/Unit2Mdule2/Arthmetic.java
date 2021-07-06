package Unit2Mdule2;
import java.util.Scanner;

public class Arthmetic {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter value a:");
		int a = in.nextInt();
		System.out.print("Enter value a:");
		int b = in.nextInt();
		
		System.out.println("The result of adding is " + (a+b) + "."); 
		System.out.println("The result of subtracting is " + (a-b) + "."); 
		System.out.println("The result of multiplying is " + (a*b) + "."); 
		System.out.println("The result of dividing is " + (a/b) + "."); 

		in.close();
	}

}
