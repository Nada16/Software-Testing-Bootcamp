package Unit4Module4;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

//TestRunner Class
public class TestRunner {
	public static void main(String[] args) {
		// -------- Verify output for assertion --------------
		System.out.println("Assertion testing: ");                 
		Result result = JUnitCore.runClasses(TestAssertions.class);

		//If any assertion failed it'll enter this for loop
		for (Failure failure : result.getFailures()) {
			//Print the error message of the failure
			System.out.println(failure.toString());
		}
		//Print out the state of the result (Successful or not)
		System.out.println(result.wasSuccessful());

		
		// -------- Verify output for annotation --------------
		System.out.println("\n\nAnnotation testing: ");                
		Result annotationResult = JUnitCore.runClasses(JunitAnnotation.class);

		//If anything failed from the annotation class it'll enter this for loop
		for (Failure failure : annotationResult.getFailures()) {
			//Print the error message of the failure
			System.out.println(failure.toString());
		}
		//Print out the state of the result (Successful or not)
		System.out.println(annotationResult.wasSuccessful());
	}
}