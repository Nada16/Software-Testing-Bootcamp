package Unit4Module5;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

//Create TestRunner class
public class ArithmeticTestRunner {

	public static void main(String[] args) {
		
		// -------- Verify output for ArithmeticOperations --------------
		System.out.println("Arithmetc Exception: ");                 
		Result result = JUnitCore.runClasses(TestArithmeticOperations.class);

		//If any assertion failed it'll enter this for loop
		for (Failure failure : result.getFailures()) {
			//Print the error message of the failure
			System.out.println(failure.toString());
		}
		
		//Print out the state of the result (Successful or not)
		System.out.println("\nTesting 'ArithmeticOperations' was succesful? " 
		+ result.wasSuccessful());
	
	}

}
