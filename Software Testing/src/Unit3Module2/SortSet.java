package Unit3Module2;

import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class SortSet {
	public static void main(String[] args) {
		//Create a set of numbers
		Set<Integer> lst = new HashSet<>();
		lst.add(34);
		lst.add(22);
		lst.add(10);
		lst.add(60);
		lst.add(30);
		//Print unsorted set
		System.out.println(lst.toString());
		
		//Sort the set by converting it to tree set
		TreeSet<Integer> treeLst = new TreeSet<>(lst);

		//Print sorted set and first and last elements
		System.out.println("The sorted list is:\n" + treeLst.toString());
		System.out.println("The First element of the set is: " + treeLst.first());
		System.out.println("The last element of the set is: " + treeLst.last());
	}
}
