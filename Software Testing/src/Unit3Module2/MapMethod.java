package Unit3Module2;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {

	public static void main(String[] args) {
		//Create a map that maps age to name
		Map<String, Integer> map = new HashMap<>();
		map.put("Daisy", 14);
		map.put("Ayan", 12);
		map.put("Zara", 8);
		map.put("Mahnaz", 31);
		
		//Print the elements of the map
		System.out.println("Map Elements\n\t" + map.toString());
	}

}
