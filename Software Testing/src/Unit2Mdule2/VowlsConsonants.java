package Unit2Mdule2;
import java.util.Scanner;

public class VowlsConsonants {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		for(int i = 0; i < 3; i++) {
			System.out.println("Enter a character:");

			char ch = in.next().charAt(0);
			char chLower = Character.toLowerCase(ch);

			if((chLower >= 'a' && chLower <= 'z')) {
				switch(chLower) {
				case'a':
				case'e':
				case'i':
				case'o':
				case'u':
					System.out.println("Entered character " + ch + " is Vowel");
					break;
				default:
					System.out.println("Entered character " + ch + " is Consonant");		
				}
			} else {
				System.out.println("This is not a letter!");		
			}
		}
		in.close();
	}

}
