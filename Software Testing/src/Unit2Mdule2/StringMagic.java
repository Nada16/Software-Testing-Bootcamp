package Unit2Mdule2;
import java.util.Scanner;

public class StringMagic {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Text");
		String txt = in.nextLine();

		System.out.println("The Reverse String");
		for(int i = txt.length()-1; i >= 0; i--) {
			System.out.print(txt.charAt(i));
		}

		in.close();
	}

}
