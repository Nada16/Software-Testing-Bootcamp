package Unit3Module5;

public class ForcedException {

	public static void main(String[] args) {
		divide(2, 2);
	}

	public static void divide (int a, int b) {
		System.out.println("Dividing " + a + " by " + b);
		try {
			if(b == 0) {
				//cannot divide by zero
				//IllegalArgumentException
				throw new IllegalArgumentException(Integer.toString(b));
			}else {
				System.out.println("The answer is: " + (a/b));
			}
		}
		catch( IllegalArgumentException e) {
			//Show the Error message
			System.out.println("Illegal Argument Exception because divisor is: " + e.getMessage());
		}
		finally {
			//When exit try and catch block prints out all done
			System.out.println("All done");
		}
	}
}


