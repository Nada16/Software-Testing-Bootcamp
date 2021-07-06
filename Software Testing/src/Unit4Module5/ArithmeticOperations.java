package Unit4Module5;

public class ArithmeticOperations {
	private int result;
	
	//Adding numbers, printing result, and return it
	public int addNumbers(int x, int y) {
		System.out.println("Numbers to be added are: " + x + " and " + y);
		result = x+y;
		System.out.println( x + " + " + y + " = " + result);		
		return result;
	}

	//Divide numbers, printing result, and return it
	public int divideNumbers(int x, int y) {
		System.out.println("Numbers to be divided are: " + x + " and " + y);
		result = x/y;
		System.out.println( x + " / " + y + " = " + result);		
		return result;
	}
}

