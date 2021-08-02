package Session15;

import java.util.Arrays;

public class BinarySearchUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 5, 5, 5, 10, 20};
		
		int search = 5;
		
		int index  = Arrays.binarySearch(arr, search);
		//System.out.println(index);
		
		if(index < 0) {
			int lowerBound = Math.abs(index) - 2;
			int upperBound = Math.abs(index) - 1;
			
			System.out.println(lowerBound + " " + upperBound);
		}
		
	}

}
