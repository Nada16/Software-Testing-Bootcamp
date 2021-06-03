package Unit3Module2;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeueMethod {
	public static void main(String[] args) {
		//Create Dequeue
		Deque<Integer> deque = new LinkedList<>();
		deque.add(6);
		deque.add(7);
		deque.add(1);
		deque.add(5);
		deque.add(9);
		deque.add(8);
		deque.add(2);

		//Display elements in the dequeue
		System.out.println("The dequeue is: " + deque);
		
		//Display elements in the dequeue using an iterator
		Iterator<Integer> iterator = deque.iterator();
		System.out.print("\nDequeue using standard Iterator:");
		while(iterator.hasNext()) {
			System.out.print(" " + iterator.next());
		}
		
		//Find the head of deque using peek
		System.out.println("\n\nUsing peek, the elemnt at head of the dequeue is: " + deque.peek());
		System.out.println("The dequeue after peek: " + deque);
		
		//Remove head using pop
		System.out.println("\nUsing pop, the element removed from the head of the dequeue is: " + deque.pop());
		System.out.println("The dequeue after pop: " + deque);
		
		//Search deque for 8
		System.out.println("\nDoes the dequeue contain element 8: " + deque.contains(8));
		
		//Remove first and last elements
		deque.removeFirst();
		deque.removeLast();
		System.out.println("\nDequeue after removing the first and last elements is: " + deque);
	}
}
