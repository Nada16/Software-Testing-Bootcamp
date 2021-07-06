package Unit3Module3;

public class ArrayOperation {

	public static void main(String[] args) {
		//Create an array
		double[] arr = {1.9, 2.9, 3.4, 3.5};
		
		//Print all elemnts of the array, calculate the total, and figure out the max element
		double sum = 0;
		double max = arr[0];
		for(double num: arr) {
			System.out.println(num);
			sum += num;
			if(num > max) {
				max = num;
			}
		}
		
		//Print sum and max
		System.out.println("Total is " + sum);
		System.out.println("Max is " + max);	
	}

}
