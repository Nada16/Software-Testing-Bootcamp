package Unit2Module5;

public class Test {
	public static void main(String[] args) {
		System.out.println(fib(4));
	}
	
	//0,1,1,2,3,5,8,
	public static int fib(int n) {
		if(n == 0 || n == 1) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}
}
