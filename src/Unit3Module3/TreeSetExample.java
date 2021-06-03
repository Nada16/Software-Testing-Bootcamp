package Unit3Module3;

import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		//Create a tree set.
		TreeSet<String> set = new TreeSet<String>();
		
		//Add elements to the tree set
		//Note: treeSet orders the elements in their natural ascending order
		set.add("Java");
		set.add("C#");
		set.add("Python");
		set.add("R");
		set.add("Javascript");
		set.add("SQL");

		//Display the elements of the tree set 
		System.out.println(set.toString());
	}
}
