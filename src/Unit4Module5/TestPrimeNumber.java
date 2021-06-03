package Unit4Module5;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//Annotate Test class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class TestPrimeNumber {
	//Declare variables
	private int num;
	private boolean isPrime;
	private PrimeNumberChecker checker = new PrimeNumberChecker();

	//Create a public constructor that takes in one "row" of test data
	public TestPrimeNumber(int num, boolean isPrime) {
		this.num = num;
		this.isPrime = isPrime;

	}

	//Create a public static method annotated with @Parameters 
	//It returns a Collection of Objects (as Array) as test data set
	/* An instance variable for each "column" of test data will be created 
	 * automatically because of @parameters */
	@Parameters
	public static Collection<Object[]> checkNumbers() {
		return Arrays.asList(new Object[][] {
			{ 2, true },
			{ 6, false },
			{ 19, true },
			{ 22, false },
			{ 23, true }
		});
	}

	//Create your test case(s) using the instance variables as the source of the test data
	@Test
	public void test() {
		System.out.print("Number is: " + num);
		if(isPrime) {
			System.out.println(" and it is prime");
		}else {
			System.out.println(" and it is NOT prime");
		}
		
		assertEquals(isPrime, checker.checkPrime(num));
	}
}