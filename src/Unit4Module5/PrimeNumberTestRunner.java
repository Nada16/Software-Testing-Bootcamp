package Unit4Module5;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PrimeNumberTestRunner {
	
	public static void main(String[] args) {
		
		// -------- Verify output for PrimeNumberChecker --------------
		System.out.println("Prime numbers: ");                 
		Result primeResult = JUnitCore.runClasses(TestPrimeNumber.class);

		//If any assertion failed it'll enter this for loop
		for (Failure failure : primeResult.getFailures()) {
			//Print the error message of the failure
			System.out.println(failure.toString());
		}

		//Print out the state of the result (Successful or not)
		System.out.println("\nTesting 'PrimeNumberChecker' was succesful? " 
		+ primeResult.wasSuccessful());
		
	}
	
}
