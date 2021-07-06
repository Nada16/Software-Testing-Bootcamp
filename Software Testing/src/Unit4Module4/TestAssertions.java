package Unit4Module4;
import static org.junit.Assert.*;				
import org.junit.Test;		

// TestAssertions Class
public class TestAssertions {				

	@Test		
	public void testAssert(){					
		//Test data (variable declaration)		
		String str1="Nada";					
		String str2="Nada";			
		
		int smallNum = 10;
		int bigNum = 34;
		
		String nullString = null;
		
		int[] nums1 = { 1, 2, 3 };					
		int[] nums2 = { 1, 2, 3 };					
							
		//Assert statements	
		//Check that two objects are equal
		//Note: assertEquals performs .equal() on the objects
		assertEquals(str1,str2);			

		//Check that a condition is true
		assertTrue(bigNum > smallNum);					

		//Check that a condition is false
		assertFalse(bigNum < smallNum);
		
		//Check that an object isn't null
		assertNotNull(str2);			

		//Check that an object is null
		assertNull(nullString);
		
		//Check if two object references point to the same object
		//Note: assertSame performs (==) between the objects
		assertSame(str1, str2);					
		
		//Check if two object references not point to the same object
		assertNotSame(nums1, nums2);					
		
		//Check whether two arrays are equal to each other
		assertArrayEquals(nums1, nums2);						
	}		
}	
