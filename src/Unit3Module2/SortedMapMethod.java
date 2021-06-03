package Unit3Module2;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapMethod {

	public static void main(String[] args) {
		//Create a sorted map
		SortedMap<String, Double> map = new TreeMap<String, Double>();
		
		//Put elements to the map
		map.put("Ayan", 1378.0);
		map.put("Daisy", 99.22);
		map.put("Mahnaz", 123.22);
		map.put("Qadir", -19.08);
		map.put("Zara", 3434.34);
				
		//Get an iterator (set of keys)
		Iterator<String> iterator = map.keySet().iterator();
		String key;
		
		//Display elements
		while(iterator.hasNext()) {
			key = iterator.next();
			//Print every key with its value:(map.get(key))
			System.out.println(key + ": " + map.get(key));
		}
		
		//Change a key's value
		map.replace("Zara", 4434.34);
		System.out.println("\nZara's new balance: " + map.get("Zara"));
		
	}

}
