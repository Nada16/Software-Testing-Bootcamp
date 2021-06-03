package Unit3Module2;

import java.util.ArrayList;
import java.util.Iterator;

public class IterateArrayList {

	public static void main(String[] args) {
		//Create an arraylist of names
		ArrayList<String> names = new ArrayList<String>();
		names.add("Nada");
		names.add("Lujain");
		names.add("Faisal");
		names.add("Haider");
		
		//Instantiate an iterator interface
		Iterator<String> iteratorList = names.iterator();
		
		//Display each element in the ArrayList using the iterator
		//note you can use for each to iterate instead of the iterator
		System.out.println("Names of ArrayList:");
		for(int i = 0; i < names.size(); i++) {
			System.out.print(iteratorList.next() + "  ");
		}
	}

}
