package Unit3Module3;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {

	public static void main(String[] args) {
		//Declare a hashSet and add elements to it
		HashSet<String> set = new HashSet<String>();
		set.add("Saudi Arabia");
		set.add("USA");
		set.add("South Africa");

		//Add duplicate elements to the HashSet.
		set.add("Saudi Arabia");
		
		//Display the contents of the HashSet
		System.out.println(set.toString());
		
		//Check if HashSet contains USA
		System.out.println("List contains USA or not:" + set.contains("USA"));

		//Removing items from the HashSet
		set.remove("South Africa");
		System.out.println("List after removing South Africa:" + set.toString());

		//Iterating through all of the elements in the HashSet
		System.out.println("Iterating over list:");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
