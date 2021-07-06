package Unit3Module2;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetInterface {

	public static void main(String[] args) {
		//Create the sorted set
		SortedSet<Character> sorted = new TreeSet<>();
		
		//Add elements to the set
		sorted.add('a');
		sorted.add('c');
		sorted.add('b');
		
		//Iterating over the elements in the set
		Iterator<Character> iterator = sorted.iterator();
		//Display  element		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
