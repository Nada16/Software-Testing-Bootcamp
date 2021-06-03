package Unit3Module2;
import java.util.*;

public class arrayListModification {

	public static void main(String[] args) {
		//Create a list of numbers
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 5; i++) {
			numbers.add(i);
		}

		//Create an iterator for (numbers)
		ListIterator<Integer> iterator = numbers.listIterator();
		
		//print list in original order
		System.out.print("List in original order: ");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + "  ");
		}	
		//print list in reverse order
		System.out.print("\nList in reverse order: ");
		while(iterator.hasPrevious()) {
			System.out.print(iterator.previous() + "  ");
		}
		
		//Remove an item from the list 
		numbers.remove((Integer)4);
		//or the following will remove the same element
		//numbers.remove(3);
		System.out.print("\nList after removing: " + numbers);
		/*
		 * Note for the remove method: 
		 * if value needs to be removed use (Integer) 
		 * if number w/o (Integer) item with index will be removed
		 */
	}
}
