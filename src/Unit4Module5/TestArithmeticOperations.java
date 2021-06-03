package Unit4Module5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//Create TestCase class
public class TestArithmeticOperations {
	//Test Data
	int num1 = 23;
	int num2 = 0;
	
	//Testing ArithmeticOperations class
	ArithmeticOperations ao = new ArithmeticOperations();
	
	//@Test -divideNumbers with arithmetic exception
	@Test(expected = ArithmeticException.class)
	public void testDivide() {
		System.out.println("\nWithin testDevide()");
		
		//Check what the method returns
		//There should be an exception because of dividing by zero
		assertEquals(ao.divideNumbers(num1, num2), num1/num2);
	}
	
	//@Test -addNumbers
	@Test
	public void testAdd() {
		System.out.println("\nWithin testAdd()");
		
		//Check what the method returns
		assertEquals(ao.addNumbers(num2, num1), num2+num1);
	}
}
