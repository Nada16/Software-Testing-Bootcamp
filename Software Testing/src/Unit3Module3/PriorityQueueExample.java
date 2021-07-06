package Unit3Module3;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

	public static void main(String[] args) {
		//Initialize the PriorityQueue with values
		PriorityQueue<String> que = new PriorityQueue<String>();
		que.add("California");
		que.add("Melbourne");
		que.add("Sydney");
		que.add("Venice");
		que.add("New York");
		
		//Print the head of the PriorityQueue
		System.out.println("PriorityQueue Head:" + que.peek());
		
		//Define the iterator for the PriorityQueue
		Iterator<String> it = que.iterator();
		
		//Print out all of the PriorityQueue elements
		System.out.println("\nPriorityQueue contents:");
		while(it.hasNext()) {
			System.out.print(it.next() + "   ");
		}
	}
}
