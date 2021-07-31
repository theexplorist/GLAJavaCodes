package Session14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
		String[] str = {"aaaaaaaaaab", "acccccccccc"};
		int n = str.length;

		Map<String, List<String>> map = new HashMap<>();

		for (String currString : str) {

			int[] freqArray = new int[26];
			for(int i = 0; i < currString.length(); i++) {
				char cc = currString.charAt(i);//'a' -> index 0
				int index = cc - 'a';
				
				freqArray[index]++;
			}
			
			System.out.println(currString + "->" + Arrays.toString(freqArray));
			StringBuilder sb = new StringBuilder();
			
			for(int e : freqArray) {
				sb.append(e);
				sb.append("|");
			}
			
			String key = Arrays.toString(freqArray);

			/*
			 * char[] currStringArray = currString.toCharArray();
			 * Arrays.sort(currStringArray);
			 * 
			 * // System.out.println(Arrays.toString(currStringArray)); String
			 * sortedStringKey = new String(currStringArray); //
			 * System.out.println(sortedStringKey);
			 * 
			 */
			List<String> anaList;
			if (map.containsKey(key)) {
				anaList = map.get(key);
			} else {
				anaList = new ArrayList<>();
			}

			anaList.add(currString);
			map.put(key, anaList);
		}

		System.out.println(map);

		System.out.println(map.values());

		List<List<String>> ans = new ArrayList<>(map.values());
	}

}
