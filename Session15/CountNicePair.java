package Session15;

import java.util.HashMap;
import java.util.Map;

public class CountNicePair {

	private static int rev(int num) {
		// TODO Auto-generated method stub

		int revNum = 0;

		while (num > 0) {
			int digit = num % 10;
			num = num / 10;

			revNum = revNum * 10 + digit;
		}

		return revNum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 42, 11, 1, 97, 97 };
		int n = arr.length;

		Map<Integer, Integer> map = new HashMap<>();

		int count = 0;
		for (int curr = 0; curr < arr.length; curr++) {
			int search = arr[curr] - rev(arr[curr]);

			if (map.containsKey(search)) {
				// got the pair

				count += map.get(search);

			}

			map.put(search, map.getOrDefault(search, 0) + 1);
		}

		System.out.println(count);
	}

}
