package Session14;

import java.util.HashMap;
import java.util.Map;

public class NewFunctionsMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Integer> popMap = new HashMap<>();

		// put(k, v)
		popMap.put("India", 20);

		popMap.put("USA", 10);
		
		System.out.println(popMap);
		
		int australliaPop = popMap.getOrDefault("USA", 0);
		System.out.println(australliaPop);
		System.out.println(popMap);
		
		//putIfAbsent
		popMap.putIfAbsent("USA", 20);
		System.out.println(popMap.get("USA"));
		
	}

}
