package Unit3Module3;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		//Declare TreeMap
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		//Adding elements to the TreeMap you created.
		map.put(1, "Tester1");
		map.put(2, "Tester4");
		map.put(4, "Tester4");
		map.put(23, "Tester2");
		map.put(70, "Tester3");
		
		//Display the content of your TreeMap using Iterator.
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Entry <Integer, String> e = it.next();
			System.out.println("key is: " + e.getKey() + " & Value is: " + e.getValue());
		}
	}
}
