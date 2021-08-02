package Session15;

import java.util.Arrays;

public class IndianCoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		
		int amount = 50;
		
		int minCoins = 0;
		
		while(amount > 0) {
			int index = Arrays.binarySearch(arr, amount);
			
			//if element is not found, search for it's lower bound
			if(index < 0) {
				index = Math.abs(index) - 2; //lowerbound
			}
			
			amount -= arr[index];
			
			System.out.print(arr[index] + " + ");
			minCoins++;
		}
		
		System.out.println();
		System.out.println(minCoins);
	}

}
