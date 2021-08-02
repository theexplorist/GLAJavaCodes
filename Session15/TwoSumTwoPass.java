package Session15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumTwoPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {3, 3};
		int target = 6;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		//value - index
		
		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		
		System.out.println(map);
		
		//searching curr -> me, target - arr[curr]
		int[] pair = new int[2];
		for(int curr = 0; curr < arr.length; curr++) {
			int search = target - arr[curr];
			
			if(map.containsKey(search) && curr != map.get(search)) {
				//got the pair
				
				
				pair[0] = curr;
				pair[1] = map.get(search);
				break;
			}
		}
		
		System.out.println(Arrays.toString(pair));
		
	}

}
