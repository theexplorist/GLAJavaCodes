package Session14;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Map<K, V>

		Map<String, Integer> popMap = new HashMap<>();

		// put(k, v)
		popMap.put("India", 20);

		popMap.put("USA", 10);

		// get(k)

		int indiaPop = popMap.get("India");
		System.out.println(indiaPop);

		// containsKey(key) -> true / false
		if (popMap.containsKey("Australlia")) {
			System.out.println(popMap.get("Australlia"));
		}
		// System.out.println(popMap.get("Australlia").intValue()); //null.intValue()

		int size = popMap.size();
		System.out.println(size);
		System.out.println(popMap);

		popMap.put("India", 30);// updation if already present
		System.out.println(popMap);

		// remove(key)
		popMap.remove("USA");

		System.out.println(popMap);

		popMap.put("Australlia", 10);
		popMap.put("UK", 6);
		System.out.println(popMap);

//		var a = 5;
//		System.out.println(a);
		// iterating over hashmap
		System.out.println(popMap.entrySet()); // Set DS is iterable

		for (var keyValuePair : popMap.entrySet()) {
			// System.out.println(keyValuePair);

			// key print getKey()
			// value print getValue()
			System.out.println(keyValuePair.getKey() + " ki population hai " + keyValuePair.getValue());
		}
		
		//keySet()
		
		//System.out.println(popMap.keySet());
		
		for(String key : popMap.keySet()) {
			System.out.println(key + " " + popMap.get(key));
		}
		
		

	}

}
