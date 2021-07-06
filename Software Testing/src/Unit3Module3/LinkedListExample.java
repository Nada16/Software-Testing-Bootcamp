package Unit3Module3;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		//Create a linked list using the LinkedList class and elements to it
		LinkedList<String> list = new LinkedList<String>();
		list.add("Harry Potter");
		list.add("Lord of the Ring");
		list.add("Homealone");
		
		//Print the elements of the list
		System.out.println("LinkedList: " + list.toString());
		
		//Add an element to the beginning of your linked list.
		list.addFirst("Now You See Me");
		
		//Add an element to the end of your linked list.
		list.addLast("Interstellar");
		
		//Print the elements of the list
		System.out.println("LinkedList after addition: " + list.toString());
				
		//Access the first element of your linked list.
		System.out.println("First movie: " + list.getFirst());;
		
		//Access the last element of your linked list.
		System.out.println("Last movie: " + list.getLast());;
	}
}
