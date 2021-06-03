package Unit3Module2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMethod {

	public static void main(String[] args) {
		//Create a queue
		Queue<Integer> queue = new LinkedList<>();
		queue.add(6);
		queue.add(1);
		queue.add(8);
		queue.add(4);
		queue.add(7);
		
		//Display element in the queue
		System.out.println("The queue is: " + queue);

		//Delete head from the queue
		System.out.println("The element deleted from the head is: " + queue.remove());
		
		//Display Queue after deletion
		System.out.println("The queue after deletion is: " + queue);

		//Display the head of the queue
		System.out.println("The head of the queue is: " + queue.peek());

		//Display the size of the queue after the deletion
		System.out.println("The size of the queue is: " + queue.size());

	}

}

