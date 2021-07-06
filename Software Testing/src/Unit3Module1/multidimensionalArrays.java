package Unit3Module1;

public class multidimensionalArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,2,3,4,5},{2,4,6,8,10},{3,6,9,12,15}};
		int sum = 0;
		
		for (int[] subArr: arr) {
			for (int i: subArr) {
				sum+=i;
				System.out.println("Value is: " + i);
			}
		}
		
		System.out.println("Summation: " + sum);
	}

}
