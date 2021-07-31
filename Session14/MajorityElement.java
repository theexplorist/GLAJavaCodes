package Session14;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		
		int n = arr.length;
		
		Map<Integer, Integer> fre = new HashMap<>();//element - freq
		
		for(int e : arr) {
			if(fre.containsKey(e)) {
				int value = fre.get(e);
				value++;
				fre.put(e, value);
			} else {
				fre.put(e, 1);
			}
		}
		
		System.out.println(fre);
		
		int threshold = n / 2; //3
		
		for(var entryPair : fre.entrySet()) {
			if(entryPair.getValue() > threshold) {
				System.out.println(entryPair.getKey());
				break;
			}
		}
		
		for(var key : fre.keySet()) {
			if(fre.get(key) > threshold) {
				System.out.println(key);
				break;
			}
		}
		
	}

}
