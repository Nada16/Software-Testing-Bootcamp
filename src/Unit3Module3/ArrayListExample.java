package Unit3Module3;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		//Define a new ArrayList and initialize it
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(7);
		list.add(9);
		
		//Print the ArrayList
		System.out.println("Initial ArrayList:\n" + list.toString());
		
		//Add elements to the beginning of the list
		list.add(0, 3);
		list.add(0, 1);
		
		//Print the updated ArrayList
		System.out.println("ArrayList after adding elements at the beginning:\n" + list.toString());

	}

}
