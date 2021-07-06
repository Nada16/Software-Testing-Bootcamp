package Unit3Module4;

public class StaticBlock {
	//Create a static variable.
	static int j = 10;
	private static int n = 80;
	
	//Create a static block.
	static {
		System.out.println("Static block initialized");
	}
	
	public static void main(String[] args) {
		System.out.println("inside main method");
		
		//Display the values of the variable.
        System.out.println("Value of j : " + j);; 
        System.out.println("Value of n : " + n);; 
	}
}
