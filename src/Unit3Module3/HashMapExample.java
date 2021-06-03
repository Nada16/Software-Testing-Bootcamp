package Unit3Module3;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapExample {

	public static void main(String[] args) {
		//Create a HashMap.
		HashMap<Integer, String> map = new HashMap< Integer, String>();
		
		//Put elements into the map you created.
		map.put(1, "Grapes");
		map.put(2, "Orange");
		map.put(3, "Banana");
		map.put(4, "Pineapple");
		
		//Try to duplicate a key.
		map.put(2, "Apple");

		//Display the key.
		System.out.println("Iterating Hashmap...");
		for(Entry<Integer, String> e: map.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}
