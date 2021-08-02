package Session15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumOnePass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2, 7, 11, 15};
		int target = 14;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int[] pair = new int[2];
		for(int curr = 0; curr < arr.length; curr++) {
			int search = target - arr[curr];
			
			if(map.containsKey(search)) {
				//got the pair
				
				
				pair[0] = map.get(search);
				pair[1] = curr;
				break;
			}
			
			map.put(arr[curr], curr);
		}
		
		System.out.println(Arrays.toString(pair));
	}

}
