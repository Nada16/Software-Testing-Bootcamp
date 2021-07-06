package Unit3Module5;

public class RuntimeExceptionExample{
	//Subclass and extend RuntimeException class.
	@SuppressWarnings("serial")
	static class RuntimeExcep extends RuntimeException {
		//Constructor of this class.
		public RuntimeExcep(String msg) {
			System.out.println(msg);
		}
	}

	//Throw exception
	public static void throwException() throws RuntimeException{
		new RuntimeExcep("example of runtime exception");
	}
	

	public static void main(String[] args) {
		int[] arr = new int[1];
		//Catch exception.
		try {
			arr[0] = 1;
			arr[1] = 3;
		} catch (RuntimeException e) {throwException();}	
	}
}
