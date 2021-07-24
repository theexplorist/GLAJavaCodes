package Session8;

import java.util.Arrays;
import java.util.Scanner;

public class KnapsackZeroOne {

	private static int maxProfit(int[] price, int[] weight, int bagC, int curr, int[][] dp) {
		// TODO Auto-generated method stub

		if(bagC == 0 || curr == price.length) {
			return 0;
		}
		
		if(dp[curr][bagC] != -1) {
			return dp[curr][bagC];
		}
		int rob = 0, dontRob = 0;
		
		if(weight[curr] <= bagC) {
			rob = price[curr] + maxProfit(price, weight, bagC - weight[curr], curr + 1, dp);
		}
		
		dontRob = maxProfit(price, weight, bagC, curr + 1, dp);
		
		return dp[curr][bagC] =  Math.max(rob, dontRob);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int bagC = s.nextInt();
		int[] price = new int[n];
		int[] wt = new int[n];
		
		for(int i = 0; i < n; i++ ) {
			wt[i] = s.nextInt();
		}
		
		for(int i = 0; i < n; i++ ) {
			price[i] = s.nextInt();
		}
		
		int[][] dp = new int[n + 1][bagC + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(maxProfit(price, wt, bagC, 0, dp));
	}

}
