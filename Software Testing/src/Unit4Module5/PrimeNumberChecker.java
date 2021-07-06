package Unit4Module5;

public class PrimeNumberChecker {
	private boolean isPrime;
	
	public boolean checkPrime(int num) {
		isPrime = true;
		
		for(int i = 2; i < (num/2) ; i++) {
			if(num % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
	
}
