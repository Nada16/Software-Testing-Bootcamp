package Unit2Mdule2;
import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			System.out.println("Enter a year:");
			int year = in.nextInt();
			if(year%4 == 0) {
				System.out.println("The specified year is a leap year\n");
			}else {
				System.out.println("The specified year is not a leap year\n");
			}
		}
		in.close();
	}

}
