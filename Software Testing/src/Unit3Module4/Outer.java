package Unit3Module4;

public class Outer { 
	//Outer class
	//Static member.
	static int x = 10; 

	//Instance (non-static) member.
	int i = 88;   

	//Private member.
	private int p = 60; 
	static private int privateX = 30;

	//Static nested class.
	static class NestedStatic{    
		void accessMembers(Outer outer) { 
			//Can access Display static member of the outer class.
			System.out.println("outer_x = " + x);        
			
			//Can access display private static member of the outer class.
			System.out.println("outer_private = " + privateX); 

			//can only call static variables inside static methods        
			
			//System.out.println("OuterNoneStatic_i = " + i);      
			System.out.println("OuterNoneStatic_i = " + outer.i); 
			// ^ the second line has the true syntax to access non static non private variable
			
			//System.out.println("Inner_p = " + p); 
			System.out.println("Inner_p = " + outer.p); 
			// ^ the second line has the true syntax to access non static private variable
		}     
	}  

	public static void main(String[] args) { 
		//Accessing a static nested class.
		NestedStatic nestedStatic = new NestedStatic();              
		nestedStatic.accessMembers(new Outer());              
	}   
}
